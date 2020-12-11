package dev.echo.ranks.utils;

import dev.echo.ranks.RankPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.Objects;

public class RankTag {

    private static Ranks ranks;

    public static void setNametag(Player player, String prefix) {



        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getTeam(player.getName());
        if (team == null)
        {
            team = scoreboard.registerNewTeam(player.getName());
            team.setPrefix(RankPlugin.getInstance().getFileManager().getRank(player).getRankColor() + RankPlugin.getInstance().getFileManager().getRank(player).getRankName() + " ");
            team.addPlayer(Objects.requireNonNull(player.getPlayer()));
        }
        else
        {
            team = scoreboard.getTeam(player.getName());
            team.setPrefix(RankPlugin.getInstance().getFileManager().getRank(player).getRankColor() + RankPlugin.getInstance().getFileManager().getRank(player).getRankName() + " ");
            team.addPlayer(player);
        }
        team.setColor(RankPlugin.getInstance().getFileManager().getRank(player).getRankColor());
        for (Player players : Bukkit.getOnlinePlayers())
        {
            players.setScoreboard(scoreboard);
        }
    }
    
}
