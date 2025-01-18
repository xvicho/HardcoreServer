package me.vicho.hardcoreserver;

//import org.bukkit.Bukkit;
//import org.bukkit.World;
//import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


//import java.io.File;
//import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JavaPlugin {
//    FileConfiguration config = getConfig();
    private static Main instance;
    @Override
    public void onEnable() {
        instance = this;
//        limboCheck();
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
//        getServer().getPluginManager().registerEvents(this,this);
        createConfig();
        getLogger().info("HardcoreServer is enabled");
    }
    @Override
    public void onDisable() {
        getLogger().info("HardcoreServer is disabled");
    }

    public static Main getInstance() {
        return instance;
    }

    public void createConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                getLogger().info("Creating configuration...");
                getConfig().addDefault("hardcore-finished",false);
                saveDefaultConfig();
            } else {
                getLogger().info("Loading configuration");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    @EventHandler
//    public void onPlayerJoin(PlayerJoinEvent event) {
//        if (config.getBoolean("hardcore-finished")) {
//            event.getPlayer().kickPlayer("Hardcorde has finished");
//        }
//    }


//    public void limboCheck() {
//        // test for world limbo present
//        List<World> Mundos = Bukkit.getWorlds();
//        boolean limbo_present = false;
//        for (World var : Mundos) {
//            if (var.getName() == "limbo") {
//                limbo_present = true;
//            }
//        }
//        if (limbo_present == false) {
//            Bukkit.createWorld(new WorldCreator("limbo").generator(new EmptyChunkGenerator()));
//        }
//    }

//    public void defaultWorldCreation() {
//        List<World> Mundos = Bukkit.getWorlds();
//        boolean default_present = false;
//        for (World var : Mundos) {
//            if (var.getName() == "defaultworld") {
//                default_present = true;
//            }
//        }
//        if (default_present == false) {
//            Bukkit.createWorld(new WorldCreator("defaultworld").environment(World.Environment.NORMAL));
//            Bukkit.createWorld(new WorldCreator("defaultworld_nether").environment(World.Environment.NETHER));
//            Bukkit.createWorld(new WorldCreator("defaultworld_the_end").environment(World.Environment.THE_END));
//        }
//
//    }
}