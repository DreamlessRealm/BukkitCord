package top.dsbbs2.bukkitcord.api;

import net.md_5.bungee.api.chat.BaseComponent;

public interface ICommandSender {
    String getName();
    void sendMessage(String var1);
    void sendMessages(String... var1);
    void sendMessage(BaseComponent... var1);
    void sendMessage(BaseComponent var1);
    boolean hasPermission(String var1);
    Object getDelegate();
}
