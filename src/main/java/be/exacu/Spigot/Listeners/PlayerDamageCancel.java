package be.exacu.Spigot.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerDamageCancel implements Listener {

    @EventHandler
    public void onHungerDeplete(FoodLevelChangeEvent e){
        e.setFoodLevel(20);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            p.setHealth(20);
            e.setCancelled(true);
        }
    }

}
