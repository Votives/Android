package com.votives.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.votives.R;
import com.votives.activity.MainActivity;
import com.votives.adapter.ChatMessageAdapter;
import com.votives.objects.TestData;
import com.votives.utils.L;

/**
 * A placeholder fragment containing a simple view.
 */
public class ChatFragment extends BaseFragment {
    int receiverID;

    public static ChatFragment newInstance(int receiverID){
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putInt(MainActivity.RECEIVER_ID, receiverID);
        L.e("ChatFragment", "Chat " + receiverID);
        fragment.setArguments(args);
        return fragment;
    }

    public ChatFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);
        receiverID = getArguments().getInt(MainActivity.RECEIVER_ID);

        ListView messageList = (ListView)rootView.findViewById(R.id.message_list);
        ChatMessageAdapter adapter = new ChatMessageAdapter(getActivity(), TestData.getInstance().getMessagesByReceiverID(receiverID));
        messageList.setAdapter(adapter);
        return rootView;
    }
}
