package dev.echo.ranks.utils;

import org.bukkit.ChatColor;

public enum Ranks {

    HOST("§f[§cHost§f]", ChatColor.RED),
    DEV("§f[§dDev§f]", ChatColor.LIGHT_PURPLE),
    BUILDER("§f[§eBuilder§f]", ChatColor.YELLOW),
    TESTER("§f[§aTester§f]", ChatColor.GREEN),
    MEMBER( "§f[§7Member§f]", ChatColor.GRAY),
    ;

    private String rankName;
    private ChatColor rankColor;

    Ranks(String rankName, ChatColor rankColor) {
        this.rankName = rankName;
        this.rankColor = rankColor;
    }

    public ChatColor getRankColor() {
        return rankColor;
    }

    public String getRankName() {
        return rankName;
    }
}
