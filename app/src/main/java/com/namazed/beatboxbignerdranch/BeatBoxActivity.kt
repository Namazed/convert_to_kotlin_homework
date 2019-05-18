
package com.namazed.beatboxbignerdranch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fragment.*

class BeatBoxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        fragment_container.let {
            supportFragmentManager.beginTransaction().run {
                add(R.id.fragment_container, BeatBoxFragment.newInstance())
                commit()
            }
        }
    }
}
