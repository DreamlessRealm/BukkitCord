
package top.dsbbs2.bukkitcord.bungee;

import net.md_5.bungee.*;
import top.dsbbs2.bukkitcord.api.*;

import java.util.*;

public final class BungeeCommandRegistryImpl implements ICommandRegistry
{
  private BungeeCommandRegistryImpl()
  {

  }
  public static final BungeeCommandRegistryImpl INSTANCE=new BungeeCommandRegistryImpl();

  private Vector<ICommand> commands = new Vector<>();

  public Vector<ICommand> getCommands()
  {
    return this.commands;
  }

  public ICommand setTabCom(final ICommand pc, final ITabCompleter tc)
  {
    pc.setPlatformTabCompleter(tc);
    return pc;
  }

  public ICommand setComUsa(final ICommand pc, final String u)
  {
    pc.setPlatformUsage(u);
    return pc;
  }

  public ICommand setComPer(final ICommand pc, final String p)
  {
    pc.setPermission(p);
    return pc;
  }

  public ICommand setComAlias(final ICommand pc, final String... alias)
  {
    pc.setPlatformAliases(alias);
    return pc;
  }

  public void regComWithoutRecording(final IPlugin plugin, final ICommand c)
  {
    BungeeCord.getInstance().pluginManager.registerCommand((net.md_5.bungee.api.plugin.Plugin) plugin,(net.md_5.bungee.api.plugin.Command) c);
  }

  public void regCom(final IPlugin plugin, final ICommand c)
  {
      regComWithoutRecording(plugin,c);
      this.commands.add(c);
  }

  public void regComWithCompleter(final IPlugin plugin, final ICommand c)
  {
    this.regCom(plugin, setTabCom(c,(ITabCompleter) c.getPlatformExecutor()));
  }

  public ICommand newPluginCommand(final String name, final ICommandExecutor ce, final IPlugin plugin)
  {
    try {
      final ICommand pc = new BungeePluginCommand(name,ce,plugin);
      pc.setPlatformExecutor(ce);
      return pc;
    } catch (final Throwable e) {
      throw new RuntimeException(e);
    }
  }

  public ICommand newPluginCommand(final String name, final IPlugin plugin)
  {
    return newPluginCommand(name,plugin,plugin);
  }
}
