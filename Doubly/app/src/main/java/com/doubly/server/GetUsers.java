package com.doubly.server;

import android.os.AsyncTask;

import com.doubly.utils.L;
import com.doubly.utils.Session;
import com.doubly.utils.SessionKeys;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tinyiota on 8/19/16.
 */
public class GetUsers extends AsyncTask<String,Void,Boolean> {
    @Override
    protected Boolean doInBackground(String... params) {
        HttpURLConnection connection = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection)url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            while((line = reader.readLine()) != null) {
                builder.append(line);
            }
            reader.close();
            L.e(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.disconnect();
            }
        }
        L.e("GetObjects");
        boolean success = false;
        if(!builder.toString().equals("DNE")){
            try {
                JSONObject object = new JSONObject(builder.toString());
                Session.setInt(SessionKeys.PREFFS_USER_ID, object.getInt("UserID"));
                success = true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    @Override
    protected void onPostExecute(Boolean success) {
        if(success){
            // update via listener
        }
    }
}
