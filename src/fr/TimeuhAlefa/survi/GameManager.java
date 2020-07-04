package fr.TimeuhAlefa.survi;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GameManager {
    private static Main plugin;

    public List<CustomPlayer> players = new ArrayList<CustomPlayer>();

    GameManager(Main instance) {
        plugin = instance;
    }

    public CustomPlayer getCustomPlayer(UUID uuid)
    {
        for(CustomPlayer customPlayer : players)
        {
            if(customPlayer.uuid.equals(uuid))
            {
                return customPlayer;
            }
        }
        return null;
    }

    public Player getPlayer(UUID uuid)
    {
        for(Player player : Bukkit.getOnlinePlayers())
        {
            if(player.getUniqueId().equals(uuid))
            {
                return player;
            }
        }
        return null;
    }
}
