package be.exacu.Spigot.Listeners;

import be.exacu.Spigot.HubControl;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements Listener {

    @EventHandler
    public void HubLeaveMessage(PlayerQuitEvent e) {
        FileConfiguration config = HubControl.instance.getConfig();
        if (config.getBoolean("enable-join-leave-messages")) {
            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', "&7&l[&c&l-&7&l] &r" + e.getPlayer().getName()));
        }
    }
}