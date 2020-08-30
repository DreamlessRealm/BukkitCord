package top.dsbbs2.bukkitcord.api

import top.dsbbs2.bukkitcord.bukkit.BukkitCommandRegistryImpl
import top.dsbbs2.bukkitcord.bukkit.BukkitPlatformImpl
import top.dsbbs2.bukkitcord.bungee.BungeeCommandRegistryImpl
import top.dsbbs2.bukkitcord.bungee.BungeePlatformImpl

object PlatformManager {
    private var platform: IPlatform? = null
    @JvmStatic
    var bootstrapPlugin: IPlugin? = null
        set(bootstrapPlugin) {
            field = if (PlatformManager.bootstrapPlugin == null) bootstrapPlugin else throw IllegalStateException("bootstrapPlugin")
        }

    fun getPlatform(): IPlatform? {
        return platform
    }

    @JvmStatic
    fun setPlatform(platform: IPlatform?) {
        if (PlatformManager.platform == null) PlatformManager.platform = platform else throw IllegalStateException("platform")
    }

    val currentPlatform: Platform
        get() {
            if (platform is BukkitPlatformImpl) return Platform.BUKKIT
            return if (platform is BungeePlatformImpl) Platform.BUNGEE else Platform.UNKNOWN
        }

    val currentPlatformCommandRegistry: ICommandRegistry?
        get() {
            if (platform is BukkitPlatformImpl) return BukkitCommandRegistryImpl.INSTANCE
            return if (platform is BungeePlatformImpl) BungeeCommandRegistryImpl.INSTANCE else null
        }
}