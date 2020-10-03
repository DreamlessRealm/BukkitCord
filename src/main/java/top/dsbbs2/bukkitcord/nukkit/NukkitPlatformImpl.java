package top.dsbbs2.bukkitcord.nukkit;

import cn.nukkit.*;
import cn.nukkit.command.*;
import top.dsbbs2.bukkitcord.api.IPlayer;
import top.dsbbs2.bukkitcord.api.*;
import top.dsbbs2.bukkitcord.bukkit.*;

import java.util.*;

public class NukkitPlatformImpl implements IPlatform {
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
        Server.getInstance().dispatchCommand((CommandSender) sender.getDelegate(),cmd);
    }

    @Override
    public ICommandSender getConSoleSender() {
        return new NukkitCommandSenderImpl(Server.getInstance().getConsoleSender());
    }

    @Override
    public IPlayer getPlayer(String n) {
        return new NukkitPlayerImpl(Server.getInstance().getPlayer(n));
    }

    @Override
    public IPlayer getPlayer(UUID u) {
        return new NukkitPlayerImpl(Server.getInstance().getPlayer(u).get());
    }

    @Override
    public void broadcast(String string) {
        Server.getInstance().broadcastMessage(string);
    }

    @Override
    public void broadcast(String string, String permission) {
        Server.getInstance().broadcast(string,permission);
    }

    @Override
    public ArrayList<IPlayer> getOnlinePlayers() {
        ArrayList<IPlayer> ret=new ArrayList<>();
        return ret;
    }

    @Override
    public ArrayList<String> getOnlinePlayersName() {
        ArrayList<String> ret=new ArrayList<>();
        return ret;
    }

    @Override
    public boolean getBungeeCord() {
        return Server.getInstance().getConfig().getBoolean("settings.bungeecord");
    }
}
