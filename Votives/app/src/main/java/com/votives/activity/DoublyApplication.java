package com.votives.activity;

import android.app.Application;
import android.content.Context;

/**
 * Created by tinyiota on 12/28/15.
 */
public class DoublyApplication extends Application {
    private static DoublyApplication instance;

    public DoublyApplication(){
        instance = this;
    }

    public static Context getContext(){
        if(instance == null){
            instance = new DoublyApplication();
        }
        return instance;
    }
}
