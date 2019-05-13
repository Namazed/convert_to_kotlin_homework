package com.namazed.beatboxbignerdranch.adapter;

import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import com.namazed.beatboxbignerdranch.BeatBox;
import com.namazed.beatboxbignerdranch.R;
import com.namazed.beatboxbignerdranch.Sound;

public class SoundHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final BeatBox beatBox;
    private Button soundButton;
    private Sound sound;

    SoundHolder(View itemView, BeatBox beatBox) {
        super(itemView);
        this.beatBox = beatBox;
        soundButton = itemView.findViewById(R.id.list_item_sound_button);
        soundButton.setOnClickListener(this);
    }

    void bindSound(Sound sound) {
        this.sound = sound;
        soundButton.setText(this.sound.getName());
    }

    @Override
    public void onClick(View view) {
        beatBox.play(sound);
    }
}
