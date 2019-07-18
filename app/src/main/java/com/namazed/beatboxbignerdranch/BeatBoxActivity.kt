@file: JvmName("TheBeatBoxActivity")

package com.namazed.beatboxbignerdranch

import android.app.FragmentManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

private const val LAYOUT: Int = R.layout.activity_fragment
private const val CONTAINER_FRAGMENT: Int = R.id.fragment_container

class BeatBoxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LAYOUT)

        val manager: FragmentManager = fragmentManager
        manager.findFragmentById(CONTAINER_FRAGMENT) ?: manager.beginTransaction().run {
            add(CONTAINER_FRAGMENT, BeatBoxFragment.newInstance())
            commit()
        }
    }
}
