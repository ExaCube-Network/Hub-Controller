package be.exacu.Spigot;

import be.exacu.Spigot.Listeners.*;
import be.exacu.Spigot.Listeners.Commands.GMA;
import be.exacu.Spigot.Listeners.Commands.GMC;
import be.exacu.Spigot.Listeners.Commands.GMS;
import be.exacu.Spigot.Listeners.Commands.GMSP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HubControl extends JavaPlugin {

    public static HubControl instance;

    @Override
    public void onEnable(){
        instance = this;
        getLogger().info("(!) ExaCube: Hub Control Plugin Loading");

        saveDefaultConfig();
        /*
        This can prevent the server from crashing if it can't find the command.
        */
        PluginCommand gmcCMD = this.getCommand("gmc");
        PluginCommand gmsCMD = this.getCommand("gms");
        PluginCommand gmaCMD = this.getCommand("gma");
        PluginCommand gmspCMD = this.getCommand("gmsp");

        if (gmcCMD != null && gmsCMD != null && gmaCMD != null && gmspCMD != null) {
            gmaCMD.setExecutor(new GMC());
            gmsCMD.setExecutor(new GMS());
            gmaCMD.setExecutor(new GMA());
            gmspCMD.setExecutor(new GMSP());
        } else {
            getLogger().info("(!) ExaCube : Something is wrong with command config!");
        }
        final PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new Join(), this);
        pm.registerEvents(new Leave(), this);
        pm.registerEvents(new ThrowCancel(), this);
        pm.registerEvents(new PlayerDamageCancel(), this);
        pm.registerEvents(new MenuClick(), this);
        pm.registerEvents(new BlockModifyCancel(), this);

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        getLogger().info("(!) ExaCube: Hub Control Plugin Loaded");
    }

    @Override
    public void onDisable(){
        getLogger().info("(!) ExaCube: Hub Control Plugin Unloaded");
    }


}
