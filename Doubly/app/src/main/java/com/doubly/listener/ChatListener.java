package com.doubly.listener;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.doubly.adapter.ChatMessageAdapter;
import com.doubly.fragment.BaseFragment;
import com.doubly.object.TestData;

/**
 * Created by tinyiota on 9/13/16.
 * Handles controlling all of the chatFragments
 */
public class ChatListener extends BaseListener {
    // fragment is the body fragment
    BaseFragment topFragment;
    BaseFragment bottomFragment;

    public ChatListener(Context context) {
        super(context);
    }

    @Override
    public void initViews() {
        ChatMessageAdapter adapter = new ChatMessageAdapter(context, null);
        ((ListView)views.get("MESSAGE_LIST")).setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

    }

    public void setTopFragment(BaseFragment fragment){
        this.topFragment = fragment;
    }

    public void setBottomFragment(BaseFragment fragment){
        this.bottomFragment = fragment;
    }
}
