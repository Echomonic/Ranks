package dev.echo.ranks.commands;

import dev.echo.ranks.RankPlugin;
import dev.echo.ranks.utils.RankTag;
import dev.echo.ranks.utils.Ranks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommandRankPlayer implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){

            Player player = (Player) sender;

            if(player.hasPermission("rank.use")){

                if(args.length == 2) {
                    Player target = Bukkit.getPlayer(args[0]);

                    RankPlugin.getInstance().getFileManager().setRank(Ranks.valueOf(args[1]), target.getUniqueId());

                        RankTag.setNametag(target, Ranks.valueOf(args[1]).getRankColor() + Ranks.valueOf(args[1]).getRankName());

                    target.sendMessage(ChatColor.WHITE + "Your rank has been updated to " + RankPlugin.getInstance().getFileManager().getRank(target).getRankColor().toString().toUpperCase()
                            + Ranks.valueOf(args[1]).getRankName());


                    player.sendMessage(ChatColor.GREEN + "Successful!");



                }else {

                    player.sendMessage("No permission!");
                }

            }else{

                sender.sendMessage("You are not a player!");
                return true;

            }


        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        List<String> arguments = new ArrayList<>();

        if(!(sender instanceof Player));

        Player player =  (Player) sender;
        if(command.getName().equalsIgnoreCase("rank")) {
            if (player.hasPermission("rank.player")) {

                if (args.length == 1) {

                    for(Player online : Bukkit.getOnlinePlayers()){

                        arguments.addAll(Arrays.asList(online.getName()));

                    }

                }

                if (args.length == 2) {

                    for(Ranks ranks : Ranks.values()){

                        String s1 = ChatColor.translateAlternateColorCodes('§', ranks.toString());

                        arguments.addAll(Collections.singleton("" + s1));
                    }

                }
            }
        }
        return arguments;
    }
}
