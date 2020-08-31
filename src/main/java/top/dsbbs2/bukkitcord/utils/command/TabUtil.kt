package top.dsbbs2.bukkitcord.utils.command

import top.dsbbs2.bukkitcord.utils.ListUtil.hasDuplicatedElement
import top.dsbbs2.bukkitcord.utils.ListUtil.toLowerCaseList
import top.dsbbs2.bukkitcord.utils.ListUtil.toUpperCaseList
import java.util.*
import java.util.function.Consumer

object TabUtil {
    fun betterGetStartsWithListLowerCase(o: List<String>, s: String): List<String> {
        val temp = getStartsWithList(o, s, false)
        return if (hasDuplicatedElement(toLowerCaseList(temp))) getStartsWithList(o, s, true) else temp
    }

    fun betterGetStartsWithListUpperCase(o: List<String>, s: String): List<String> {
        val temp = getStartsWithList(o, s, false)
        return if (hasDuplicatedElement(toUpperCaseList(temp))) getStartsWithList(o, s, true) else temp
    }

    fun getStartsWithList(o: List<String>, s: String): List<String> {
        return getStartsWithList(o, s, false)
    }

    fun getStartsWithList(o: List<String>, s: String, caseSensitive: Boolean): List<String> {
        val ret: MutableList<String> = ArrayList()
        if (caseSensitive) {
            o.forEach(Consumer { i: String -> if (i.startsWith(s)) ret.add(i) })
        } else {
            o.forEach(Consumer { i: String -> if (i.toLowerCase().startsWith(s.toLowerCase())) ret.add(i) })
        }
        return ret
    }
}