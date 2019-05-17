@file: JvmName("BeatBoxFragment")

package com.namazed.beatboxbignerdranch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.namazed.beatboxbignerdranch.adapter.SoundAdapter
import kotlinx.android.synthetic.main.fragment_beat_box.view.*

class BeatBoxFragment : Fragment() {

    private var beatBox: BeatBox? = null

    companion object {
        @NonNull
        @JvmStatic
        fun newInstance(): BeatBoxFragment {
            return BeatBoxFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beatBox = BeatBox(activity!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_beat_box, container, false)
        val recyclerView: RecyclerView = view.fragment_beat_box_recycler_view as RecyclerView
        recyclerView.layoutManager = GridLayoutManager(activity, 3)
        recyclerView.adapter = SoundAdapter(beatBox!!.getSounds(), beatBox)
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        beatBox?.release()
    }
}
