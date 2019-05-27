@file: JvmName("SoundPoolFactory")
@file:Suppress("DEPRECATION")

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

    @JvmStatic
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private fun createSoundPoolForApi21(maxStreams: Int, streamType: Int): SoundPool {
        val builder = SoundPool.Builder()
        val attributes = AudioAttributes.Builder().setLegacyStreamType(streamType).build()
        return builder.setMaxStreams(maxStreams)
            .setAudioAttributes(attributes)
            .build()
    }
}