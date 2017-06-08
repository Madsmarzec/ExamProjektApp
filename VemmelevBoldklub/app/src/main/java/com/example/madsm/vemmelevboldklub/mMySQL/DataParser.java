package com.example.madsm.vemmelevboldklub.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Mads on 08-06-2017.
 */

public class DataParser extends AsyncTask<Void, Void, Integer> {

    Context c;
    GridView gv;
    String jsonData;

    ProgressDialog pd;
    ArrayList<String> spacecrafts = new ArrayList<>();

    public DataParser(Context c, GridView gv, String jsonData) {
        this.c = c;
        this.gv = gv;
        this.jsonData = jsonData;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing data...");
        pd.show();
    }


    @Override
    protected Integer doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        pd.dismiss();

        if (result == 0){
            Toast.makeText(c, "Unable to parse", Toast.LENGTH_SHORT).show();
        } else {
            ArrayAdapter adapter = new ArrayAdapter(c, android.R.layout.simple_list_item_1, spacecrafts);
            gv.setAdapter(adapter);
            gv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(c,spacecrafts.get(position), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    private int parseData(){
        try {
            JSONArray ja = new JSONArray(jsonData);
            JSONObject jo = null;
            spacecrafts.clear();

            for (int i = 0; 1< ja.length(); i++){
                jo = ja.getJSONObject(i);
                String name =jo.getString("name");
                spacecrafts.add(name);
            }
            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }


}
