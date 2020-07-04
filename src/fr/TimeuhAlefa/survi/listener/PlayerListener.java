package fr.TimeuhAlefa.survi.listener;

import fr.TimeuhAlefa.survi.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerListener implements Listener {
    static Main plugin;

    public PlayerListener(Main instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        for(Player player: Bukkit.getOnlinePlayers())
        {
            player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 10, 1);
        }
    }
}
