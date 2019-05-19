package com.namazed.beatboxbignerdranch
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class BeatBoxActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Companion.LAYOUT)

        val manager: FragmentManager = supportFragmentManager
        var fragment: Fragment? = manager.findFragmentById(CONTAINER_FRAGMENT)

        fragment.let {
            manager.beginTransaction().run {
                add(CONTAINER_FRAGMENT, BeatBoxFragment.newInstance())
                commit()
            }
        }
    }
    companion object {

        private const val LAYOUT: Int = R.layout.activity_fragment
        private const val CONTAINER_FRAGMENT: Int = R.id.fragment_container
    }
}
