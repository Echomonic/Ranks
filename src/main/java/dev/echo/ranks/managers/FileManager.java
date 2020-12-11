package dev.echo.ranks.managers;

import dev.echo.ranks.RankPlugin;
import dev.echo.ranks.utils.Ranks;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileManager {

    private File file;
    private YamlConfiguration configuration;

    private Ranks rank;

    public void createMainFiles(RankPlugin plugin){

        file = new File(plugin.getDataFolder(), "rankYaml.yml");

        if(!file.exists()){

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        configuration = YamlConfiguration.loadConfiguration(file);

    }


    public Ranks getRank(Player player) {
        return Ranks.valueOf(configuration.getString(player.getUniqueId().toString()));
    }

    public void setRank(Ranks rank, Player player) {
        configuration.set(player.getUniqueId().toString(), rank.name());
    }
    public void setRank(Ranks rank, UUID uuid) {
        configuration.set(uuid.toString(), rank.name());
    }
}
