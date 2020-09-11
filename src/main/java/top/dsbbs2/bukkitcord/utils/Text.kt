package top.dsbbs2.bukkitcord.utils

import java.util.*

class Text : Comparable<Any?> {
    @Volatile
    private var text: String?

    constructor() {
        text = ""
    }

    constructor(t: String?) {
        var t = t
        if (t == null) t = ""
        text = t.toLowerCase(Locale.ENGLISH)
    }

    fun setText(t: String?) {
        var t = t
        if (t == null) t = ""
        text = t.toLowerCase(Locale.ENGLISH)
    }

    fun getText(): String {
        if (text == null) text = ""
        return text!!.toLowerCase(Locale.ENGLISH)
    }

    override fun toString(): String {
        return getText()
    }

    override fun equals(o: Any?): Boolean {
        return when (o) {
            is Text -> o.getText().equals(getText(), ignoreCase = true)
            is String -> o.equals(getText(), ignoreCase = true)
            else -> (o as? StringBuilder)?.toString()?.equals(getText(), ignoreCase = true)
                    ?: (o?.toString()?.equals(getText(), ignoreCase = true) ?: false)
        }
    }

    override fun compareTo(o: Any?): Int {
        return when (o) {
            is Text -> o.getText().compareTo(getText(), ignoreCase = true)
            is String -> o.compareTo(getText(), ignoreCase = true)
            else -> (o as? StringBuilder)?.toString()?.compareTo(getText(), ignoreCase = true)
                    ?: (o?.toString()?.compareTo(getText(), ignoreCase = true) ?: 0)
        }
    }
}