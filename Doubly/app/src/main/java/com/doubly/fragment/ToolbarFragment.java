package com.doubly.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.doubly.R;
import com.doubly.activity.MainActivity;
import com.doubly.adapter.ScreenKeys;

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
		messages = (Button)rootView.findViewById(R.id.toolbar_messages);
		interests = (Button)rootView.findViewById(R.id.toolbar_interests);
		discover = (Button)rootView.findViewById(R.id.toolbar_discover);

		messages.setBackgroundColor(Color.WHITE);
		interests.setBackgroundColor(Color.WHITE);
		discover.setBackgroundColor(Color.WHITE);
		switch (screen) {
			// replace with more malleable methods
			case 0:
				interests.setBackgroundColor(Color.BLUE);
				break;
			case 1:
				messages.setBackgroundColor(Color.BLUE);
				break;
			case 2:
				discover.setBackgroundColor(Color.BLUE);
		}
		messages.setOnClickListener(this);
		interests.setOnClickListener(this);
		discover.setOnClickListener(this);
		return rootView;
	}

	@Override
	public void onClick(View v) {
		if(v.equals(messages)){
			MainActivity.changeScreen(ScreenKeys.MESSAGES_MAIN);
		}else if(v.equals(interests)){
			MainActivity.changeScreen(ScreenKeys.INTERESTS_MAIN);
		}else if(v.equals(discover)){
			MainActivity.changeScreen(ScreenKeys.DISCOVER_MAIN);
		}
	}
}
