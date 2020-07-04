package fr.TimeuhAlefa.survi.listener;

import fr.TimeuhAlefa.survi.CustomPlayer;
import fr.TimeuhAlefa.survi.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ServerListener  implements Listener {
    static Main plugin;

    public ServerListener(Main instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        CustomPlayer customPlayer = new CustomPlayer(player.getUniqueId());
        plugin.gameManager.players.add(customPlayer);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        CustomPlayer customPlayer = plugin.gameManager.getCustomPlayer(event.getPlayer().getUniqueId());
        plugin.gameManager.players.remove(customPlayer);
    }
}
