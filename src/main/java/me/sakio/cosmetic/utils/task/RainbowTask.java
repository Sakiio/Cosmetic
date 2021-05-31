package me.sakio.cosmetic.utils.task;

import me.sakio.cosmetic.utils.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Cosmetic
 * Date: 28/02/2021 @ 23:34
 * Class: RainbowTask
 */
public class RainbowTask extends BukkitRunnable {

    public static List<Player> players = new ArrayList<>();
    int b = 0;
    int g = 0;
    int r = 255;
    int first = 0;
    int second = 0;
    int third = 0;
    int fourth = 0;
    int fifth = 0;
    int sixth = 0;

    public void run() {
        for (Player player : players) {

            if (this.first <= 17) {
                ++this.first;
                this.g = (this.first - 1) * 15;
            } else if (this.second <= 17) {
                ++this.second;
                this.r = 255 - 15 * (this.second - 1);
            } else if (this.third <= 17) {
                ++this.third;
                this.b = (this.third - 1) * 15;
            } else if (this.fourth <= 17) {
                ++this.fourth;
                this.g = 255 - 15 * (this.fourth - 1);
            } else if (this.fifth <= 17) {
                ++this.fifth;
                this.r = (this.fifth - 1) * 15;
            } else if (this.sixth <= 17) {
                ++this.sixth;
            } else {
                this.first = 0;
                this.second = 0;
                this.third = 0;
                this.fourth = 0;
                this.fifth = 0;
                this.sixth = 0;

                return;
            }

            player.getInventory().setHelmet(this.helmet(this.b, this.g, this.r));
            player.getInventory().setChestplate(this.chestplate(this.b, this.g, this.r));
            player.getInventory().setLeggings(this.leggings(this.b, this.g, this.r));
            player.getInventory().setBoots(this.boots(this.b, this.g, this.r));
        }
    }

    public ItemStack helmet(final int b, final int g, final int r) {
        final ItemStack item = new ItemStack(Material.LEATHER_HELMET, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Color.translate("&d&lR&a&la&e&li&c&ln&1&lb&b&lo&9&lw"));
        final LeatherArmorMeta lmeta = (LeatherArmorMeta) meta;
        ((LeatherArmorMeta) meta).setColor(org.bukkit.Color.fromBGR(b, g, r));
        item.setItemMeta((ItemMeta) lmeta);
        return item;
    }

    public ItemStack chestplate(final int b, final int g, final int r) {
        final ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Color.translate("&d&lR&a&la&e&li&c&ln&1&lb&b&lo&9&lw"));
        final LeatherArmorMeta lmeta = (LeatherArmorMeta) meta;
        ((LeatherArmorMeta) meta).setColor(org.bukkit.Color.fromBGR(b, g, r));
        item.setItemMeta((ItemMeta) lmeta);
        return item;
    }

    public ItemStack leggings(final int b, final int g, final int r) {
        final ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Color.translate("&d&lR&a&la&e&li&c&ln&1&lb&b&lo&9&lw"));
        final LeatherArmorMeta lmeta = (LeatherArmorMeta) meta;
        ((LeatherArmorMeta) meta).setColor(org.bukkit.Color.fromBGR(b, g, r));
        item.setItemMeta((ItemMeta) lmeta);
        return item;
    }

    public ItemStack boots(final int b, final int g, final int r) {
        final ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Color.translate("&d&lR&a&la&e&li&c&ln&1&lb&b&lo&9&lw"));
        final LeatherArmorMeta lmeta = (LeatherArmorMeta) meta;
        ((LeatherArmorMeta) meta).setColor(org.bukkit.Color.fromBGR(b, g, r));
        item.setItemMeta((ItemMeta) lmeta);
        return item;
    }
}
