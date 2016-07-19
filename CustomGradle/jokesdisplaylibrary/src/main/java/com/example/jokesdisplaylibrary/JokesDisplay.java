package com.example.jokesdisplaylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.JokesSupply;

public class JokesDisplay extends AppCompatActivity {

    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);

        display = (TextView) findViewById(R.id.display);

        getIntent().getStringExtra("joke");

        JokesSupply jokesSupply = new JokesSupply();
    }
    public String getJoke() {

        JokesSupply jokesSupply = new JokesSupply();
        return jokesSupply.getJoke();
    }
}