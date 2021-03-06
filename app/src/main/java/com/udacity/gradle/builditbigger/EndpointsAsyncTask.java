package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.JokesSupply;
import com.example.paul.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {

    private static MyApi myApiService;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {

        if (myApiService == null) {

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://customgradle.appspot.com/_ah/api/");

            myApiService = builder.build();
        }
        try {
            return myApiService.getJoke().execute().getData();

        } catch (IOException e) {
            return e.getMessage();
        }
    }
    @Override
    protected void onPostExecute(String result) {

        EventBus.getDefault().post(new MessageEvent(result));
    }
}




