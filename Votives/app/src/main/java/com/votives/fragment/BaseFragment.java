package com.votives.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.votives.listener.MyOnClickListener;

import java.util.HashMap;

/**
 * Created by darkbobo on 11/17/15.
 */

public class BaseFragment extends Fragment {
	MyOnClickListener listener;
	View rootView;

	public BaseFragment(){}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public void setListener(MyOnClickListener listener){
		this.listener = listener;
	}

	public void registerViews(){

	}
}
