package me.sakio.cosmetic.manager.menu;

import me.sakio.cosmetic.Cosmetic;
import me.sakio.cosmetic.manager.PlayerData;
import me.sakio.cosmetic.manager.objects.Gadgets;
import me.sakio.cosmetic.manager.objects.Trails;
import me.sakio.cosmetic.utils.InventoryUtils;
import me.sakio.cosmetic.utils.ItemMaker;
import me.sakio.cosmetic.utils.menu.type.ChestMenu;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

/**
 * Created by DevSakio
 * Project: Cosmetic
 * Date: 26/12/2020 @ 16:57
 * Class: CosmeticMainMenu
 */
public class CosmeticMainMenu extends ChestMenu<Cosmetic> {
    private final PlayerData playerData = Cosmetic.getInstance().getPlayerData();
    public CosmeticMainMenu() {
        super("Main Menu", 9*3);
        this.update();
    }
    public void update(){
        this.inventory.setItem(10, new ItemMaker(Material.LEATHER_CHESTPLATE).setColor(Color.RED).setTitle("&3Outfit")
                .setLore(Arrays.asList(
                        "",
                        " &3&lClick to see all outfit type!",
                        ""
                        )
                ).build());
        this.inventory.setItem(12, new ItemMaker(Material.BLAZE_ROD).setTitle("&4Trails")
                .setLore(Arrays.asList(
                        "",
                        " &3&lClick to see all trails type!",
                        ""
                        )
                ).build());
        this.inventory.setItem(14, new ItemMaker(Material.ARROW).setTitle("&5Gadgets")
                .setLore(Arrays.asList(
                        "",
                        " &3&lClick to see all gadgets type!",
                        ""
                        )
                ).build());
        this.inventory.setItem(16, new ItemMaker(Material.SKULL_ITEM).setSkullType(ItemMaker.SkullType.CREEPER).setTitle("&6Pets")
                .setLore(Arrays.asList(
                        "",
                        " &3&lClick to see all pets type!",
                        ""
                )).build());
        this.inventory.setItem(22, new ItemMaker(Material.REDSTONE).setTitle("&4Remove Cosmetic")
                .setLore(Arrays.asList(
                        "",
                        " &3&lClick to remove all cosmetic",
                        ""
                        )
                ).build());
        InventoryUtils.getFill(inventory);
    }

    @Override
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        Inventory topInventory = event.getView().getTopInventory();

        if (!topInventory.equals(this.inventory)) return;

        if (topInventory.equals(clickedInventory)) {
            event.setCancelled(true);

            ItemStack item = event.getCurrentItem();
            if (item == null || item.getType() == Material.AIR) return;

            Player player = (Player) event.getWhoClicked();

            switch (event.getRawSlot()) {
                case 10:
                    new OutfitMenu().open(player);
                    break;
                case 12:
                    new TrailsMenu().open(player);
                    break;
                case 14:
                    new GadgetsMenu().open(player);
                    break;
                case 16:
                    new PetsMenu().open(player);
                    break;
                case 22:
                    player.getInventory().setHelmet(null);
                    player.getInventory().setChestplate(null);
                    player.getInventory().setLeggings(null);
                    player.getInventory().setBoots(null);
                    playerData.setTrails(player, Trails.DEFAULT);
                    playerData.setGadgets(player, Gadgets.DEFAULT);
                    player.sendMessage(me.sakio.cosmetic.utils.Color.translate("&cAll cosmetic has been remove!"));
                    break;
            }
        }
    }
}
