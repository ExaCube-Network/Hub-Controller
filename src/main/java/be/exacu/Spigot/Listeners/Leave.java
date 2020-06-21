package be.exacu.Spigot.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements Listener {

    @EventHandler
    public void HubLeaveMessage(PlayerQuitEvent e){
        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', "&7&l[&c&l-&7&l] &r" + e.getPlayer().getName()));
    }

}