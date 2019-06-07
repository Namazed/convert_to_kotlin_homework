@file: JvmName("BeatBoxActivity")
package com.namazed.beatboxbignerdranch

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BeatBoxActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LAYOUT)

        val manager: FragmentManager = supportFragmentManager
        var fragment: Fragment? = manager.findFragmentById(CONTAINER_FRAGMENT)

        if (fragment == null) {
            fragment = BeatBoxFragment.newInstance()
            manager.beginTransaction().add(CONTAINER_FRAGMENT, fragment).commit()
        }
    }

    companion object {

        private val LAYOUT = R.layout.activity_fragment
        private val CONTAINER_FRAGMENT = R.id.fragment_container
    }
}
