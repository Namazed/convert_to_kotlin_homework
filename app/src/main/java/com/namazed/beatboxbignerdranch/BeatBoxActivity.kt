package com.namazed.beatboxbignerdranch

import android.app.Fragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

private const val LAYOUT = R.layout.activity_fragment
private const val CONTAINER_FRAGMENT = R.id.fragment_container

class BeatBoxActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LAYOUT)

        val manager = fragmentManager
        val fragment: Fragment? = manager.findFragmentById(CONTAINER_FRAGMENT)

        fragment ?: manager.beginTransaction()
            .add(CONTAINER_FRAGMENT, BeatBoxFragment.newInstance())
            .commit()
    }
}
