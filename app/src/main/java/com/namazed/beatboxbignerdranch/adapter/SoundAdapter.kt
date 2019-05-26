@file: JvmName("SoundAdapter")

package com.namazed.beatboxbignerdranch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.namazed.beatboxbignerdranch.BeatBox
import com.namazed.beatboxbignerdranch.R
import com.namazed.beatboxbignerdranch.Sound

class SoundAdapter(private val sounds: List<Sound>, private val beatBox: BeatBox) :
    RecyclerView.Adapter<SoundHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_sound, parent, false)

        return SoundHolder(view, beatBox)
    }

    override fun onBindViewHolder(holder: SoundHolder, position: Int) {
        val sound: Sound = sounds[position]
        holder.bindSound(sound)
    }

    override fun getItemCount(): Int = sounds.size
}