package me.sakio.cosmetic.manager.menu;

import me.sakio.cosmetic.Cosmetic;
import me.sakio.cosmetic.utils.ArmorUtils;
import me.sakio.cosmetic.utils.InventoryUtils;
import me.sakio.cosmetic.utils.ItemMaker;
import me.sakio.cosmetic.utils.menu.type.ChestMenu;
import me.sakio.cosmetic.task.RainbowTask;
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
 * Date: 27/12/2020 @ 11:15
 * Class: OutfitMenu
 */
public class OutfitMenu extends ChestMenu<Cosmetic> {
    
    private final Cosmetic plugin = Cosmetic.getInstance();

    public OutfitMenu() {
        super("Outfit Menu", 9*6);
        this.update();
    }

    public void update(){
        this.inventory.setItem(11, new ItemMaker(Material.LEATHER_CHESTPLATE).setColor(Color.RED).setTitle("Red Armor")
                .setLore(Arrays.asList(
                        "",
                        " &3&lClick to set a &4&lRed Armors",
                        ""
                        )
                ).build());
        this.inventory.setItem(12, new ItemMaker(Material.LEATHER_CHESTPLATE).setColor(Color.BLUE).setTitle("Blue Armor")
                .setLore(Arrays.asList(
                        "",
                        " &3&lClick to set a &3&lBlue Armors",
                        ""
                        )
                ).build());
        this.inventory.setItem(13, new ItemMaker(Material.LEATHER_CHESTPLATE).setColor(Color.GREEN).setTitle("Green Armor")
                .setLore(Arrays.asList(
                        "",
                        " &3&lClick to set a &a&lGreen Armors",
                        ""
                        )
                ).build());
        this.inventory.setItem(14, new ItemMaker(Material.LEATHER_CHESTPLATE).setColor(Color.ORANGE).setTitle("Orange Armor")
                .setLore(Arrays.asList(
                        "",
                        " &3&lClick to set a &a&lOrange Armors",
                        ""
                        )
                ).build());
        this.inventory.setItem(15, new ItemMaker(Material.LEATHER_CHESTPLATE).setColor(Color.YELLOW).setTitle("Yellow Armor")
                .setLore(Arrays.asList(
                        "",
                        " &3&lClick to set a &6&lYellow Armors",
                        ""
                )).build());
        this.inventory.setItem(20, new ItemMaker(Material.LEATHER_CHESTPLATE).setColor(Color.BLACK).setTitle("Black Armor")
                .setLore(Arrays.asList(
                        "",
                        " &3&lClick to set a &a&lBlack Armors",
                        ""
                )).build());
        this.inventory.setItem(21, new ItemMaker(Material.LEATHER_CHESTPLATE).setColor(Color.AQUA).setTitle("Aqua Armor")
                .setLore(Arrays.asList(
                        "",
                        " &3&lClick to set a &a&lAqua Armors",
                        ""
                )).build());
        this.inventory.setItem(22, new ItemMaker(Material.LEATHER_CHESTPLATE).setColor(Color.PURPLE).setTitle("Purple Armor")
                .setLore(Arrays.asList(
                        "",
                        " &3&lClick to set a &a&lPurple Armors",
                        ""
                )).build());
        this.inventory.setItem(23, new ItemMaker(Material.LEATHER_CHESTPLATE).setColor(Color.GRAY).setTitle("Gray Armor")
                .setLore(Arrays.asList(
                        "",
                        " &3&lClick to set a &a&lGray Armors",
                        ""
                )).build());
        this.inventory.setItem(24, new ItemMaker(Material.LEATHER_CHESTPLATE).setColor(Color.MAROON).setTitle("Maroon Armor")
                .setLore(Arrays.asList(
                        "",
                        " &3&lClick to set a &a&lMaroon Armors",
                        ""
                )).build());
        this.inventory.setItem(29, new ItemMaker(Material.LEATHER_CHESTPLATE).setColor(Color.SILVER).setTitle("Rainbow Armor")
                .setLore(Arrays.asList(
                        "",
                        " &3&lClick to set a &a&lRainbow Armors",
                        ""
                )).build());
        this.inventory.setItem(40, new ItemMaker(Material.REDSTONE).setTitle("&cReset Armors").
                setLore(Arrays.asList(
                        "",
                        "&cClick to remove armors!",
                        ""
                )).build());
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
                case 11:
                    if (player.hasPermission(plugin.getConfig().getString("ARMORS.RED.PERMS"))) {
                        ArmorUtils.getArmor(player, Color.RED, "RED");
                        player.closeInventory();
                        break;
                    }
                    player.sendMessage(me.sakio.cosmetic.utils.Color.translate
                            (plugin.getConfig().getString("NO-PERMS")));
                    break;
                case 12:
                    if (player.hasPermission(plugin.getConfig().getString("ARMORS.BLUE.PERMS"))) {
                        ArmorUtils.getArmor(player, Color.BLUE, "BLUE");
                        player.closeInventory();
                        break;
                    }
                    player.sendMessage(me.sakio.cosmetic.utils.Color.translate
                            (plugin.getConfig().getString("NO-PERMS")));
                    break;
                case 13:
                    if (player.hasPermission(plugin.getConfig().getString("ARMORS.GREEN.PERMS"))) {
                        ArmorUtils.getArmor(player, Color.GREEN, "GREEN");
                        player.closeInventory();
                        break;
                    }
                    player.sendMessage(me.sakio.cosmetic.utils.Color.translate
                            (plugin.getConfig().getString("NO-PERMS")));
                    break;
                case 14:
                    if (player.hasPermission(plugin.getConfig().getString("ARMORS.ORANGE.PERMS"))) {
                        ArmorUtils.getArmor(player, Color.ORANGE, "ORANGE");
                        player.closeInventory();
                        break;
                    }
                    player.sendMessage(me.sakio.cosmetic.utils.Color.translate
                            (plugin.getConfig().getString("NO-PERMS")));
                    break;
                case 15:
                    if (player.hasPermission(plugin.getConfig().getString("ARMORS.YELLOW.PERMS"))) {
                        ArmorUtils.getArmor(player, Color.YELLOW, "YELLOW");
                        player.closeInventory();
                        break;
                    }
                    player.sendMessage(me.sakio.cosmetic.utils.Color.translate
                            (plugin.getConfig().getString("NO-PERMS")));
                    break;
                case 20:
                    if (player.hasPermission(plugin.getConfig().getString("ARMORS.BLACK.PERMS"))) {
                        ArmorUtils.getArmor(player, Color.BLACK, "BLACK");
                        player.closeInventory();
                        break;
                    }
                    player.sendMessage(me.sakio.cosmetic.utils.Color.translate
                            (plugin.getConfig().getString("NO-PERMS")));
                    break;
                case 21:
                    if (player.hasPermission(plugin.getConfig().getString("ARMORS.AQUA.PERMS"))) {
                        ArmorUtils.getArmor(player, Color.AQUA, "AQUA");
                        player.closeInventory();
                        break;
                    }
                    player.sendMessage(me.sakio.cosmetic.utils.Color.translate
                            (plugin.getConfig().getString("NO-PERMS")));
                    break;
                case 22:
                    if (player.hasPermission(plugin.getConfig().getString("ARMORS.PURPLE.PERMS"))) {
                        ArmorUtils.getArmor(player, Color.PURPLE, "PURPLE");
                        player.closeInventory();
                        break;
                    }
                    player.sendMessage(me.sakio.cosmetic.utils.Color.translate
                            (plugin.getConfig().getString("NO-PERMS")));
                    break;
                case 23:
                    if (player.hasPermission(plugin.getConfig().getString("ARMORS.GRAY.PERMS"))) {
                        ArmorUtils.getArmor(player, Color.GRAY, "GRAY");
                        player.closeInventory();
                        break;
                    }
                    player.sendMessage(me.sakio.cosmetic.utils.Color.translate
                            (plugin.getConfig().getString("NO-PERMS")));
                    break;
                case 24:
                    if (player.hasPermission(plugin.getConfig().getString("ARMORS.MAROON.PERMS"))) {
                        ArmorUtils.getArmor(player, Color.MAROON, "MAROON");
                        player.closeInventory();
                        break;
                    }
                    player.sendMessage(me.sakio.cosmetic.utils.Color.translate
                            (plugin.getConfig().getString("NO-PERMS")));
                    break;
                case 29:
                    if (player.hasPermission(plugin.getConfig().getString("ARMORS.RAINBOW.PERMS"))) {
                        RainbowTask.players.add(player);
                        player.closeInventory();
                        break;
                    }
                    player.sendMessage(me.sakio.cosmetic.utils.Color.translate(plugin.getConfig().getString("NO-PERMS")));
                    break;
                    case 40:
                    if (player.getInventory().getArmorContents().length == 0) {
                        player.sendMessage(me.sakio.cosmetic.utils.Color.translate("&cYou don't have any cosmetic to remove!"));
                        return;
                    }
                    if (player.getInventory().getArmorContents().length > 0) {
                        player.getInventory().setHelmet(null);
                        player.getInventory().setChestplate(null);
                        player.getInventory().setLeggings(null);
                        player.getInventory().setBoots(null);
                        player.sendMessage(me.sakio.cosmetic.utils.Color.translate("&cAll cosmetic remove"));
                        break;
                    }
            }
        }
    }
}
