package com.doubly.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doubly.R;
import com.doubly.activity.MainActivity;
import com.doubly.utils.L;

/**
 * Created by tinyiota on 12/27/15.
 */
public class ChatTopFragment extends BaseFragment {

    public static ChatTopFragment newInstance(){
        ChatTopFragment fragment = new ChatTopFragment();
        return fragment;
    }

    public ChatTopFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_chat_top, container, false);
        registerViews();
        listener.initViews();
        return rootView;
    }

    @Override
    public void registerViews() {

    }
}
