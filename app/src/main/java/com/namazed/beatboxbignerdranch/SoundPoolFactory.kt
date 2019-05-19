@file: JvmName("SoundPoolFactory")

package com.namazed.beatboxbignerdranch

import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Build
import androidx.annotation.RequiresApi

object SoundPoolFactory {
    @JvmStatic
    fun createSoundPool(maxStreams: Int, streamType: Int): SoundPool =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            createSoundPoolForApi21(maxStreams, streamType)
        } else {
            createSoundPoolForApiBelow21(maxStreams, streamType)
        }


    @JvmStatic
    private fun createSoundPoolForApiBelow21(maxStreams: Int, streamType: Int): SoundPool {
        return SoundPool(maxStreams, streamType, 0)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @JvmStatic
    private fun createSoundPoolForApi21(maxStreams: Int, streamType: Int): SoundPool {
        val builder: SoundPool.Builder = SoundPool.Builder()
        val attributes: AudioAttributes = AudioAttributes.Builder().run {
            setLegacyStreamType(streamType)
            build()
        }

        return builder.run {
            setMaxStreams(maxStreams)
            setAudioAttributes(attributes)
            build()
        }
    }
}