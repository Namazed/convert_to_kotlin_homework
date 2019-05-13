package com.namazed.beatboxbignerdranch;

public class Sound {
    private String assetPath;
    private String name;
    private int soundId;

    Sound(String assetPath) {
        this.assetPath = assetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length - 1];
        name = filename.replace(".wav", "");
    }

    String getAssetPath() {
        return assetPath;
    }

    public String getName() {
        return name;
    }

    int getSoundId() {
        return soundId;
    }

    void setSoundId(int soundId) {
        this.soundId = soundId;
    }
}
