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
public class ChatBottomFragment extends BaseFragment {
    int receiverID;

    public static ChatBottomFragment newInstance(int receiverID){
        ChatBottomFragment fragment = new ChatBottomFragment();
        Bundle args = new Bundle();
        args.putInt(MainActivity.RECEIVER_ID, receiverID);
        L.e("ChatBottomFragment", "Bottom " + receiverID);
        fragment.setArguments(args);
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
