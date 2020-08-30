package top.dsbbs2.bukkitcord.bukkit;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import top.dsbbs2.bukkitcord.api.*;

import java.util.*;

public class BukkitPlatformImpl implements IPlatform {
    private final BukkitPluginManagerImpl pluginManager=new BukkitPluginManagerImpl();
    {
        PlatformManager.setPlatform(this);
    }

    @Override
    public IPluginManager getPluginManager() {
        return pluginManager;
    }

    @Override
    public void dispatchCommand(ICommandSender sender, String cmd) {
        Bukkit.dispatchCommand((CommandSender) sender.getDelegate(),cmd);
    }

    @Override
    public ICommandSender getConSoleSender() {
        return new BukkitCommandSenderImpl(Bukkit.getConsoleSender());
    }

    @Override
    public IPlayer getPlayer(String n) {
        return new BukkitPlayerImpl(Bukkit.getPlayer(n));
    }

    @Override
    public IPlayer getPlayer(UUID u) {
        return new BukkitPlayerImpl(Bukkit.getPlayer(u));
    }

    @Override
    public void broadcast(String string) {
        Bukkit.broadcastMessage(string);
    }

    @Override
    public void broadcast(String string, String permission) {
        Bukkit.broadcast(string,permission);
    }

    @Override
    public ArrayList<IPlayer> getOnlinePlayers() {
        ArrayList<IPlayer> ret=new ArrayList<>();
        for(Player p: Bukkit.getOnlinePlayers())
            ret.add(new BukkitPlayerImpl(p));
        return ret;
    }

    @Override
    public ArrayList<String> getOnlinePlayersName() {
        ArrayList<String> ret=new ArrayList<>();
        for(Player p: Bukkit.getOnlinePlayers())
            ret.add(p.getName());
        return ret;
    }

    @Override
    public boolean getBungeeCord() {
        return Bukkit.spigot().getConfig().getBoolean("settings.bungeecord");
    }
}
