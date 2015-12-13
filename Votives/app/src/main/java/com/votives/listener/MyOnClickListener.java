package com.votives.listener;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.BaseAdapter;

import com.votives.fragment.BaseFragment;

import java.util.HashMap;
/**
 * Created by darkbobo on 11/17/15.
 */
public class MyOnClickListener implements View.OnClickListener {
	HashMap<String,View> views;
	BaseFragment fragment;
	BaseAdapter adapter;
	Context context;

	public MyOnClickListener(Context context){
		this.context = context;
		views = new HashMap<>();
	}

	@Override
	public void onClick(View v) {

	}

	public void registerView(String key, View view){
		views.put(key, view);
	}

	public void setView(BaseFragment fragment){
		this.fragment = fragment;
	}

	public void initViews(){

	}
}
