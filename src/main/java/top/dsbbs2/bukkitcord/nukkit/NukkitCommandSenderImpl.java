package top.dsbbs2.bukkitcord.nukkit;

import cn.nukkit.command.*;
import net.md_5.bungee.api.chat.*;
import top.dsbbs2.bukkitcord.api.*;

public class NukkitCommandSenderImpl implements ICommandSender {
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
    public NukkitCommandSenderImpl(CommandSender i)
    {
        this.i=i;
    }
}
