@file: JvmName("BeatBoxActivity")

package com.namazed.beatboxbignerdranch

import android.app.Fragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BeatBoxActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LAYOUT)

        val manager = fragmentManager
        var fragment: Fragment? = manager.findFragmentById(CONTAINER_FRAGMENT)

        fragment ?: manager.beginTransaction().run {
            fragment = BeatBoxFragment.newInstance()
            add(CONTAINER_FRAGMENT, fragment)
            commit()
        }
    }

    companion object {

        private const val LAYOUT = R.layout.activity_fragment
        private const val CONTAINER_FRAGMENT = R.id.fragment_container
    }
}
