package fr.TimeuhAlefa.survi;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;

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

                ZonedDateTime nowZoned = ZonedDateTime.now();
                Instant midnight = nowZoned.toLocalDate().atStartOfDay(nowZoned.getZone()).toInstant();
                Duration duration = Duration.between(midnight, Instant.now());
                long seconds = duration.getSeconds();
                int tick;
                if (seconds >= 0 && seconds < 21600) {
                    tick = 12000 + Math.round(seconds/1.8f);
                }
                else {
                    tick = Math.round(seconds/5.4f) - 4000;
                }
                plugin.world.setTime(tick+2400);
            }
        }, 0, 20);
    }
}