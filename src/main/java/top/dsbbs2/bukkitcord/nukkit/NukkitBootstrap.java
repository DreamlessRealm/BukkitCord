package top.dsbbs2.bukkitcord.nukkit;

import static top.dsbbs2.bukkitcord.api.PlatformManager.setBootstrapPlugin;

public class NukkitBootstrap extends NukkitPluginImpl {
    {
        setBootstrapPlugin(this);
    }
}
