package dev.echo.ranks;

import dev.echo.ranks.commands.CommandRankPlayer;
import dev.echo.ranks.events.ChatEvent;
import dev.echo.ranks.events.JoinEvent;
import dev.echo.ranks.managers.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class RankPlugin extends JavaPlugin {

    private static RankPlugin instance;

    private FileManager fileManager;

    @Override
    public void onEnable() {

        instance = this;

        fileManager = new FileManager();

        fileManager.createMainFiles(getInstance());

        getCommand("rank").setExecutor(new CommandRankPlayer());

        Bukkit.getPluginManager().registerEvents(new ChatEvent(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        super.onEnable();
    }

    @Override
    public void onDisable() {

        super.onDisable();
    }

    public static RankPlugin getInstance() {


        return instance;
    }

    public FileManager getFileManager() {
        return fileManager;
    }
}
