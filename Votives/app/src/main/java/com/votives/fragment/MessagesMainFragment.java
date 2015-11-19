package com.votives.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.votives.R;

/**
 * Created by darkbobo on 11/19/15.
 */
public class MessagesMainFragment extends BaseFragment {
	public static MessagesMainFragment newInstance(){
		MessagesMainFragment fragment = new MessagesMainFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.fragment_messages, container, false);

		return rootView;
	}
}
