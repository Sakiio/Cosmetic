package me.sakio.cosmetic.commands;

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
    @Command(name = "cosmetic", aliases = {"developer"}, inGameOnly = false)
    public void execute(CommandArgs cmd) {
        Player player = cmd.getPlayer();
            player.sendMessage(Color.translate("&8------------------------------------------------"));
            player.sendMessage(Color.translate("           &3&lSakio Cosmetics | 1.0"));
            player.sendMessage(Color.translate("&8-------------------------------------------------"));
    }
}
