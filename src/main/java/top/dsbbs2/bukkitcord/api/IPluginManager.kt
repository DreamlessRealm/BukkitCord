package top.dsbbs2.bukkitcord.api

interface IPluginManager {
    fun registerEvents(plugin: IPlugin?, listener: IListener?)
    val delegate: Any?
}