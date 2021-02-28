package me.sakio.cosmetic.commands;

import me.sakio.cosmetic.menu.CosmeticMainMenu;
import me.sakio.cosmetic.utils.commands.Command;
import me.sakio.cosmetic.utils.commands.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by DevSakio
 * Project: Cosmetic
 * Date: 04/01/2021 @ 13:04
 * Class: CosmeticItemCommand
 */
public class OpenMenuCommand {
    @Command(name = "menu")
    public void OnCommand(CommandArgs cmd){
        Player player = cmd.getPlayer();
        new CosmeticMainMenu().open(player);
    }
}
