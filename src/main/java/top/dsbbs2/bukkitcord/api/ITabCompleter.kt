package top.dsbbs2.bukkitcord.api

import kotlin.jvm.Throws

interface ITabCompleter {
    @Throws(IllegalArgumentException::class)
    fun tabComplete(sender: ICommandSender?, command: ICommand?, alias: String?, args: Array<String?>?): List<String?>?
}