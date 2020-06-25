package be.exacu.Spigot;

import be.exacu.Spigot.Listeners.*;
import be.exacu.Spigot.Listeners.Commands.GMA;
import be.exacu.Spigot.Listeners.Commands.GMC;
import be.exacu.Spigot.Listeners.Commands.GMS;
import be.exacu.Spigot.Listeners.Commands.GMSP;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HubControl extends JavaPlugin {

    public static HubControl instance;

    @Override
    public void onEnable(){
        instance = this;
        getLogger().info("(!) ExaCube: Hub Control Plugin Loading");

        saveDefaultConfig();

        this.getCommand("gmc").setExecutor((CommandExecutor) new GMC());
        this.getCommand("gms").setExecutor((CommandExecutor) new GMS());
        this.getCommand("gma").setExecutor((CommandExecutor) new GMA());
        this.getCommand("gmsp").setExecutor((CommandExecutor) new GMSP());

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
