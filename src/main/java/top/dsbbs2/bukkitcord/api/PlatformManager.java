package top.dsbbs2.bukkitcord.api;

import top.dsbbs2.bukkitcord.bukkit.BukkitCommandRegistryImpl;
import top.dsbbs2.bukkitcord.bukkit.BukkitPlatformImpl;
import top.dsbbs2.bukkitcord.bungee.BungeeCommandRegistryImpl;
import top.dsbbs2.bukkitcord.bungee.BungeePlatformImpl;

public class PlatformManager {
    private static IPlatform platform = null;
    private static IPlugin bootstrapPlugin = null;
    public static void setBootstrapPlugin(IPlugin bootstrapPlugin) {
       if(PlatformManager.bootstrapPlugin!=null) throw IllegalStateException("bootstrapPlugin");
       bootstrapPlugin = bootstrapPlugin;
    }
    public static IPlugin getBootstrapPlugin()
    {
        return bootstrapPlugin;
    }
    public static IPlatform getPlatform() {
        return platform;
    }

    public static void setPlatform(platform: IPlatform?) {
        if(PlatformManager.platform!=null) throw IllegalStateException("platform");
        PlatformManager.platform = platform;
    }

    public static Platform getCurrentPlatform() {
       if(platform instanceof BukkitPlatformImpl) return Platform.BUKKIT;
       return (platform instanceof BungeePlatformImpl) ? Platform.BUNGEE : Platform.UNKNOWN;
    }

    public static ICommandRegistry currentPlatformCommandRegistry() {
        if(platform instanceof BukkitPlatformImpl) return BukkitCommandRegistryImpl.INSTANCE;
        return (platform instanceof BungeePlatformImpl) ? BungeeCommandRegistryImpl.INSTANCE : null;
    }
}
