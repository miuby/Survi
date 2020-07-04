package fr.TimeuhAlefa.survi;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;

public class Timer {
    private static Main plugin;

    Timer(Main instance) {
        plugin = instance;
    }

    public void Update() {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {

                /*ZonedDateTime nowZoned = ZonedDateTime.now();
                Instant midnight = nowZoned.toLocalDate().atStartOfDay(nowZoned.getZone()).toInstant();
                Duration duration = Duration.between(midnight, Instant.now());
                long seconds = duration.getSeconds();*/
            }
        }, 0, 20);
    }
}
