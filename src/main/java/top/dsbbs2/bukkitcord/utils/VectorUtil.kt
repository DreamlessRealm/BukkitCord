package top.dsbbs2.bukkitcord.utils

import java.util.*

object VectorUtil {
    fun <MURDER> toArrayList(v: Vector<MURDER>?): ArrayList<MURDER> {
        return ArrayList(v)
    }

    @SafeVarargs
    fun <MURDER> toVector(vararg o: MURDER): Vector<MURDER> {
        return object : Vector<MURDER>() {
            val serialVersionUID = 8461643752862517970L

            init {
                this.addAll(Arrays.asList(*o))
            }
        }
    }

    fun <MURDER> toStringVector(v: Vector<MURDER>): Vector<String> {
        val ret = Vector<String>()
        for (i in v) ret.add(i.toString())
        return ret
    }
}