package top.dsbbs2.bukkitcord.bukkit;

import net.md_5.bungee.api.chat.*;
import org.bukkit.command.*;
import top.dsbbs2.bukkitcord.api.*;

public class BukkitCommandSenderImpl implements ICommandSender {
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
        for(String i2 : strings)
          i.sendMessage(i2);
    }

    @Override
    public void sendMessage(BaseComponent... baseComponents) {
        for(BaseComponent i2 : baseComponents)
            this.sendMessage(i2);
    }

    @Override
    public void sendMessage(BaseComponent baseComponent) {
        i.sendMessage(baseComponent.toLegacyText());
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
    public BukkitCommandSenderImpl(CommandSender i)
    {
        this.i=i;
    }
}
