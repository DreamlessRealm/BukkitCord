package top.dsbbs2.bukkitcord.api

interface ICommand {
    var permission: String?
    var platformAliases: Array<String?>?
    var platformExecutor: ICommandExecutor?
    var platformUsage: String?
    var platformTabCompleter: ITabCompleter?
}