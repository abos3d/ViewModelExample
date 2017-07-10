package com.example.musab.viewmodelexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //nothing here just adding the fragments
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentListContainer, ListFragment.newInstance(), ListFragment.TAG).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentDetails, DetailsFragment.newInstance(), DetailsFragment.TAG).commit();

    }
}
