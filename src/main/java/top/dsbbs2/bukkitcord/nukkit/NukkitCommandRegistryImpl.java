
package top.dsbbs2.bukkitcord.nukkit;

import cn.nukkit.*;
import cn.nukkit.command.*;
import top.dsbbs2.bukkitcord.api.*;
import top.dsbbs2.bukkitcord.bukkit.*;

import java.lang.reflect.*;
import java.util.*;

public final class NukkitCommandRegistryImpl implements ICommandRegistry
{
  private NukkitCommandRegistryImpl()
  {

  }
  public static final NukkitCommandRegistryImpl INSTANCE=new NukkitCommandRegistryImpl();
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
    try {
      final Field cmap = Server.getInstance().getClass().getDeclaredField("commandMap");
      cmap.setAccessible(true);
      final SimpleCommandMap scmap = (SimpleCommandMap) cmap.get(Server.getInstance());
      scmap.register(plugin.getPlatformDescription().getName(), (Command) c);
    } catch (final Throwable e) {
      throw new RuntimeException(e);
    }
  }

  public void regCom(final IPlugin plugin, final ICommand c)
  {
    try {
      final Field cmap = Server.getInstance().getClass().getDeclaredField("commandMap");
      cmap.setAccessible(true);
      final SimpleCommandMap scmap = (SimpleCommandMap) cmap.get(Server.getInstance());
      scmap.register(plugin.getPlatformDescription().getName(), (Command) c);
      this.commands.add(c);
    } catch (final Throwable e) {
      throw new RuntimeException(e);
    }
  }

  public void regComWithCompleter(final IPlugin plugin, final ICommand c)
  {
    this.regCom(plugin, this.setTabCom(c, (ITabCompleter) c.getPlatformExecutor()));
  }

  public ICommand newPluginCommand(final String name, final ICommandExecutor ce, final IPlugin plugin)
  {
    try {
      final ICommand pc = new BukkitPluginCommand(name,ce,plugin);
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
