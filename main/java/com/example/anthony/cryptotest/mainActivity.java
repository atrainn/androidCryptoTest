package com.example.anthony.cryptotest;

import android.app.Activity;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

import java.net.*;
import java.io.*;





public class mainActivity extends Activity {

    String dogeURL = "https://block.io/api/v1/get_current_price/?api_key=8467-e6b6-f79b-e1ba&price_base=USD";
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView dogeValue = (TextView) findViewById(R.id.dogeVal);

        try {
            dogeValue.setText(currentVal());
        } catch (Exception e) {
            dogeValue.setText(e.getMessage());
        }
    }
    public static String getVal() throws IOException {

        URL url = new URL("https://block.io/api/v1/get_current_price/?api_key=8467-e6b6-f79b-e1ba&price_base=USD");

        String str = "";

        StringBuilder text = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        while ((str = in.readLine()) != null) {
            text.append(str);
        }
        in.close();

        return str;
    }



    public static String currentVal() throws Exception{


        String cleanedVal;
        String rawVals;
        rawVals = getVal();
        String[] splitString = rawVals.split("\"price\"\\: \"");
        String trimVal = splitString[1];
        String[] trimString = trimVal.split("\"");
        return trimString[0];
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
