@file: JvmName("SoundHolder")

package com.namazed.beatboxbignerdranch.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.namazed.beatboxbignerdranch.BeatBox
import com.namazed.beatboxbignerdranch.Sound
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_sound.*

class SoundHolder(override val containerView: View, private val beatBox: BeatBox) :
    RecyclerView.ViewHolder(containerView), View.OnClickListener, LayoutContainer {

    private var sound: Sound? = null

    init {
        list_item_sound_button.setOnClickListener(this)
    }

    fun bindSound(sound: Sound) {
        this.sound = sound
        list_item_sound_button.text = this.sound?.name
    }

    override fun onClick(view: View) {
        sound?.let {
            beatBox.play(it)
        }
    }
}
