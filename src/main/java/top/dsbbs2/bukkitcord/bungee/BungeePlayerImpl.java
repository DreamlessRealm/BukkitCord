package top.dsbbs2.bukkitcord.bungee;

import net.luckperms.api.*;
import net.luckperms.api.query.*;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.config.*;
import net.md_5.bungee.api.connection.*;
import org.jetbrains.annotations.*;
import top.dsbbs2.bukkitcord.api.*;
import top.dsbbs2.bukkitcord.utils.*;

import java.net.*;
import java.util.*;

public class BungeePlayerImpl extends BungeeCommandSenderImpl implements IPlayer {
    protected static final LuckPerms api = LuckPermsProvider.get();
    @Override
    public ProxiedPlayer getDelegate() {
        return i;
    }

    private final ProxiedPlayer i;
    private final UUID u;
    public BungeePlayerImpl(ProxiedPlayer player)
    {
        super(player);
        this.i =player;
        this.u=player.getUniqueId();
    }

    @Override
    public UUID getUniqueId() {
        return u;
    }
    @Override
    public String getServerName() {
        return i.getServer().getInfo().getName();
    }

    @Override
    public ArrayList<IPlayer> getServerOnlinePlayers() {
        ArrayList<IPlayer> ret=new ArrayList<>();
        i.getServer().getInfo().getPlayers().forEach(i->ret.add(new BungeePlayerImpl(i)));
        return ret;
    }

    @Override
    public ArrayList<String> getServerOnlinePlayerNames() {
        ArrayList<String> ret=new ArrayList<>();
        i.getServer().getInfo().getPlayers().forEach(i->ret.add(i.getName()));
        return ret;
    }

    @Override
    public void connect(String serverName) {
        ServerInfo target = ProxyServer.getInstance().getServerInfo(serverName);
        i.connect(target);
    }

    @Override
    public String getPlayerPrefix() {
        try{
            QueryOptions queryOptions = Objects.requireNonNull(api).getContextManager().getQueryOptions(i);
            String prefix = Objects.requireNonNull(LuckPermsProvider.get().getUserManager().getUser(u)).getCachedData().getMetaData(queryOptions).getPrefix();
            if(prefix == null)
                return "";
            else
                return prefix;
        }catch (Throwable e){
            return "";
        }
    }

    @Override
    public String getPlayerSuffix() {
        try{
            QueryOptions queryOptions = Objects.requireNonNull(api).getContextManager().getQueryOptions(i);
            String suffix = Objects.requireNonNull(LuckPermsProvider.get().getUserManager().getUser(u)).getCachedData().getMetaData(queryOptions).getSuffix();
            if(suffix == null)
                return "";
            else
                return suffix;
        }catch (Throwable e){
            return "";
        }
    }

    @Override
    public void chat(String mess) {
        i.chat(mess);
    }

    @Override
    public void sendBungeeCordPlayerMessage(IPlayer p, String message) {
        p.sendMessage(message);
    }

    @Override
    public int getPing() {
        return i.getPing();
    }

    @Override
    public boolean pingIsInRange(@Nullable Integer var1, @Nullable Integer var2) {
        return Utils.INSTANCE.isInRange(getPing(),var1,var2);
    }

    @NotNull
    @Override
    public InetSocketAddress getAddress() {
        return i.getAddress();
    }
}
