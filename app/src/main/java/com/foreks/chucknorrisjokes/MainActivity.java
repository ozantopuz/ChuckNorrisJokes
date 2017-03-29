package com.foreks.chucknorrisjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.foreks.chucknorrisjokes.fragments.DetailFragment;
import com.foreks.chucknorrisjokes.fragments.ListFragment;

public class MainActivity extends AppCompatActivity {

    private final int FRAME = R.id.activity_main_frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showListFragment();
    }

    public void showListFragment() {
        getSupportFragmentManager().beginTransaction().replace(FRAME, ListFragment.newInstance(this)).commit();
    }

    public void showDetailFragment() {
        getSupportFragmentManager().beginTransaction().replace(FRAME, DetailFragment.newInstance(this)).commit();
    }
}
