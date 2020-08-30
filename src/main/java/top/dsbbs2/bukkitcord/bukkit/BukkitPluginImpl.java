package top.dsbbs2.bukkitcord.bukkit;

import org.bukkit.command.*;
import org.bukkit.plugin.java.*;
import top.dsbbs2.bukkitcord.api.*;

import java.util.*;

public class BukkitPluginImpl extends JavaPlugin implements IPlugin {
    private final IPluginDescription description=new BukkitPluginDescriptionImpl(this.getDescription());
    private final Set<IListener> l=new HashSet<>();
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
    public void onDisable() {
        super.onDisable();
        l.clear();
    }

    @Override
    public boolean execute(ICommandSender sender, ICommand command, String[] args) {
        return super.onCommand((CommandSender) sender.getDelegate(),(Command) command,((Command) command).getName(),args);
    }

    @Override
    public List<String> tabComplete(ICommandSender sender, ICommand command, String alias, String[] args) throws IllegalArgumentException {
        return super.onTabComplete((CommandSender) sender.getDelegate(),(Command) command,alias,args);
    }
}
