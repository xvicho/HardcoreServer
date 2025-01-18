package me.vicho.hardcoreserver;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {
    private static Main instance;
    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
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
}