package top.dsbbs2.bukkitcord.bungee;

import net.luckperms.api.*;
import net.luckperms.api.query.*;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.config.*;
import net.md_5.bungee.api.connection.*;
import top.dsbbs2.bukkitcord.api.*;

import java.util.*;

public class BungeePlayerImpl extends BungeeCommandSenderImpl implements IPlayer {
    protected static LuckPerms api = LuckPermsProvider.get();
    @Override
    public ProxiedPlayer getDelegate() {
        return player;
    }

    private final ProxiedPlayer player;
    public BungeePlayerImpl(ProxiedPlayer player)
    {
        super(player);
        this.player=player;
    }

    @Override
    public UUID getUniqueId() {
        return player.getUniqueId();
    }
    @Override
    public String getServerName() {
        return player.getServer().getInfo().getName();
    }

    @Override
    public ArrayList<IPlayer> getServerOnlinePlayers() {
        ArrayList<IPlayer> ret=new ArrayList<>();
        player.getServer().getInfo().getPlayers().forEach(i->ret.add(new BungeePlayerImpl(i)));
        return ret;
    }

    @Override
    public ArrayList<String> getServerOnlinePlayerNames() {
        ArrayList<String> ret=new ArrayList<>();
        player.getServer().getInfo().getPlayers().forEach(i->ret.add(i.getName()));
        return ret;
    }

    @Override
    public void connect(String serverName) {
        ServerInfo target = ProxyServer.getInstance().getServerInfo(serverName);
        player.connect(target);
    }
    @Override
    public String getPlayerPrefix() {
        UUID u = player.getUniqueId();
        QueryOptions queryOptions = Objects.requireNonNull(api).getContextManager().getQueryOptions(player);
        String prefix = Objects.requireNonNull(LuckPermsProvider.get().getUserManager().getUser(u)).getCachedData().getMetaData(queryOptions).getPrefix();
        if(prefix == null)
            return "";
        else
            return prefix;
    }

    @Override
    public String getPlayerSuffix() {
        UUID u = player.getUniqueId();
        QueryOptions queryOptions = Objects.requireNonNull(api).getContextManager().getQueryOptions(player);
        String suffix = Objects.requireNonNull(LuckPermsProvider.get().getUserManager().getUser(u)).getCachedData().getMetaData(queryOptions).getSuffix();
        if(suffix == null)
            return "";
        else
            return suffix;
    }

    @Override
    public void chat(String mess) {
        player.chat(mess);
    }

    @Override
    public void sendBungeeCordPlayerMessage(IPlayer p, String message) {
        p.sendMessage(message);
    }
}
