package com.example.nycschools;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nycschools.features.schoollist.SchoolsListFragment;

/**
 * Main activity. This is light-weight and hosts the first screen as a fragment to have flexibility
 * to change layout per device model. For eg: to show multiple fragments on tablets.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SchoolsListFragment listFragment = new SchoolsListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, listFragment,
                SchoolsListFragment.TAG).commit();
    }
}