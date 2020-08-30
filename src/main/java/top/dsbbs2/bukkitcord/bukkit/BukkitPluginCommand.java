package top.dsbbs2.bukkitcord.bukkit;

import com.google.common.collect.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import top.dsbbs2.bukkitcord.api.*;

import java.util.*;

public class BukkitPluginCommand extends Command implements ICommand,PluginIdentifiableCommand {
    public ICommandExecutor executor;
    private final IPlugin owner;
    public ITabCompleter completer;

    public BukkitPluginCommand(String name,ICommandExecutor executor, IPlugin owner) {
        super(name);
        this.executor=executor;
        this.owner=owner;
    }

    @Override
    public String[] getPlatformAliases() {
        return super.getAliases().parallelStream().toArray(String[]::new);
    }

    @Override
    public void setPlatformAliases(String[] aliases) {
        super.setAliases(Lists.newArrayList(aliases));
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
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        if (completer == null)
            return Lists.newArrayList();
        if (sender instanceof Player)
            return completer.tabComplete(new BukkitPlayerImpl((Player) sender),this, alias, args);
        else return completer.tabComplete(new BukkitCommandSenderImpl(sender),this, alias, args);
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        //System.out.println("test");
        if (!owner.isEnabled())
            return true;
        if (sender instanceof Player)
            return executor.execute(new BukkitPlayerImpl((Player) sender),this,args);
        else return executor.execute(new BukkitCommandSenderImpl(sender),this,args);
    }

    @Override
    public Plugin getPlugin() {
        return (Plugin)this.owner;
    }
}
