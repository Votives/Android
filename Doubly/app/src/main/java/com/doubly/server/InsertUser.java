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
 * Created by tinyiota on 9/27/16.
 */
public class InsertUser extends AsyncTask<String,Void,Boolean> {
    // String... params:
    // index 0: username
    // index 1: email
    // index 2: password
    // index 3: DOB
    // index 4: gender
    @Override
    protected Boolean doInBackground(String... params) {
        HttpURLConnection connection = null;
        StringBuilder builder = new StringBuilder();
        try {
            //URL url = new URL(params[0]);
            //     /insert_user/<user name>/<email>/<password>/<DOB>/<gender>

            // change to handle spaces (/0 character or weird text that would never happen)
            URL url = new URL("http://ec2-52-42-244-41.us-west-2.compute.amazonaws.com/insert_user"
                    + "/" + params[0]
                    + "/" + params[1]
                    + "/" + params[2]
                    + "/" + params[3]
                    + "/" + params[4]
            );
            connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            reader.close();
            L.e("Server Result: " + builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        L.e("InsertInterest");
        boolean success = false;
        if (!builder.toString().contains("\"Error\":\"invalid")) {
            try {
                JSONObject object = new JSONObject(builder.toString());
                success = true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    @Override
    protected void onPostExecute(Boolean success) {
        if (success) {
            // update via listener
        }
    }
}