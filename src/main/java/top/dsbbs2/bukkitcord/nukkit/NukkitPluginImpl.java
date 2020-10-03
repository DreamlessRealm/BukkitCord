package top.dsbbs2.bukkitcord.nukkit;

import cn.nukkit.command.*;
import cn.nukkit.plugin.*;
import com.google.common.collect.*;
import top.dsbbs2.bukkitcord.api.*;

import java.util.*;

public class NukkitPluginImpl extends PluginBase implements IPlugin {
    private final IPluginDescription description=new NukkitPluginDescriptionImpl(this.getDescription());
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
        return Lists.newArrayList();
    }
}
