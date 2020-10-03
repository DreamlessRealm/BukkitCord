package top.dsbbs2.bukkitcord.nukkit;

import cn.nukkit.*;
import cn.nukkit.command.*;
import cn.nukkit.plugin.*;
import top.dsbbs2.bukkitcord.api.*;

public class NukkitPluginCommand extends Command implements ICommand, PluginIdentifiableCommand {
    public ICommandExecutor executor;
    private final IPlugin owner;
    public ITabCompleter completer;

    public NukkitPluginCommand(String name, ICommandExecutor executor, IPlugin owner) {
        super(name);
        this.executor=executor;
        this.owner=owner;
    }

    @Override
    public String[] getPlatformAliases() {
        return super.getAliases();
    }

    @Override
    public void setPlatformAliases(String[] aliases) {
        super.setAliases(aliases);
    }

    @Override
    public ICommandExecutor getPlatformExecutor() {
        return this.executor;
    }

    @Override
    public void setPlatformExecutor(ICommandExecutor executor) {
        this.executor=executor;
    }

    @Override
    public String getPlatformUsage() {
        return super.getUsage();
    }

    @Override
    public void setPlatformUsage(String usage) {
        super.setUsage(usage);
    }

    @Override
    public ITabCompleter getPlatformTabCompleter() {
        return completer;
    }

    @Override
    public void setPlatformTabCompleter(ITabCompleter completer) {
        this.completer=completer;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        //System.out.println("test");
        if (!owner.isEnabled())
            return true;
        if (sender instanceof Player)
            return executor.execute(new NukkitPlayerImpl((Player) sender),this,args);
        else return executor.execute(new NukkitCommandSenderImpl(sender),this,args);
    }

    @Override
    public Plugin getPlugin() {
        return (Plugin)this.owner;
    }
}
