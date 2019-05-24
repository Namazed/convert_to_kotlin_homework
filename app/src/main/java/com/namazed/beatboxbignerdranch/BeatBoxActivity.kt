@file: JvmName("BeatBoxActivityKt")

package com.namazed.beatboxbignerdranch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

private const val LAYOUT = R.layout.activity_fragment
private const val CONTAINER_FRAGMENT = R.id.fragment_container

class BeatBoxActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState?: Bundle())
        setContentView(LAYOUT)

        val manager: FragmentManager = supportFragmentManager
        var fragment: Fragment? = manager.findFragmentById(CONTAINER_FRAGMENT)

        fragment ?: run {
            fragment = BeatBoxFragment.newInstance()
            manager.beginTransaction().add(
                CONTAINER_FRAGMENT,
                fragment as BeatBoxFragment).commit()
        }
    }
}
