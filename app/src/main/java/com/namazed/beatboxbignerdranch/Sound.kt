@file: JvmName("Sound")

package com.namazed.beatboxbignerdranch

class Sound(@JvmField val assetPath: String) {
    @JvmField
    val name: String
    @JvmField
    var soundId: Int = 0

    init {
        val components: List<String> = assetPath.split("/")
        val filename: String = components[components.size - 1]
        name = filename.replace(".wav", "")
    }
}
