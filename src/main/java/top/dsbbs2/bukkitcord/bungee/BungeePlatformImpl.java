package top.dsbbs2.bukkitcord.bungee;

import net.md_5.bungee.*;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.connection.*;
import top.dsbbs2.bukkitcord.api.*;

import java.util.*;

public class BungeePlatformImpl implements IPlatform {
    private final BungeePluginManagerImpl pluginManager=new BungeePluginManagerImpl();
    {
        PlatformManager.setPlatform(this);
    }

    @Override
    public IPluginManager getPluginManager() {
        return pluginManager;
    }

    @Override
    public void dispatchCommand(ICommandSender sender, String cmd) {
        ProxyServer.getInstance().getPluginManager().dispatchCommand((CommandSender) sender.getDelegate(),cmd);
    }

    @Override
    public ICommandSender getConSoleSender() {
        return new BungeeCommandSenderImpl(ProxyServer.getInstance().getConsole());
    }

    @Override
    public IPlayer getPlayer(String n) {
        return new BungeePlayerImpl(BungeeCord.getInstance().getPlayer(n));
    }

    @Override
    public IPlayer getPlayer(UUID u) {
        return new BungeePlayerImpl(BungeeCord.getInstance().getPlayer(u));
    }

    @Override
    public void broadcast(String string) {
        BungeeCord.getInstance().broadcast(string);
    }

    @Override
    public void broadcast(String string, String permission) {
        ProxyServer.getInstance().getConsole().sendMessage(string);
        for(ProxiedPlayer p:BungeeCord.getInstance().getPlayers()){
            if(p.hasPermission(permission))
                p.sendMessage(string);
        }
    }

    @Override
    public ArrayList<IPlayer> getOnlinePlayers() {
        ArrayList<IPlayer> ret=new ArrayList<>();
        for(ProxiedPlayer p:BungeeCord.getInstance().getPlayers())
            ret.add(new BungeePlayerImpl(p));
        return ret;
    }

    @Override
    public ArrayList<String> getOnlinePlayersName() {
        ArrayList<String> ret=new ArrayList<>();
        for(ProxiedPlayer p:BungeeCord.getInstance().getPlayers())
            ret.add(p.getName());
        return ret;
    }

    @Override
    public boolean getBungeeCord() {
        return true;
    }

}
