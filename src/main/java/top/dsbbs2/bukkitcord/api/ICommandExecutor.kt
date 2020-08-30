package top.dsbbs2.bukkitcord.api

@FunctionalInterface
interface ICommandExecutor {
    fun execute(sender: ICommandSender?, command: ICommand?, args: Array<String?>?): Boolean
}