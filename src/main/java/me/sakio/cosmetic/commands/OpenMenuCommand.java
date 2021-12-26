package me.sakio.cosmetic.commands;

import me.sakio.cosmetic.manager.menu.CosmeticMainMenu;
import me.sakio.cosmetic.utils.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by DevSakio
 * Project: Cosmetic
 * Date: 04/01/2021 @ 13:04
 * Class: CosmeticItemCommand
 */
public class OpenMenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (!sender.hasPermission("menu.open")){
            player.sendMessage(Color.translate("&cYou don't have permission to use this command!"));
            return true;
        }

        new CosmeticMainMenu().open(player);
        return false;
    }
}



