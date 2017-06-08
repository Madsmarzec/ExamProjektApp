package com.example.madsm.vemmelevboldklub.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by Mads on 08-06-2017.
 */

public class Downloader extends AsyncTask<Void, Void, String>{
    Context c;
    String urlAddress;
    GridView gv;

    ProgressDialog pd;

    public Downloader(Context c, String urlAddress, GridView gv) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.gv = gv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(c);
        pd.setTitle("Fetch");
        pd.setMessage("Fetching data...");
        pd.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        return this.downloadData();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        pd.dismiss();
        if (s == null){
            Toast.makeText(c,"Unsuccesful, Null returned",Toast.LENGTH_SHORT).show();
        }else{
            //CAll Data Parser to parse
            DataParser parser = new DataParser(c, gv, s);
            parser.execute();
        }
    }

    private String downloadData(){
        HttpURLConnection con = Connector.connect(urlAddress);
        if (con == null){
            return null;
        }
        InputStream is = null;
        try {
            is = new BufferedInputStream(con.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line = null;
            StringBuffer response = new StringBuffer();

            if (br != null){
                while ((line = br.readLine()) != null){
                    response.append(line + "\n");
                }
                br.close();
            }else{
                return null;
            }
            return response.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
