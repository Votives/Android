package com.doubly.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.doubly.R;
import com.doubly.activity.DoublyApplication;
import com.doubly.listener.InterestMainListener;
import com.doubly.object.Interest;

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
		//interestList.setOnItemClickListener(listener);
		listener.registerView("addInterestButton",rootView.findViewById(R.id.add_interest) );
	}

//	final Button button = (Button) findViewById(R.id.add_interest);
//	button.setOnClickListener(new View.OnClickListener() {
//		public void onClick(View v) {
//			// Perform action on click
//		}
//	});
}
