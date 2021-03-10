package me.sakio.cosmetic.commands;

import me.sakio.cosmetic.Cosmetic;
import me.sakio.cosmetic.utils.Color;
import me.sakio.cosmetic.utils.commands.Command;
import me.sakio.cosmetic.utils.commands.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by DevSakio
 * Project: Cosmetic
 * Date: 26/12/2020 @ 14:12
 * Class: CosmeticCommand
 */
public class CosmeticCommand {
    @Command(name = "cosmetic", inGameOnly = true, aliases = {"developer", "panda"})
    public void OnCommand(CommandArgs cmd) {
        Player player = cmd.getPlayer();
        String[] args = cmd.getArgs();
            player.sendMessage(Color.translate("&c-------------------------------------------------"));
            player.sendMessage(Color.translate("&c&l" + Color.getName()));
            player.sendMessage(Color.translate("&c&lAuthor: " + Color.getAuthor()));
            player.sendMessage(Color.translate("&c&lVersions: " + Color.getVersion()));
            player.sendMessage(Color.translate("&c-------------------------------------------------"));
    }
}
