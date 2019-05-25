@file: JvmName("MyBeatBox")

package com.namazed.beatboxbignerdranch

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.AudioManager
import android.media.SoundPool
import android.util.Log
import java.io.IOException

private const val TAG: String = "BeatBox"
private const val SOUNDS_FOLDER: String = "sample_sounds"
private const val MAX_SOUNDS: Int = 5

class BeatBox(
    context: Context,
    private val assets: AssetManager = context.assets,
    private val soundPool: SoundPool = SoundPoolFactory.createSoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC)
) {
    @JvmField
    val sounds = ArrayList<Sound>()

    init {
        loadSounds()
    }

    fun play(sound: Sound) {
        val soundId: Int = sound.soundId
        soundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f)
    }

    fun release() {
        soundPool.release()
    }

    private fun loadSounds() {
        val soundNames: Array<String>?
        try {
            soundNames = assets.list(SOUNDS_FOLDER)
            Log.i(TAG, String.format("Found %d sounds", soundNames?.size ?: 0))
        } catch (e: IOException) {
            Log.e(TAG, "Could not list assets", e)
            return
        }

        soundNames?.forEach {
            try {
                val assetPath = "$SOUNDS_FOLDER/$it"
                val sound = Sound(assetPath)
                load(sound)
                sounds.add(sound)
            } catch (e: IOException) {
                Log.e(TAG, "Could not load sound $it", e)
            }
        } ?: Log.i(TAG, "SoundNames is null")
    }

    @Throws(IOException::class)
    private fun load(sound: Sound) {
        val assetFileDescriptor: AssetFileDescriptor = assets.openFd(sound.assetPath)
        val soundId: Int = soundPool.load(assetFileDescriptor, 1)
        sound.soundId = soundId
    }
}
