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
                    .setRootUrl("http://10.0.0.3:8080/_ah/api")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }
//        context = params[0];

        try {
            return myApiService.getJoke().execute().getData();

        } catch (IOException e) {
            return e.getMessage();
        }
    }
    @Override
    protected void onPostExecute(String result) {
    //    Toast.makeText(context, result, Toast.LENGTH_LONG).show();

        EventBus.getDefault().post(new MessageEvent(result));
    }
}




