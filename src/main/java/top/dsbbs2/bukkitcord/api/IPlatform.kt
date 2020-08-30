package top.dsbbs2.bukkitcord.api

import java.util.*

interface IPlatform {
    val pluginManager: IPluginManager?
    fun dispatchCommand(sender: ICommandSender?, cmd: String?)
    val conSoleSender: ICommandSender?
    fun getPlayer(n: String?): IPlayer?
    fun getPlayer(u: UUID?): IPlayer?
    fun broadcast(string: String?)
    fun broadcast(string: String?, permission: String?)
    val onlinePlayers: ArrayList<IPlayer?>?
    val onlinePlayersName: ArrayList<String?>?
    val bungeeCord: Boolean
}