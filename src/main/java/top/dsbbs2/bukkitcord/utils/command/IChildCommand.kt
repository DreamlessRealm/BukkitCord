package top.dsbbs2.bukkitcord.utils.command

import top.dsbbs2.bukkitcord.api.ICommand
import top.dsbbs2.bukkitcord.api.ICommandSender

abstract class IChildCommand {
    fun onCommand(sender: ICommandSender?, cmd: ICommand?, args: Array<String?>?) {}
    val permission: String
        get() = ""

    val usage: String
        get() = ""
}