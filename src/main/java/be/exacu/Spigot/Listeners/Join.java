package be.exacu.Spigot.Listeners;

import be.exacu.Spigot.HubControl;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Join implements Listener {

    @EventHandler
    public void HubJoinTeleport(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(!p.hasPermission("exacube.hub.teleportcancel")){
            p.teleport(new Location(Bukkit.getWorld(""), 8.5, 32, 8.5, 180, 0));
        }
    }

    @EventHandler
    public void HubJoinMenuGive(PlayerJoinEvent e){
        Player p = e.getPlayer();
        ItemStack menuItem = new ItemStack(Material.NETHER_STAR);
        ItemMeta menuMeta = menuItem.getItemMeta();
        menuMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5&lExa&7&lCube &7Hub Menu"));
        ArrayList<String> menuLore = new ArrayList<>();
        menuLore.add(ChatColor.translateAlternateColorCodes('&', "&7Use this item to select which"));
        menuLore.add(ChatColor.translateAlternateColorCodes('&', "&7server you want to join!"));
        menuMeta.setLore(menuLore);
        menuItem.setItemMeta(menuMeta);
        p.getInventory().setItem(4, menuItem);
        p.getInventory().setHeldItemSlot(4);
    }

    @EventHandler
    public void HubJoinMessage(PlayerJoinEvent e){
        FileConfiguration config = HubControl.instance.getConfig();
        if(config.getBoolean("enable-join-leave-messages")){
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&7&l[&a&l+&7&l] &r" + e.getPlayer().getName()));
        }
    }

    @EventHandler
    public void onStaffHubJoinBanToolGive(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(p.hasPermission("exacube.hub.staff")){
            ItemStack banTool = new ItemStack(Material.BARRIER);
            ItemMeta banToolMeta = banTool.getItemMeta();
            banToolMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&4&lBan &7Peoples"));
            ArrayList<String> banToolLore = new ArrayList<>();
            banToolLore.add(ChatColor.translateAlternateColorCodes('&', "&7Click this item to ban peoples"));
            banToolMeta.setLore(banToolLore);
            banTool.setItemMeta(banToolMeta);
            p.getInventory().setItem(6, banTool);
        }
    }

}
