@file: JvmName("SoundPoolFactoryFile")

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
    private fun createSoundPoolForApiBelow21(maxStreams: Int, streamType: Int): SoundPool =
        SoundPool(maxStreams, streamType, 0)

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @JvmStatic
    private fun createSoundPoolForApi21(maxStreams: Int, streamType: Int): SoundPool {
        val attributes = AudioAttributes.Builder()
            .setLegacyStreamType(streamType)
            .build()
        return SoundPool.Builder()
            .setMaxStreams(maxStreams)
            .setAudioAttributes(attributes)
            .build()
    }
}
