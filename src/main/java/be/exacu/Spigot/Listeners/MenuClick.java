package be.exacu.Spigot.Listeners;

import be.exacu.Spigot.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.nkomarn.Honeycomb.menu.Menu;
import xyz.nkomarn.Honeycomb.menu.MenuButton;

import java.util.Collections;

public class MenuClick implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Utilities utils = new Utilities();
        Player p = e.getPlayer();
        Action action = e.getAction();
        if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.NETHER_STAR)) {
            if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK) || action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)) {
                Menu menu = new Menu(p, ChatColor.translateAlternateColorCodes('&',"&5&lExa&8Cube Network"), 27);

                menu.fill(Material.GRAY_STAINED_GLASS_PANE);

                ItemStack survivalIcon = new ItemStack(Material.GRASS_BLOCK);
                ItemMeta survivalIconMeta = survivalIcon.getItemMeta();
                survivalIconMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lSurvival"));
                survivalIconMeta.setLore(Collections.singletonList(ChatColor.translateAlternateColorCodes('&', "&7Click me to go to the survival server!")));
                survivalIcon.setItemMeta(survivalIconMeta);

                ItemStack creativeIcon = new ItemStack(Material.MAGENTA_BANNER);
                ItemMeta creativeIconMeta = creativeIcon.getItemMeta();
                creativeIconMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&lCreative"));
                creativeIconMeta.setLore(Collections.singletonList(ChatColor.translateAlternateColorCodes('&', "&7Click me to go to the creative server!")));
                creativeIcon.setItemMeta(creativeIconMeta);

                ItemStack kitPVPIcon = new ItemStack(Material.IRON_SWORD);
                ItemMeta kitPVPIconMeta = kitPVPIcon.getItemMeta();
                kitPVPIconMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                kitPVPIconMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lKitPvP"));
                kitPVPIconMeta.setLore(Collections.singletonList(ChatColor.translateAlternateColorCodes('&', "&7Click me to go to the KitPvP server!")));
                kitPVPIcon.setItemMeta(kitPVPIconMeta);


                menu.addButton(new MenuButton(menu, survivalIcon, 10, ((guiButton, clickType) -> {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSending you to the Survival server!"));
                    utils.sendPlayerToServer(p, "survival");
                })));

                menu.addButton(new MenuButton(menu, creativeIcon, 12, ((guiButton, clickType) -> {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSending you to the Creative server!"));
                    utils.sendPlayerToServer(p, "creative");
                })));

                menu.addButton(new MenuButton(menu, kitPVPIcon, 14, ((guiButton, clickType) ->{
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSending you to the KitPVP server!"));
                    utils.sendPlayerToServer(p, "kitpvp");
                })));

                menu.open();
                p.playNote(p.getLocation(), Instrument.BELL, Note.natural(1, Note.Tone.A));
            }
        }
    }

    @EventHandler
    public void onBanToolClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action action = e.getAction();
        if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.BARRIER)) {
            if (action.equals(Action.RIGHT_CLICK_AIR) ||
                    action.equals(Action.RIGHT_CLICK_BLOCK) ||
                    action.equals(Action.LEFT_CLICK_AIR) ||
                    action.equals(Action.LEFT_CLICK_BLOCK)) {
                p.playNote(p.getLocation(), Instrument.BANJO, Note.natural(1, Note.Tone.G));
            }
        }
    }
}
