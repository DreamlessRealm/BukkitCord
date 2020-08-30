package top.dsbbs2.bukkitcord.api

import java.util.*

interface ICommandRegistry {
    val commands: Vector<ICommand?>?
    fun setTabCom(pc: ICommand?, tc: ITabCompleter?): ICommand?
    fun setComUsa(pc: ICommand?, u: String?): ICommand?
    fun setComPer(pc: ICommand?, p: String?): ICommand?
    fun setComAlias(pc: ICommand?, vararg alias: String?): ICommand?
    fun regComWithoutRecording(plugin: IPlugin?, c: ICommand?)
    fun regCom(plugin: IPlugin?, c: ICommand?)
    fun regComWithCompleter(plugin: IPlugin?, c: ICommand?)
    fun newPluginCommand(name: String?, ce: ICommandExecutor?, plugin: IPlugin?): ICommand?
    fun newPluginCommand(name: String?, plugin: IPlugin?): ICommand?
}