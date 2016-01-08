package com.doubly.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.votives.R;

import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class InterestMainFragment extends BaseFragment {
	ListView interestList;


	public InterestMainFragment() {
	}

	public static InterestMainFragment newInstance(){
		InterestMainFragment fragment = new InterestMainFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_interest_main, container, false);
		interestList = (ListView)rootView.findViewById(R.id.interests_list);
		registerViews();
		listener.initViews();
		return rootView;
	}

	@Override
	public void registerViews(){
		listener.registerView("interestList", interestList);
	}
}
