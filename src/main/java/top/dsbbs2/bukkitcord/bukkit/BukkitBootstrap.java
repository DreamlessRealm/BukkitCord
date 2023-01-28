package top.dsbbs2.bukkitcord.bukkit;

import static top.dsbbs2.bukkitcord.api.PlatformManager.setBootstrapPlugin;

class BukkitBootstrap : BukkitPluginImpl() {
    {
        setBootstrapPlugin(this);
    }
}
