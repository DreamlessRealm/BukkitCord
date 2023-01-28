package top.dsbbs2.bukkitcord.api;

import java.util.*;

public interface ICommandRegistry {
    Vector<ICommand> getCommands();
    void setCommands(Vector<ICommand> cmds);
    ICommand setTabCom(ICommand pc, ITabCompleter tc);
    ICommand setComUsa(ICommand pc, String u);
    ICommand setComPer(ICommand pc, String p);
    ICommand setComAlias(ICommand pc, String... alias);
    void regComWithoutRecording(IPlugin plugin, ICommand c);
    void regCom(IPlugin plugin, ICommand c);
    void regComWithCompleter(IPlugin plugin, ICommand c);
    ICommand newPluginCommand(String name, ICommandExecutor ce, IPlugin plugin);
    ICommand newPluginCommand(String name, IPlugin plugin);
}
