package com.votives.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.votives.R;

/**
 * Created by darkbobo on 11/19/15.
 */
public class CreateUserFragment extends BaseFragment {
	public static CreateUserFragment newInstance(){
		CreateUserFragment fragment = new CreateUserFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.fragment_create_user, container, false);

		return rootView;
	}
}
