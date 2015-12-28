package com.votives.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.votives.activity.DoublyApplication;

/**
 * Created by tinyiota on 12/28/15.
 */
public class Session {
    public static SharedPreferences getShared(){
        SharedPreferences preferences = DoublyApplication.getContext().getSharedPreferences(SessionKeys.SHARED_PREFFS, Context.MODE_PRIVATE);
        return preferences;
    }

    public static int getInt(String value) throws NullPointerException {
        int result = 0;
        try{
            result = getShared().getInt(value, 0);
        }catch (Exception e){
            throw new NullPointerException();
        }
        return result;
    }
}
