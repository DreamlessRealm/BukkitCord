package top.dsbbs2.bukkitcord.bungee

import top.dsbbs2.bukkitcord.api.PlatformManager.bootstrapPlugin

class BungeeBootstrap : BungeePluginImpl() {
    init {
        bootstrapPlugin = this
        BungeePlatformImpl()
    }
}