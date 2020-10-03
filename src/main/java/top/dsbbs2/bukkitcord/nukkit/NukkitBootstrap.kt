package top.dsbbs2.bukkitcord.nukkit

import top.dsbbs2.bukkitcord.api.PlatformManager.bootstrapPlugin

class NukkitBootstrap : NukkitPluginImpl() {
    init {
        bootstrapPlugin = this
        NukkitPluginImpl()
    }
}