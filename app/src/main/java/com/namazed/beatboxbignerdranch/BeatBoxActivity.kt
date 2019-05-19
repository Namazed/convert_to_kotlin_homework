@file: JvmName("BeatBoxActivity")

package com.namazed.beatboxbignerdranch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


private const val CONTAINER_FRAGMENT:Int = R.id.fragment_container
private const val LAYOUT :Int = R.layout.activity_fragment

class BeatBoxActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LAYOUT)

        val manager : FragmentManager = supportFragmentManager
        var fragment: Fragment? = manager.findFragmentById(CONTAINER_FRAGMENT)

        fragment?: manager.beginTransaction().run {
            fragment = BeatBoxFragment.newInstance()
            add(CONTAINER_FRAGMENT, BeatBoxFragment.newInstance())
            commit()
        }
    }
}
