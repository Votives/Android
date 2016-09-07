package com.doubly.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.doubly.listener.BaseListener;

/**
 * Created by darkbobo on 11/17/15.
 */

public class BaseFragment extends Fragment {
	BaseListener listener;
	View rootView;

	public BaseFragment(){}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public void setListener(BaseListener listener){
		this.listener = listener;
	}

	public void registerViews(){

	}
}
