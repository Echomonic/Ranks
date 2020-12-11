package dev.echo.ranks.events;

import dev.echo.ranks.RankPlugin;
import dev.echo.ranks.managers.FileManager;
import dev.echo.ranks.utils.Ranks;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        if(!player.hasPlayedBefore()){
            RankPlugin.getInstance().getFileManager().setRank(Ranks.MEMBER, player);

        }else {
            RankPlugin.getInstance().getFileManager().getRank(player);


        }

    }

}
