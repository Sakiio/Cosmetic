package me.sakio.cosmetic.listener;

import me.sakio.cosmetic.manager.PlayerData;
import me.sakio.cosmetic.manager.models.Pets;
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

    /*
    pets system is not finish atm
     */

    @EventHandler
    public void onClickPets(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();
        PlayerData playerData = new PlayerData();
        Pets pets = Pets.valueOf(playerData.getPets(player));

        if(playerData.getPets(player).equals(Pets.DEFAULT.getName()))
            return;

        if(event.getRightClicked().getType().equals(pets.getType()))
            event.getRightClicked().setPassenger(player);

        //TODO: add pet system
    }
}
