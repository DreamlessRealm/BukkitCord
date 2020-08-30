package top.dsbbs2.bukkitcord.utils.command

import top.dsbbs2.bukkitcord.utils.command.IChildCommand
import java.util.*

object CommandUtil {
    fun commandListToCommandNameList(v: Vector<IChildCommand>): Vector<String> {
        val ret = Vector<String>()
        for (i in v) {
            ret.add(i.javaClass.simpleName)
        }
        return ret
    }

    fun getCommand(l: Vector<IChildCommand>, cmd: String?): IChildCommand? {
        for (i in l) {
            if (i.javaClass.simpleName.equals(cmd, ignoreCase = true)) return i
        }
        return null
    }
}