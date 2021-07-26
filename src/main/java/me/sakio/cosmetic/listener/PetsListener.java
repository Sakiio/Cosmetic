package me.sakio.cosmetic.listener;

import com.avaje.ebean.validation.Email;
import me.sakio.cosmetic.manager.PlayerData;
import me.sakio.cosmetic.manager.objects.Pets;
import me.sakio.cosmetic.manager.objects.Trails;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

/**
 * Project: Cosmetic
 * Date: 26/07/2021 @ 19:32
 * Class: PetsListener
 */
public class PetsListener implements Listener {

    @EventHandler
    public void onClickPets(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();
        PlayerData playerData = new PlayerData();
        Pets pets = Pets.valueOf(playerData.getPets(player));

        if(playerData.getPets(player).equals(Pets.DEFAULT.getName()))
            return;

        if(event.getRightClicked().equals(pets)) {
            event.getRightClicked().setPassenger(player);
        }
    }
}
