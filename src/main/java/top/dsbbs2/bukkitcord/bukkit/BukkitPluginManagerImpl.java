package top.dsbbs2.bukkitcord.bukkit;

import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;
import top.dsbbs2.bukkitcord.api.*;

import java.lang.reflect.*;

public class BukkitPluginManagerImpl implements IPluginManager {
    @Override
    public void registerEvents(IPlugin plugin, IListener listener) {
        for(Method i : listener.getClass().getDeclaredMethods())
        {
            i.setAccessible(true);
            EventHandler eh=i.getDeclaredAnnotation(EventHandler.class);
            if (Modifier.isStatic(i.getModifiers()))
                continue;
            if (eh!=null)
            {
                if (i.getParameterCount()==1)
                {
                    if (i.getReturnType().equals(Void.TYPE))
                    {
                        if (Event.class.isAssignableFrom(i.getParameterTypes()[0]))
                        {
                            Bukkit.getPluginManager().registerEvent((Class<? extends Event>) i.getParameterTypes()[0], new Listener() {},eh.priority(),(l,e)->{
                                if (!((Plugin)plugin).isEnabled())
                                    return;
                                try {
                                    i.invoke(listener,e);
                                } catch (InvocationTargetException | IllegalAccessException exception) {
                                    throw new RuntimeException(exception);
                                }
                            },(Plugin)plugin,eh.ignoreCancelled());
                        }
                    }
                }
            }
        }
    }

    @Override
    public PluginManager getDelegate() {
        return Bukkit.getPluginManager();
    }
}
