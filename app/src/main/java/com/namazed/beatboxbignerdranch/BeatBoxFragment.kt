@file: JvmName("BeatBoxFragment")

package com.namazed.beatboxbignerdranch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.namazed.beatboxbignerdranch.adapter.SoundAdapter

class BeatBoxFragment : Fragment() {
    private val beatBox: BeatBox by lazy(LazyThreadSafetyMode.NONE) {
        BeatBox(activity!!)
    }

    companion object {
        @JvmStatic
        fun newInstance(): BeatBoxFragment {
            return BeatBoxFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_beat_box, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.fragment_beat_box_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this.activity, 3)
        recyclerView.adapter = SoundAdapter(beatBox.sounds, beatBox)

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        beatBox.release()
    }
}
