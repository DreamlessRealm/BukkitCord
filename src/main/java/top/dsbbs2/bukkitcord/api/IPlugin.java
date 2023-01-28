package top.dsbbs2.bukkitcord.api;

import java.io.File;

public interface IPlugin extends ICommandExecutor, ITabCompleter {
    void onLoad();
    void onEnable();
    void onDisable();
    File getDataFolder();
    IPluginDescription getPlatformDescription();
    Set<IListener> getListeners();
    boolean isEnabled();
}
