package dev.echo.ranks.events;

import dev.echo.ranks.RankPlugin;
import dev.echo.ranks.utils.Ranks;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ChatEvent implements Listener {



    @EventHandler
    public void onJoin(AsyncPlayerChatEvent event){

        Player player = event.getPlayer();

        Ranks ranks = RankPlugin.getInstance().getFileManager().getRank(player);

        ChatColor color = RankPlugin.getInstance().getFileManager().getRank(player).getRankColor();
        String prefix = RankPlugin.getInstance().getFileManager().getRank(player).getRankName();
        event.setCancelled(true);

        if(ranks.name() != null){
            for(Player ranked : event.getRecipients()) {
                if (RankPlugin.getInstance().getFileManager().getRank(player) == Ranks.MEMBER) {

                    ranked.sendMessage(color + prefix + " " + color + player.getName() + ChatColor.GRAY + ": " + event.getMessage());

                } else {
                    ranked.sendMessage(color + prefix + " " + color + player.getName() + ChatColor.WHITE + ": " + event.getMessage());


                }
            }

        }else {
            RankPlugin.getInstance().getFileManager().setRank(Ranks.MEMBER, player);
            return;
        }
    }

}
