package com.votives.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.votives.R;
import com.votives.adapter.MessagesMainAdapter;
import com.votives.objects.TestData;

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
		rootView = inflater.inflate(R.layout.fragment_messages, container, false);
		ListView messagesList = (ListView)rootView.findViewById(R.id.message_list);
		MessagesMainAdapter adapter = new MessagesMainAdapter(getActivity(), TestData.getInstance().getGroupMessages());
		messagesList.setAdapter(adapter);
		return rootView;
	}
}
