package be.exacu.Spigot.Listeners.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GMSP implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String arg, String[] args) {
        Player p = (Player) sender;
        if(sender instanceof Player){
            if(p.hasPermission("exacube.gamemode.spectator")){
                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5&lExa&7&lCube> &6Successfully set your gamemode to &cspectator!"));
            }
        }
        return true;
    }
}
