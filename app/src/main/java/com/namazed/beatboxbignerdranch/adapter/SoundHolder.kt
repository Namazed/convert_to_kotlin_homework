@file: JvmName("SoundHolder")
package com.namazed.beatboxbignerdranch.adapter

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.namazed.beatboxbignerdranch.BeatBox
import com.namazed.beatboxbignerdranch.Sound
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_sound.*

class SoundHolder(itemView: View, private val beatBox: BeatBox) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener, LayoutContainer {
    override val containerView: View?
        get() = itemView
    private val soundButton: Button = list_item_sound_button
    private var sound: Sound? = null

    init {
        soundButton.setOnClickListener(this)
    }

    internal fun bindSound(sound: Sound) {
        this.sound = sound
        soundButton.text = this.sound!!.name
    }

    override fun onClick(view: View) {
        sound?.let{
            beatBox.play(sound!!)
        }
    }
}
