package com.example.madsm.vemmelevboldklub;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class HttpURLConnectionHandler {

    protected String urlG = "http://adellund.dk/@mads/";
    public String sendText(String text){
        try {
            URL url = new URL(urlG + "text.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            DataOutputStream wr = new DataOutputStream(
                    conn.getOutputStream());
            wr.writeBytes(text);
            wr.flush();
            wr.close();
            InputStream is = conn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        }
            catch(Exception e){return "error";}
    }
}
