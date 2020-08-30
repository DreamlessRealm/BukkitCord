package top.dsbbs2.bukkitcord.bungee;

import com.google.common.collect.*;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.plugin.*;
import top.dsbbs2.bukkitcord.api.*;

public class BungeePluginCommand extends Command implements ICommand,TabExecutor{
    public String permission;
    public String[] aliases;
    public ICommandExecutor executor;
    public String usage;
    public final IPlugin plugin;
    public ITabCompleter completer;
    public BungeePluginCommand(String name,ICommandExecutor executor,IPlugin plugin) {
        this(name,executor,plugin,null);
    }

    public BungeePluginCommand(String name,ICommandExecutor executor,IPlugin plugin, String permission, String... aliases) {
        super(name);
        this.executor=executor;
        this.plugin=plugin;
        this.permission=permission;
        this.aliases=aliases;
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (!plugin.isEnabled())
            return;
        boolean b;
        if (commandSender instanceof ProxiedPlayer)
        {
            b = this.executor.execute(new BungeePlayerImpl((ProxiedPlayer) commandSender), this, strings);
        }else {
            b = this.executor.execute(new BungeeCommandSenderImpl((CommandSender) commandSender), this, strings);
        }
        if (!b)
            commandSender.sendMessage(this.usage);
    }

    @Override
    public String[] getAliases() {
        return this.getPlatformAliases();
    }

    @Override
    public String getPermission() {
        return this.permission;
    }

    @Override
    public String[] getPlatformAliases() {
        return this.aliases;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public void setPlatformAliases(String[] aliases) {
        this.aliases = aliases;
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
        return usage;
    }

    @Override
    public void setPlatformUsage(String usage) {
        this.usage=usage;
    }

    @Override
    public void setPlatformTabCompleter(ITabCompleter completer) {
        this.completer=completer;
    }

    @Override
    public ITabCompleter getPlatformTabCompleter() {
        return completer;
    }
    @Override
    public Iterable<String> onTabComplete(CommandSender sender, String[] args) {
        if (completer==null)
            return Lists.newArrayList();
        if (sender instanceof ProxiedPlayer)
            return completer.tabComplete(new BungeePlayerImpl((ProxiedPlayer) sender),this, this.getName(),args);
        else return completer.tabComplete(new BungeeCommandSenderImpl(sender),this, this.getName(),args);
    }
}
