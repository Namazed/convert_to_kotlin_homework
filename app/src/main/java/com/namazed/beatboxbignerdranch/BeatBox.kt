package com.namazed.beatboxbignerdranch

import android.content.Context
import android.content.res.AssetManager
import android.media.AudioManager
import android.media.SoundPool
import android.util.Log

import java.io.IOException
import java.util.ArrayList



class BeatBox (context: Context) {

    private val assets: AssetManager
    private val sounds = ArrayList<Sound>()
    private val soundPool: SoundPool
    init {
        assets = context.assets
        soundPool = SoundPoolFactory.createSoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC)

        loadSounds()
    }

    @JvmName("play")
    fun play(sound: Sound) = soundPool.play(sound.soundId, 1.0f, 1.0f, 1, 0, 1.0f)


    @JvmName("getSounds")
    internal fun getSounds(): List<Sound> = sounds

    @JvmName("release")
    internal fun release() = soundPool.release()

    private fun loadSounds() {
        val soundNames: Array<String>?
        try {
            soundNames = assets.list(SOUNDS_FOLDER)
            Log.i(Companion.TAG, String.format("Found %d sounds", soundNames?.size ?: 0))
        } catch (e: IOException) {
            Log.e(Companion.TAG, "Could not list assets", e)
            return
        }

        if (soundNames == null) {
            Log.i(Companion.TAG, "SoundNames is null")
            return
        }

        for (filename in soundNames) {
            try {
                val assetPath = "$SOUNDS_FOLDER/$filename"
                val sound = Sound(assetPath)
                load(sound)
                sounds.add(sound)
            } catch (e: IOException) {
                Log.e(Companion.TAG, "Could not load sound $filename", e)
            }

        }
    }

    @Throws(IOException::class)
    private fun load(sound: Sound) {
        val assetFileDescriptor = assets.openFd(sound.assetPath)
        val soundId = soundPool.load(assetFileDescriptor, 1)
        sound.soundId = soundId
    }

    companion object {
        private const val TAG: String = "BeatBox"
        private const val SOUNDS_FOLDER: String = "sample_sounds"
        private const val MAX_SOUNDS: Int = 5
    }
}
