package com.example.nycschools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.nycschools.features.schoollist.SchoolsListFragment;

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