package top.dsbbs2.bukkitcord.api

import net.md_5.bungee.api.chat.BaseComponent

interface ICommandSender {
    val name: String?
    fun sendMessage(var1: String?)
    fun sendMessages(vararg var1: String?)
    fun sendMessage(vararg var1: BaseComponent?)
    fun sendMessage(var1: BaseComponent?)
    fun hasPermission(var1: String?): Boolean
    val delegate: Any?
}