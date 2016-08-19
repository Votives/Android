package com.doubly.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.doubly.R;

/**
 * Created by darkbobo on 12/17/15.
 */
public class InterestUserListFragment extends BaseFragment {
	ListView interestUserList;

	public InterestUserListFragment(){

	}

	public static InterestUserListFragment newInstance(){
		InterestUserListFragment fragment = new InterestUserListFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_interest_user_list, container, false);
		return rootView;
	}

	@Override
	public void registerViews() {
		interestUserList = (ListView)rootView.findViewById(R.id.interest_user_list);
		listener.registerView("interestUserList", interestUserList);
		interestUserList.setOnItemClickListener(listener);
	}
}
