package com.example.madsm.vemmelevboldklub;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.loopj.android.http.RequestParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LeagueTableActivity extends AppCompatActivity {

    String JSON_String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_table);
    }
    public void getJSON(View view){
        new BackgroundTask().execute();
    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {

        String json_url;
        @Override
        protected void onPreExecute() {
            json_url = "https://clubservice.dbu.dk/api/TeamPoolPosition?APIKey=f04fc75e-e803-47a1-bc6a-b9021d9b44e3&PoolId=235935&TeamId=197578";
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_String = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_String + "\n");

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView = (TextView) findViewById(R.id.txtLeaView);
            textView.setText(result);
        }
    }
}
