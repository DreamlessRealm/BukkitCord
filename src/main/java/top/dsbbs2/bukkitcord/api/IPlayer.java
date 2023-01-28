package top.dsbbs2.bukkitcord.api;

import java.net.InetSocketAddress;
import java.util.*;

public interface IPlayer extends ICommandSender {
    UUID getUniqueId();
    String getServerName();
    ArrayList<IPlayer> getServerOnlinePlayers();
    ArrayList<String> getServerOnlinePlayerNames();
    void connect(String serverName);
    String getPlayerPrefix();
    String getPlayerSuffix();
    void chat(String mess);
    void sendBungeeCordPlayerMessage(IPlayer p, String message);
    int getPing();
    boolean pingIsInRange(int var1,int var2);
    InetSocketAddress getAddress();
}
