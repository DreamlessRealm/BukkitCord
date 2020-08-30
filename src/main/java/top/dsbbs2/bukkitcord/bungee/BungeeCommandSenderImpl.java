package top.dsbbs2.bukkitcord.bungee;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.chat.*;
import top.dsbbs2.bukkitcord.api.*;

public class BungeeCommandSenderImpl implements ICommandSender {
    @Override
    public String getName() {
        return i.getName();
    }

    @Override
    public void sendMessage(String s) {
        i.sendMessage(s);
    }

    @Override
    public void sendMessages(String... strings) {
        i.sendMessages(strings);
    }

    @Override
    public void sendMessage(BaseComponent... baseComponents) {
        i.sendMessage(baseComponents);
    }

    @Override
    public void sendMessage(BaseComponent baseComponent) {
        i.sendMessage(baseComponent);
    }

    @Override
    public boolean hasPermission(String s) {
        return i.hasPermission(s);
    }

    @Override
    public CommandSender getDelegate() {
        return i;
    }

    private final CommandSender i;
    public BungeeCommandSenderImpl(CommandSender i)
    {
        this.i=i;
    }
}
