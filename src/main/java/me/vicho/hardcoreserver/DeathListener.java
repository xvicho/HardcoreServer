package me.vicho.hardcoreserver;

//import org.apache.commons.io.FileUtils;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
//import java.io.File;
import java.util.Collection;
//import java.util.List;


public class DeathListener implements Listener {
    @EventHandler
    public void onPlayerFatalDamage(EntityDamageEvent event) {
        if (event.getEntityType() == EntityType.PLAYER) {
            Player player = (Player) event.getEntity();
            if(player.getHealth() - event.getDamage() < 1) {
                event.setCancelled(true);
                player.setHealth(player.getMaxHealth());
                player.teleport(player.getWorld().getSpawnLocation());
                resetWorld(player);
            }
        }
    }

    public void resetWorld(Player player) {
        player.teleport(new Location(player.getWorld(), player.getLocation().getBlockX(), player.getLocation().getBlockY()+5, player.getLocation().getBlockZ()));
        Collection<? extends Player> jugadores = Bukkit.getOnlinePlayers();
        for (Player var : jugadores){
//            var.teleport(new Location(Bukkit.getWorld("limbo"),0,2550,0));
            Bukkit.getBanList(BanList.Type.NAME).addBan(var.getName(),"Player " + player.getName() + " has dead, reset the world.",null, "Notch");
            var.kickPlayer( "Player " + player.getName() + " has dead, reset the world.");
        }
        Main.getInstance().getConfig().set("hardcore-finished",true);
        Main.getInstance().saveConfig();
    }

//    public void customDeleteWorld(World world) {
//        deleteWorld(world.getWorldFolder());
//    }

//    public boolean deleteWorld(File path) {
//        if (path.exists()) {
//            File[] files = path.listFiles();
//            for (File file : files) {
//                if (file.isDirectory())
//                    deleteWorld(file);
//                else
//                    file.delete();
//            }
//        }
//
//        return (path.delete());
//    }


//    @EventHandler
//    public void onPlayerJoin(PlayerJoinEvent event) {
//        Bukkit.broadcastMessage("Welcome " + event.getPlayer().getName() + " to the server");
//    }
}
