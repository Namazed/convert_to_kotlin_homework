@file: JvmName("SoundPoolFactory")
package com.namazed.beatboxbignerdranch

import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Build
import androidx.annotation.RequiresApi

internal object SoundPoolFactory {

    @JvmStatic
    fun createSoundPool(maxStreams: Int, streamType: Int): SoundPool {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            createSoundPoolForApi21(maxStreams, streamType)
        } else {
            createSoundPoolForApiBelow21(maxStreams, streamType)
        }
    }

    @JvmStatic
    private fun createSoundPoolForApiBelow21(maxStreams: Int, streamType: Int): SoundPool {
        return SoundPool(maxStreams, streamType, 0)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @JvmStatic
    private fun createSoundPoolForApi21(maxStreams: Int, streamType: Int): SoundPool {
        val builder = SoundPool.Builder()
        val attributes = AudioAttributes.Builder().setLegacyStreamType(streamType).build()
        return builder.setMaxStreams(maxStreams)
            .setAudioAttributes(attributes)
            .build()
    }
}
