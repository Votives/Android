package com.votives.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.votives.R;

/**
 * Created by darkbobo on 11/19/15.
 */
public class ToolbarFragment extends Fragment implements View.OnClickListener{
	public static final String ACTIVE_SCREEN = "activeScreen";
	Button messages;
	Button interests;
	Button discover;

	public static ToolbarFragment newInstance(int screen){
		ToolbarFragment fragment = new ToolbarFragment();
		Bundle args = new Bundle();
		args.putInt(ACTIVE_SCREEN, screen);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.fragment_toolbar, container, false);
		int screen = getArguments().getInt(ACTIVE_SCREEN);
		switch (screen) {
			// replace with more malleable methods
			case 1:
				break;
		}

		messages = (Button)rootView.findViewById(R.id.toolbar_messages);
		interests = (Button)rootView.findViewById(R.id.toolbar_interests);
		discover = (Button)rootView.findViewById(R.id.toolbar_discover);

		return rootView;
	}

	@Override
	public void onClick(View v) {
		if(v.equals(messages)){

		}else if(v.equals(interests)){

		}else if(v.equals(discover)){

		}
	}
}
