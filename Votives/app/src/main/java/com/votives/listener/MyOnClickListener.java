package com.votives.listener;

import android.support.v4.app.Fragment;
import android.view.View;

import java.util.HashMap;
/**
 * Created by darkbobo on 11/17/15.
 */
public class MyOnClickListener implements View.OnClickListener {
	HashMap<String,View> views;
	Fragment fragment;

	public MyOnClickListener(){
		views = new HashMap<>();
	}

	@Override
	public void onClick(View v) {

	}

	public void registerView(String key, View view){
		views.put(key, view);
	}

	public void setView(Fragment fragment){
		this.fragment = fragment;
	}
}
