@file: JvmName("SoundAdapter")
package com.namazed.beatboxbignerdranch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.namazed.beatboxbignerdranch.BeatBox
import com.namazed.beatboxbignerdranch.R
import com.namazed.beatboxbignerdranch.Sound


class SoundAdapter(private val sounds: List<Sound>, private val beatBox: BeatBox) :
    RecyclerView.Adapter<SoundHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(LAYOUT, parent, false)

        return SoundHolder(view, beatBox)
    }

    override fun onBindViewHolder(holder: SoundHolder, position: Int) {
        val sound = sounds[position]
        holder.bindSound(sound)
    }

    override fun getItemCount(): Int {
        return sounds.size
    }


    companion object {

        private val LAYOUT = R.layout.list_item_sound
    }
}