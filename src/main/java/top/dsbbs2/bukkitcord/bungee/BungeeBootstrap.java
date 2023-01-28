package top.dsbbs2.bukkitcord.bungee;

import static top.dsbbs2.bukkitcord.api.PlatformManager.setBootstrapPlugin;

public class BungeeBootstrap extends BungeePluginImpl {
    {
        setBootstrapPlugin(this);
    }
}
