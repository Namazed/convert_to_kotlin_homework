@file: JvmName("Sound")

package com.namazed.beatboxbignerdranch

class Sound internal constructor(internal val assetPath: String) {
    @JvmField
    val name: String
    @JvmField
    internal var soundId: Int = 0

    init {
        val components = assetPath.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val filename = components[components.size - 1]
        name = filename.replace(".wav", "")
    }
}
