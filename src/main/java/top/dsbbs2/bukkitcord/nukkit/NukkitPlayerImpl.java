package top.dsbbs2.bukkitcord.nukkit;

import cn.nukkit.*;
import cn.nukkit.plugin.*;
import com.google.common.io.*;
import net.luckperms.api.*;
import net.luckperms.api.query.*;
import org.jetbrains.annotations.*;
import top.dsbbs2.bukkitcord.api.IPlayer;
import top.dsbbs2.bukkitcord.api.*;
import top.dsbbs2.bukkitcord.utils.*;

import java.net.*;
import java.util.*;

public class NukkitPlayerImpl extends NukkitCommandSenderImpl implements IPlayer{
    protected static final LuckPerms api = LuckPermsProvider.get();
    @Override
    public Player getDelegate() {
        return i;
    }

    private final Player i;
    private final UUID u;
    public NukkitPlayerImpl(Player i)
    {
        super(i);
        this.i=i;
        this.u=i.getUniqueId();
    }

    @Override
    public UUID getUniqueId() {
        return u;
    }
    @Override
    public String getServerName() {
        return Server.getInstance().getName();
    }

    @Override
    public ArrayList<IPlayer> getServerOnlinePlayers() {
        ArrayList<IPlayer> ret=new ArrayList<>();
        //Server.getInstance().getOnlinePlayers().forEach(i->ret.add(new NukkitPlayerImpl(Server.getInstance().getPlayer(i).get())));
        return ret;
    }

    @Override
    public ArrayList<String> getServerOnlinePlayerNames() {
        ArrayList<String> ret=new ArrayList<>();
        //Server.getInstance().getOnlinePlayers().forEach(i->ret.add(i.getName()));
        return ret;
    }

    @Override
    public void connect(String serverName) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(serverName);

        //i.sendPluginMessage((Plugin) PlatformManager.getBootstrapPlugin(), "BungeeCord", out.toByteArray());
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
    public void sendBungeeCordPlayerMessage(IPlayer ip, String message){
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        Plugin plugin = (Plugin) PlatformManager.getBootstrapPlugin();
        out.writeUTF("Message");
        out.writeUTF(ip.getName());
        out.writeUTF(message);
        //i.sendPluginMessage(plugin,"BungeeCord", out.toByteArray());
    }

    @Override
    public void chat(String mess) {
        i.chat(mess);
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
        return InetSocketAddress.createUnresolved(i.getAddress(),25565);
    }
}
