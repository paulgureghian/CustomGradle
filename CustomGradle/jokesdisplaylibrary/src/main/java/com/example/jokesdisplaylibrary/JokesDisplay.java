package com.example.jokesdisplaylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.JokesSupply;

public class JokesDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);

        JokesSupply jokesSupply = new JokesSupply();

    //    textView.setText(jokesSupply.getJoke());
        TextView textView = (TextView) findViewById(R.id.display);
    }

    public String getJoke() {

        JokesSupply jokesSupply = new JokesSupply();
        return  jokesSupply.getJoke();
    }
}