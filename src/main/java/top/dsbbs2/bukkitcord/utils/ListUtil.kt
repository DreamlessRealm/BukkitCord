package top.dsbbs2.bukkitcord.utils

import java.util.*
import java.util.function.Consumer

object ListUtil {
    @SafeVarargs
    fun <T> toList(vararg o: T): ArrayList<T> {
        return object : ArrayList<T>() {
            val serialVersionUID = 8461643752862517970L

            init {
                this.addAll(Arrays.asList(*o))
            }
        }
    }

    fun <T> append(l: List<T>?, vararg o: T): List<T> {
        val temp: MutableList<T> = ArrayList(l)
        for (i in o) temp.add(i)
        return temp
    }

    fun <T> toArray(l: List<T>, clazz: Class<T>?): Array<T> {
        val ret = java.lang.reflect.Array.newInstance(clazz, l.size) as Array<T>
        for (i in l.indices) ret[i] = l[i]
        return ret
    }

    fun toUpperCaseList(l: List<String>): List<String> {
        val ret: MutableList<String> = ArrayList()
        l.forEach(Consumer { i: String -> ret.add(i.toUpperCase()) })
        return ret
    }

    fun toLowerCaseList(l: List<String>): List<String> {
        val ret: MutableList<String> = ArrayList()
        l.forEach(Consumer { i: String -> ret.add(i.toLowerCase()) })
        return ret
    }

    fun <T> hasDuplicatedElement(l: List<T?>): Boolean {
        for (i in l.indices) for (i2 in i + 1 until l.size) {
            if (l[i] == null && l[i2] == null) return true
            if (l[i] == null) continue
            if (l[i2] == null) continue
            if (l[i] == l[i2]) return true
        }
        return false
    }

    fun textListToStringList(l: List<Text>): List<String> {
        val ret: MutableList<String> = ArrayList()
        for (i in l) ret.add(i.getText())
        return ret
    }
}