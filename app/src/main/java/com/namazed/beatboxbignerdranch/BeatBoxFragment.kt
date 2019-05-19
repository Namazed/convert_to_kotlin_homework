@file: JvmName("BeatBoxFragment")

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
    private val beatBox: BeatBox by lazy(LazyThreadSafetyMode.NONE) {
        BeatBox(activity!!)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_beat_box, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.fragment_beat_box_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(activity, 3)
        recyclerView.adapter = SoundAdapter(beatBox.getSounds(), beatBox)
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        beatBox.release()
    }

    companion object {
        @JvmStatic
        fun newInstance(): BeatBoxFragment {
            return BeatBoxFragment()
        }
    }
}
