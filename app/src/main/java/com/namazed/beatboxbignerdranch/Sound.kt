@file: JvmName("Sound")

package com.namazed.beatboxbignerdranch

class Sound(@JvmField val assetPath: String) {
    @JvmField
    val name: String
    @JvmField
    var soundId: Int = 0

    init {
        val components = assetPath.split("/".toRegex())
        val filename = components[components.size - 1]
        name = filename.replace(".wav", "")
    }
}