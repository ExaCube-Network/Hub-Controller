package be.exacu.Spigot.Listeners.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GMA implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String arg, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("minecraft.command.gamemode")){
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5&lExa&7&lCube> &6Successfully set your gamemode to &cadventure!"));
            }
        }
        return true;
    }
}
