@file: JvmName("Sound")

package com.namazed.beatboxbignerdranch

class Sound(val assetPath: String) {
    @JvmField
    val name: String = assetPath
        .split("/".toRegex())
        .last()
        .replace(".wav", "")

    @JvmField
    var soundId: Int = 0
}
