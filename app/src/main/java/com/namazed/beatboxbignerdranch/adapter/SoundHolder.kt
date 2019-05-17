@file: JvmName("SoundHolder")

package com.namazed.beatboxbignerdranch.adapter

import android.view.View
import android.widget.Button
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import com.namazed.beatboxbignerdranch.BeatBox
import com.namazed.beatboxbignerdranch.Sound
import com.namazed.beatboxbignerdranch.R

class SoundHolder constructor(itemView: View, private val beatBox: BeatBox) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private val soundButton: Button = itemView.findViewById(R.id.list_item_sound_button)
    @Nullable
    private var sound: Sound? = null

    init {
        soundButton.setOnClickListener(this)
    }

    fun bindSound(@NonNull sound: Sound) {
        this.sound = sound
        soundButton.text = this.sound?.getName()
    }

    override fun onClick(view: View) {
        if (sound != null) {
            beatBox.play(sound!!)
        }
    }
}
