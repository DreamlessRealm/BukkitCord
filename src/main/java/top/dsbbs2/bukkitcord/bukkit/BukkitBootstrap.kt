package top.dsbbs2.bukkitcord.bukkit

import top.dsbbs2.bukkitcord.api.PlatformManager.bootstrapPlugin

class BukkitBootstrap : BukkitPluginImpl() {
    init {
        bootstrapPlugin = this
        BukkitPlatformImpl()
    }
}