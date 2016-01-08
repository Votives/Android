package com.doubly.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.votives.R;

/**
 * Created by darkbobo on 12/13/15.
 *
 * search capabilities
 */
public class DiscoverMainFragment extends BaseFragment {

	public DiscoverMainFragment(){}

	public static DiscoverMainFragment newInstance(){
		DiscoverMainFragment fragment = new DiscoverMainFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		rootView = inflater.inflate(R.layout.fragment_discover_main, container, false);
		return rootView;
	}
}
