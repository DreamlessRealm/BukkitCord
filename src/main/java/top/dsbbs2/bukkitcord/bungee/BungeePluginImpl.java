package top.dsbbs2.bukkitcord.bungee;

import com.google.common.collect.*;
import net.md_5.bungee.*;
import net.md_5.bungee.api.plugin.*;
import net.md_5.bungee.event.*;
import top.dsbbs2.bukkitcord.api.*;

import java.lang.reflect.*;
import java.util.*;

public class BungeePluginImpl extends Plugin implements IPlugin {
    private final IPluginDescription description=new BungeePluginDescriptionImpl(this.getDescription());
    private Set<IListener> l=new HashSet<>();
    private  boolean e;
    @Override
    public IPluginDescription getPlatformDescription()
    {
        return this.description;
    }

    @Override
    public Set<IListener> getListeners() {
        return l;
    }

    @Override
    public boolean isEnabled() {
        return e;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        e=true;
    }
    @Override
    public boolean execute(ICommandSender sender, ICommand command, String[] args) {
        return false;
    }
    @Override
    public void onDisable() {
        super.onDisable();
        e=false;
        l.parallelStream().forEach(i->{
            PluginManager pm= BungeeCord.getInstance().pluginManager;
            try {
                Field eb=pm.getClass().getDeclaredField("eventBus");
                eb.setAccessible(true);
                EventBus bus=(EventBus)eb.get(pm);
                bus.unregister(i);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        l.clear();
    }

    @Override
    public List<String> tabComplete(ICommandSender sender, ICommand command, String alias, String[] args) throws IllegalArgumentException {
        return Lists.newArrayList();
    }
}
