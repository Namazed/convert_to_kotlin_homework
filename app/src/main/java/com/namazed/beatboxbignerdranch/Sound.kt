@file:JvmName("Sound")

package com.namazed.beatboxbignerdranch

import androidx.annotation.NonNull

class Sound(@NonNull private val assetPath: String) {

    private val name: String
    private var soundId: Int = 0

    init {
        val components = assetPath.split("/")
        val filename = components[components.size - 1]
        name = filename.replace(".wav", "")
    }

    @NonNull
    fun getAssetPath(): String {
        return assetPath
    }

    @NonNull
    fun getName(): String {
        return name
    }

    @NonNull
    fun getSoundId(): Int {
        return soundId
    }

    fun setSoundId(soundId: Int) {
        this.soundId = soundId
    }
}

