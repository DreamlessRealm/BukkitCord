package top.dsbbs2.bukkitcord.bungee;

import net.md_5.bungee.*;
import net.md_5.bungee.api.plugin.*;
import net.md_5.bungee.event.*;
import top.dsbbs2.bukkitcord.api.*;

import java.lang.reflect.*;
import java.util.*;

public class BungeePluginManagerImpl implements IPluginManager {

    @Override
    public void registerEvents(IPlugin plugin, IListener listener) {
        PluginManager pm = BungeeCord.getInstance().pluginManager;
        try {
            Field eb = pm.getClass().getDeclaredField("eventBus");
            eb.setAccessible(true);
            EventBus bus = (EventBus) eb.get(pm);
            bus.register(listener);
            assert plugin != null;
            Objects.requireNonNull(plugin.getListeners()).add(listener);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PluginManager getDelegate() {
        return BungeeCord.getInstance().pluginManager;
    }
}
