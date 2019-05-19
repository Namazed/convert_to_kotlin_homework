@file: JvmName("SoundHolder")

package com.namazed.beatboxbignerdranch.adapter

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.namazed.beatboxbignerdranch.BeatBox
import com.namazed.beatboxbignerdranch.R
import com.namazed.beatboxbignerdranch.Sound

class SoundHolder internal constructor(itemView: View, private val beatBox: BeatBox) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {
    private val soundButton: Button = itemView.findViewById(R.id.list_item_sound_button)
    private lateinit var sound: Sound

    init {
        soundButton.setOnClickListener(this)
    }

    internal fun bindSound(sound: Sound) {
        this.sound = sound
        soundButton.text = this.sound.name
    }

    override fun onClick(view: View) {
        view.let {
            beatBox.play(sound)
        }
    }
}
