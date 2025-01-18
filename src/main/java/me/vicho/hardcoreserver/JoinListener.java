package me.vicho.hardcoreserver;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (Main.getInstance().getConfig().getBoolean("hardcore-finished")) {
            event.getPlayer().kickPlayer("Hardcorde has finished, reset the world");
        }
    }
}
