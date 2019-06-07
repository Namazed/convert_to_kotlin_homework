@file: JvmName("BeatBoxFragmentFile")
package com.namazed.beatboxbignerdranch

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.namazed.beatboxbignerdranch.adapter.SoundAdapter

class BeatBoxFragment : Fragment() {

    @JvmField
    var beatBox: BeatBox? = null

    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        beatBox = BeatBox(activity!!)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val beatBoxVal: BeatBox? = beatBox
        val view = inflater.inflate(BEAT_BOX_FRAGMET, container, false)
        val recyclerView = view.findViewById<RecyclerView>(RECYCLER_FRAGMENT)
        recyclerView.layoutManager = GridLayoutManager(activity, 3)
        recyclerView.adapter = SoundAdapter(beatBoxVal!!.sounds, beatBoxVal)
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        beatBox!!.release()
    }

    companion object {

        private val RECYCLER_FRAGMENT = R.id.fragment_beat_box_recycler_view
        private val BEAT_BOX_FRAGMET = R.layout.fragment_beat_box

        @JvmStatic
        fun newInstance(): BeatBoxFragment {
            return BeatBoxFragment()
        }
    }
}