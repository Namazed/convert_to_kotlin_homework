@file:JvmName("Sound")
package com.namazed.beatboxbignerdranch

class Sound (val assetPath: String) {
    val name: String
    var soundId: Int = 0

    init {
        val components = assetPath.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val filename = components[components.size - 1]
        name = filename.replace(".wav", "")
    }
}
