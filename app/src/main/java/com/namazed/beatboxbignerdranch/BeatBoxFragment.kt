@file: JvmName("BeatBoxFragmentFile")

package com.namazed.beatboxbignerdranch

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.namazed.beatboxbignerdranch.adapter.SoundAdapter
import kotlinx.android.synthetic.main.fragment_beat_box.*


class BeatBoxFragment : Fragment() {
    private val beatBox: BeatBox by lazy(LazyThreadSafetyMode.NONE) {
        BeatBox(activity!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_beat_box_recycler_view.apply {
            layoutManager = GridLayoutManager(activity, 3)
            adapter = SoundAdapter(beatBox.sounds, beatBox)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_beat_box, container, false)

    override fun onDestroy() {
        super.onDestroy()
        beatBox.release()
    }

    companion object {
        @JvmStatic
        fun newInstance(): BeatBoxFragment = BeatBoxFragment()
    }
}