package fr.TimeuhAlefa.survi;

import fr.TimeuhAlefa.survi.listener.MyListener;
import fr.TimeuhAlefa.survi.listener.PlayerListener;
import fr.TimeuhAlefa.survi.listener.ServerListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Main extends JavaPlugin {

    private final MyListener listener = new MyListener(this);
    private final PlayerListener playerListener = new PlayerListener(this);
    private final ServerListener serverListener = new ServerListener(this);

    private final Commands commands = new Commands(this);
    public final GameManager gameManager = new GameManager(this);
    public final Timer timer = new Timer(this);
    Objective objectiveHealth;

    final Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();

    @Override
    public void onEnable() {
        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(listener, this);
        pluginManager.registerEvents(playerListener, this);
        pluginManager.registerEvents(serverListener, this);

        getConfig().options().copyDefaults(true);
        saveConfig();

        /*objectiveHealth = board.registerNewObjective("Health", Criterias.HEALTH);
        objectiveHealth.setDisplaySlot(DisplaySlot.PLAYER_LIST);*/

        for(Player player : Bukkit.getOnlinePlayers())
        {
            CustomPlayer customPlayer = new CustomPlayer(player.getUniqueId());
            gameManager.players.add(customPlayer);
        }

        System.out.println("------------------ Plugin Survi ------------------");
    }

    @Override
    public void onDisable(){

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player player = (Player)sender;
        if(player.isOp())
        {

        }
        return false;
    }
}
