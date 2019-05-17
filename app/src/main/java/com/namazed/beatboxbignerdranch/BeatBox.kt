@file: JvmName("BeatBox")

package com.namazed.beatboxbignerdranch

import android.content.Context
import android.content.res.AssetManager
import android.media.AudioManager
import android.media.SoundPool
import androidx.annotation.NonNull
import java.io.IOException

class BeatBox(context: Context) {
    companion object {
        private const val SOUNDS_FOLDER: String = "sample_sounds"
        private const val MAX_SOUNDS: Int = 5
    }

    private var assets: AssetManager = context.assets
    private val sounds: MutableList<Sound>
    private val soundPool: SoundPool

    init {
        soundPool = SoundPoolFactory.createSoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC)
        sounds = ArrayList()
        loadSounds()
    }

    fun play(@NonNull sound: Sound) {
        soundPool.play(sound.getSoundId(), 1.0f, 1.0f, 1, 0, 1.0f)
    }

    @NonNull
    fun getSounds(): List<Sound> {
        return sounds
    }

    fun release() {
        soundPool.release()
    }

    private fun loadSounds() {
        val soundNames = assets.list(SOUNDS_FOLDER)
        soundNames?.forEach {
            val assetPath = SOUNDS_FOLDER + "/" + it
            val sound = Sound(assetPath)
            load(sound)
            sounds.add(sound)
        }
    }

    @Throws(IOException::class)
    private fun load(sound: Sound) {
        val assetFileDescriptor = assets.openFd(sound.getAssetPath())
        val soundId = soundPool.load(assetFileDescriptor, 1)
        sound.setSoundId(soundId)
    }
}