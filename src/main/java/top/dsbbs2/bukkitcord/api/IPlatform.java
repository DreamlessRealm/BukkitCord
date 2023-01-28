package top.dsbbs2.bukkitcord.api;

import java.util.*;

public interface IPlatform {
    IPluginManager getPluginManager();
    void dispatchCommand(ICommandSender sender, String cmd);
    ICommandSender getConSoleSender();
    IPlayer getPlayer(String n);
    IPlayer getPlayer(UUID u);
    void broadcast(String string);
    void broadcast(String string, String permission);
    ArrayList<IPlayer> getOnlinePlayers();
    ArrayList<String> getOnlinePlayersName();
    boolean isBungeeCord();
}
