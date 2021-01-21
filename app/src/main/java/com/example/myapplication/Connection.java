package com.example.myapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Connection {
    public  static String getUserJson(String url) {
        String jsonStr = "";
        try {
            URL u = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(15000);
            conn.setReadTimeout(15000);
            conn.connect();

            InputStream stream;

            if ((conn.getResponseCode() == HttpURLConnection.HTTP_OK)) {
                stream = conn.getInputStream();
            }else{
                stream = conn.getErrorStream();
            }


            jsonStr = inputStreamToString(stream);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonStr;
    }

    public static String inputStreamToString(InputStream stream)
    {
        StringBuffer buffer = new StringBuffer();
        try{
            String linha;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
            while((linha = bufferedReader.readLine()) != null){
                buffer.append(linha);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
