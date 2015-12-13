package com.votives.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.votives.R;

/**
 * Created by darkbobo on 11/17/15.
 */
public class LoginFragment extends BaseFragment {
	public static LoginFragment newInstance(){
		LoginFragment fragment = new LoginFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_main, container, false);
		return rootView;
	}
}
