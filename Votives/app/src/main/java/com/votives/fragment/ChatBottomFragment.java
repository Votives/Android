package com.votives.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.votives.R;
import com.votives.activity.MainActivity;

/**
 * Created by tinyiota on 12/27/15.
 */
public class ChatBottomFragment extends BaseFragment {
    int receiverID;

    public static ChatTopFragment newInstance(int receiverID){
        ChatTopFragment fragment = new ChatTopFragment();
        Bundle args = new Bundle();
        args.putInt(MainActivity.RECEIVER_ID, receiverID);
        return fragment;
    }

    public ChatBottomFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_chat_bottom, container, false);
        receiverID = getArguments().getInt(MainActivity.RECEIVER_ID);
        return rootView;
    }
}
