@file: JvmName("MyBeatBox")

package com.namazed.beatboxbignerdranch

import android.content.Context
import android.content.res.AssetManager
import android.media.AudioManager
import android.media.SoundPool

import java.io.IOException
import java.util.ArrayList

private const val SOUNDS_FOLDER = "sample_sounds"
private const val MAX_SOUNDS = 5

class BeatBox(context: Context, private val assets: AssetManager = context.assets) {

    val sounds: ArrayList<Sound>
    private val soundPool: SoundPool

    init {
        sounds = ArrayList()
        soundPool = SoundPoolFactory.createSoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC)
        loadSounds()
    }

    fun play(sound: Sound) =
        soundPool.play(sound.soundId, 1.0f, 1.0f, 1, 0, 1.0f)

    fun release() = soundPool.release()

    private fun loadSounds() {
        val soundNames: Array<String> = assets.list(SOUNDS_FOLDER)
        soundNames?.forEach {
            val assetPath = "$SOUNDS_FOLDER/$it"
            val sound = Sound(assetPath)
            load(sound)
            sounds.add(sound)
        }
    }

    @Throws(IOException::class)
    private fun load(sound: Sound) {
        val assetFileDescriptor = assets.openFd(sound.assetPath)
        val soundId = soundPool.load(assetFileDescriptor, 1)
        sound.soundId = soundId
    }

}
