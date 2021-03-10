package me.sakio.cosmetic.utils;

import me.sakio.cosmetic.Cosmetic;
import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class Color {
	
	public static String translate(String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}

	public static List<String> translate(List<String> text) {
		return text.stream().map(Color::translate).collect(Collectors.toList());
	}
	public static String getName() {
		return Cosmetic.getInstance().getDescription().getName();
	}

	public static String getVersion() {
		return Cosmetic.getInstance().getDescription().getVersion();
	}

	public static List<String> getAuthor() {
		return Cosmetic.getInstance().getDescription().getAuthors();
	}
}
