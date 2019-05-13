package com.namazed.beatboxbignerdranch.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.namazed.beatboxbignerdranch.BeatBox;
import com.namazed.beatboxbignerdranch.R;
import com.namazed.beatboxbignerdranch.Sound;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class SoundAdapter extends RecyclerView.Adapter<SoundHolder> {

    private final BeatBox beatBox;
    private List<Sound> sounds;

    public SoundAdapter(List<Sound> sounds, BeatBox beatBox) {
        this.sounds = sounds;
        this.beatBox = beatBox;
    }

    @NotNull
    @Override
    public SoundHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_sound, parent, false);

        return new SoundHolder(view, beatBox);
    }

    @Override
    public void onBindViewHolder(@NotNull SoundHolder holder, int position) {
        Sound sound = sounds.get(position);
        holder.bindSound(sound);
    }

    @Override
    public int getItemCount() {
        return sounds.size();
    }

}
