@file: JvmName("Sound")

package com.namazed.beatboxbignerdranch

class Sound(val assetPath: String) {
    @JvmField
    val name: String

    @JvmField
    var soundId: Int = 0

    init {
        name = assetPath
            .split("/".toRegex())
            .last()
            .replace(".wav", "")
    }
}
