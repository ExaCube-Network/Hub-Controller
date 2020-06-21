package be.exacu.Spigot.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ThrowCancel implements Listener {

    @EventHandler
    public void onThrow(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        if(!p.hasPermission("dbdhub.hub.throw")){
            if(e.getItemDrop().getItemStack().getType().equals(Material.NETHER_STAR)){
                e.setCancelled(true);
            }
        }
    }

}
