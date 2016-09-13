package com.doubly.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.doubly.R;
import com.doubly.activity.MainActivity;
import com.doubly.adapter.ChatMessageAdapter;
import com.doubly.object.TestData;
import com.doubly.utils.L;

/**
 * A placeholder fragment containing a simple view.
 */
public class ChatFragment extends BaseFragment {

    public static ChatFragment newInstance(){
        ChatFragment fragment = new ChatFragment();
        return fragment;
    }

    public ChatFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);
        registerViews();
        listener.initViews();
        return rootView;
    }

    @Override
    public void registerViews() {
        ListView messageList = (ListView)rootView.findViewById(R.id.message_list);
        listener.registerView("MESSAGE_LIST", messageList);
    }
}
