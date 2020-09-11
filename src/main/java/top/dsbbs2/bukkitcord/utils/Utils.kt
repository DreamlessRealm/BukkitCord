package top.dsbbs2.bukkitcord.utils

object Utils {
    fun isInRange(check: Int, var1: Int, var2: Int): Boolean {
        return when {
            var1 == var2 -> {
                check == var1
            }
            var1 > var2 -> {
                check in var2..var1
            }
            else -> {
                check in var1..var2
            }
        }
    }
}