package com.namazed.beatboxbignerdranch;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class BeatBoxActivity extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_fragment;
    private static final int CONTAINER_FRAGMENT = R.id.fragment_container;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        FragmentManager manager = getFragmentManager();
        Fragment fragment = manager.findFragmentById(CONTAINER_FRAGMENT);

        if (fragment == null) {
            fragment = BeatBoxFragment.newInstance();
            manager.beginTransaction().add(CONTAINER_FRAGMENT, fragment).commit();
        }
    }
}
