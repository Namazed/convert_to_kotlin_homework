package com.namazed.beatboxbignerdranch;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import androidx.annotation.RequiresApi;

class SoundPoolFactory {

    private SoundPoolFactory() {
    }

    static SoundPool createSoundPool(int maxStreams, int streamType) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return createSoundPoolForApi21(maxStreams, streamType);
        } else {
            return createSoundPoolForApiBelow21(maxStreams, streamType);
        }
    }

    private static SoundPool createSoundPoolForApiBelow21(int maxStreams, int streamType) {
        return new SoundPool(maxStreams, streamType, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private static SoundPool createSoundPoolForApi21(int maxStreams, int streamType) {
        SoundPool.Builder builder = new SoundPool.Builder();
        AudioAttributes attributes = new AudioAttributes.Builder().setLegacyStreamType(streamType).build();
        return builder.setMaxStreams(maxStreams)
                .setAudioAttributes(attributes)
                .build();
    }
}
