package me.sakio.cosmetic.manager;

import lombok.Getter;
import lombok.Setter;
import me.sakio.cosmetic.manager.provider.Gadgets;
import me.sakio.cosmetic.manager.provider.Trails;
import me.sakio.cosmetic.utils.DataFile;
import org.bukkit.entity.Player;


/**
 * Created by DevSakio
 * Project: Cosmetic
 * Date: 26/12/2020 @ 14:13
 * Class: PlayerData
 */
@Getter
@Setter
public class PlayerData {
    public void createData(Player player) {
        if (!DataFile.getConfig().getConfigurationSection("PLAYER-DATA").getKeys(false).contains(player.getUniqueId().toString())) {
            DataFile.getConfig().set("PLAYER-DATA." + player.getUniqueId() + ".NAME", player.getName());
            DataFile.getConfig().set("PLAYER-DATA." + player.getUniqueId() + ".ARMORS", player.getInventory().getArmorContents());
            DataFile.getConfig().set("PLAYER-DATA." + player.getUniqueId() + ".TRAILS", Trails.DEFAULT);
            DataFile.getConfig().set("PLAYER-DATA." + player.getUniqueId() + ".GADGETS", Gadgets.DEFAULT);
            DataFile.getConfig().saveAll();
        }
    }
    public String getTrails(Player player) {
        return DataFile.getConfig().getString("PLAYER-DATA." + player.getUniqueId() + ".TRAILS");
    }

    public void setTrails(Player player, Trails trails) {
        DataFile.getConfig().set("PLAYER-DATA." + player.getUniqueId() + ".TRAILS", trails.getName());
        DataFile.getConfig().saveAll();
    }
    public String getGadgets(Player player) {
        return DataFile.getConfig().getString("PLAYER-DATA." + player.getUniqueId() + ".GADGETS");
    }

    public void setGadgets(Player player, Gadgets gadgets) {
        DataFile.getConfig().set("PLAYER-DATA." + player.getUniqueId() + ".GADGETS", gadgets.getName());
        DataFile.getConfig().saveAll();
    }
}
