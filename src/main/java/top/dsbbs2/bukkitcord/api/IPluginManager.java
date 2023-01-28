package top.dsbbs2.bukkitcord.api;

public interface IPluginManager {
    void registerEvents(IPlugin plugin, IListener listener);
    Object getDelegate();
}
