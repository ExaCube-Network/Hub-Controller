package be.exacu.Spigot.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Arrays;

public class BlockModifyCancel implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPermission("exacube.hub.modifyblocks")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou are not allow to break blocks!"));
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPermission("exacube.hub.modifyblocks")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou are not allow to place blocks!"));
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onTrapdoorEdit(PlayerInteractEvent e) {
        Material[] trapDoors = {Material.ACACIA_TRAPDOOR, Material.BIRCH_TRAPDOOR, Material.DARK_OAK_TRAPDOOR, Material.IRON_TRAPDOOR, Material.JUNGLE_TRAPDOOR, Material.OAK_TRAPDOOR, Material.SPRUCE_TRAPDOOR};
        Player p = e.getPlayer();
        if (e.getClickedBlock() != null) {
            if (Arrays.stream(trapDoors).anyMatch(e.getClickedBlock().getType()::equals)) {
                if (!p.hasPermission("exacube.hub.modifyblocks")) {
                    e.setCancelled(true);
                }
            }
        }

    }

    @EventHandler
    public void onDoorEdit(PlayerInteractEvent e) {
        Material[] doors = {Material.DARK_OAK_DOOR, Material.ACACIA_DOOR, Material.IRON_DOOR, Material.BIRCH_DOOR, Material.JUNGLE_DOOR, Material.OAK_DOOR, Material.SPRUCE_DOOR};
        Player p = e.getPlayer();
        if (e.getClickedBlock() != null) {
            if (Arrays.stream(doors).anyMatch(e.getClickedBlock().getType()::equals)) {
                if (!p.hasPermission("exacube.hub.modifyblocks")) {
                    e.setCancelled(true);
                }
            }
        }

    }

    @EventHandler
    public void onFenceGateEdit(PlayerInteractEvent e) {
        Material[] fenceGates = {Material.ACACIA_FENCE_GATE, Material.BIRCH_FENCE_GATE, Material.DARK_OAK_FENCE_GATE, Material.JUNGLE_FENCE_GATE, Material.OAK_FENCE_GATE, Material.SPRUCE_FENCE_GATE};
        Player p = e.getPlayer();
        if (e.getClickedBlock() != null) {
            if (Arrays.stream(fenceGates).anyMatch(e.getClickedBlock().getType()::equals)) {
                if (!p.hasPermission("exacube.hub.modifyblocks")) {
                    e.setCancelled(true);
                }
            }
        }
    }
}

