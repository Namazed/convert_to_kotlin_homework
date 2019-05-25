@file:JvmName("BeatBoxActivity")

package com.namazed.beatboxbignerdranch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class BeatBoxActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LAYOUT)

        val manager = fragmentManager
        var fragment = manager.findFragmentById(CONTAINER_FRAGMENT)

        fragment ?: manager.beginTransaction().add(
            CONTAINER_FRAGMENT,
            BeatBoxFragment.newInstance()
        ).commit()
    }

    companion object {
        private const val LAYOUT = R.layout.activity_fragment
        private const val CONTAINER_FRAGMENT = R.id.fragment_container
    }
}