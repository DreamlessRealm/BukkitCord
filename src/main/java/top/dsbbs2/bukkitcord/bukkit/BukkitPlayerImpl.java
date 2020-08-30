package top.dsbbs2.bukkitcord.bukkit;

import com.google.common.io.*;
import net.luckperms.api.*;
import net.luckperms.api.query.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import top.dsbbs2.bukkitcord.api.*;

import java.util.*;

public class BukkitPlayerImpl extends BukkitCommandSenderImpl implements IPlayer {
    protected static LuckPerms api = LuckPermsProvider.get();
    @Override
    public Player getDelegate() {
        return i;
    }

    private final Player i;
    public BukkitPlayerImpl(Player i)
    {
        super(i);
        this.i=i;
    }

    @Override
    public UUID getUniqueId() {
        return i.getUniqueId();
    }
    @Override
    public String getServerName() {
        return Bukkit.getServer().getName();
    }

    @Override
    public ArrayList<IPlayer> getServerOnlinePlayers() {
        ArrayList<IPlayer> ret=new ArrayList<>();
        Bukkit.getServer().getOnlinePlayers().forEach(i->ret.add(new BukkitPlayerImpl(i)));
        return ret;
    }

    @Override
    public ArrayList<String> getServerOnlinePlayerNames() {
        ArrayList<String> ret=new ArrayList<>();
        Bukkit.getServer().getOnlinePlayers().forEach(i->ret.add(i.getName()));
        return ret;
    }

    @Override
    public void connect(String serverName) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(serverName);

        i.sendPluginMessage((Plugin) PlatformManager.getBootstrapPlugin(), "BungeeCord", out.toByteArray());
    }

    @Override
    public String getPlayerPrefix() {
        UUID u = i.getUniqueId();
        QueryOptions queryOptions = Objects.requireNonNull(api).getContextManager().getQueryOptions(i);
        String prefix = Objects.requireNonNull(LuckPermsProvider.get().getUserManager().getUser(u)).getCachedData().getMetaData(queryOptions).getPrefix();
        if(prefix == null)
            return "";
        else
            return prefix;
    }

    @Override
    public String getPlayerSuffix() {
        UUID u = i.getUniqueId();
        QueryOptions queryOptions = Objects.requireNonNull(api).getContextManager().getQueryOptions(i);
        String suffix = Objects.requireNonNull(LuckPermsProvider.get().getUserManager().getUser(u)).getCachedData().getMetaData(queryOptions).getSuffix();
        if(suffix == null)
            return "";
        else
            return suffix;
    }

    @Override
    public void sendBungeeCordPlayerMessage(IPlayer ip, String message){
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        Plugin plugin = (Plugin) PlatformManager.getBootstrapPlugin();
        out.writeUTF("Message");
        out.writeUTF(ip.getName());
        out.writeUTF(message);
        i.sendPluginMessage(plugin,"BungeeCord", out.toByteArray());
    }

    @Override
    public void chat(String mess) {
        i.chat(mess);
    }
}
