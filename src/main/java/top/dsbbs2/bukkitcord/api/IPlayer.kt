package top.dsbbs2.bukkitcord.api

import java.util.*

interface IPlayer : ICommandSender {
    val uniqueId: UUID?
    val serverName: String?
    val serverOnlinePlayers: ArrayList<IPlayer?>?
    val serverOnlinePlayerNames: ArrayList<String?>?
    fun connect(serverName: String?)
    val playerPrefix: String?
    val playerSuffix: String?
    fun chat(mess: String?)
    fun sendBungeeCordPlayerMessage(p: IPlayer?, message: String?)
}