package com.votives.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.votives.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class InterestMainFragment extends BaseFragment {

	public InterestMainFragment() {
	}

	public static InterestMainFragment newInstance(){
		InterestMainFragment fragment = new InterestMainFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		return rootView;
	}
}
