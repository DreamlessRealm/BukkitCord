package top.dsbbs2.bukkitcord.api

import java.io.File

interface IPlugin : ICommandExecutor, ITabCompleter {
    fun onLoad()
    fun onEnable()
    fun onDisable()
    val dataFolder: File?
    val platformDescription: IPluginDescription?
    val listeners: Set<IListener?>?
    val isEnabled: Boolean
}