package com.example.madsm.vemmelevboldklub;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;

import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madsm.vemmelevboldklub.mMySQL.Downloader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.ArrayList;

import static android.R.attr.id;
import static android.R.attr.onClick;

public class StatisticActivity extends AppCompatActivity {

    private GridView gv;
    private ArrayList<String> players;
    private JSONArray result;

    TextView name, goals, assists, yellowCards, redCards;

    final static String urlAddress = "http://adellund.dk/text.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

        final GridView gv = (GridView) findViewById(R.id.gridLayout);

        new Downloader(StatisticActivity.this,urlAddress,gv).execute();
    }
      /*  String result = null;
        InputStream is = null;
        try{
            /*HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://adellund.dk/text.php");
            HttpResponse respone = httpclient.execute(httppost);
            HttpEntity entity = respone.getEntity();
            is = entity.getContent();

            Log.e("log_tag", "connection_succes");
        } catch (Exception e){
            Log.e("log_tag", "Error in http connection" + e.toString());
            Toast.makeText(getApplicationContext(),"Connection fail", Toast.LENGTH_SHORT).show();
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line = reader.readLine()) != null){
                sb.append(line + "\n");
            }
            is.close();

            result = sb.toString();
        }catch (Exception e){
            Log.e("log_tag", "Error converting result" + e.toString());
            Toast.makeText(getApplicationContext(),"Input reading fail", Toast.LENGTH_SHORT).show();
        }*/

}
