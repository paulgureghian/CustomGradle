package com.example.jokesdisplaylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.JokesSupply;

public class JokesDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);
    }

    public String getJoke() {

        JokesSupply jokesSupply = new JokesSupply();
        return  jokesSupply.getJoke();
    }
}