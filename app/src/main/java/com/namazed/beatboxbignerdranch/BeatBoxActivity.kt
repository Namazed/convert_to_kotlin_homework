@file: JvmName("MyBeatBoxActivity")

package com.namazed.beatboxbignerdranch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

private const val LAYOUT = R.layout.activity_fragment
private const val CONTAINER_FRAGMENT = R.id.fragment_container

class BeatBoxActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LAYOUT)

        val manager = supportFragmentManager
        val fragment = manager.findFragmentById(CONTAINER_FRAGMENT)

        fragment ?: manager.beginTransaction().run {
            add(CONTAINER_FRAGMENT, BeatBoxFragment.newInstance())
            commit()
        }
    }
}
