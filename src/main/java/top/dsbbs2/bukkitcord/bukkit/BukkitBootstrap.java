package top.dsbbs2.bukkitcord.bukkit;

import static top.dsbbs2.bukkitcord.api.PlatformManager.bootstrapPlugin;

class BukkitBootstrap : BukkitPluginImpl() {
    {
        bootstrapPlugin = this;
    }
}
