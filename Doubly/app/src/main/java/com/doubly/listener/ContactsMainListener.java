package com.doubly.listener;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.doubly.adapter.MessagesMainAdapter;
import com.doubly.object.TestData;

/**
 * Created by darkbobo on 11/19/15.
 */
public class ContactsMainListener extends MyOnClickListener {

	public ContactsMainListener(Context context){
		super(context);
	}

	@Override
	public void initViews(){
		adapter = new MessagesMainAdapter(context, TestData.getInstance().getGroupMessages());
		((ListView)views.get("messagesList")).setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {

	}

	@Override
	public void onRefresh() {

	}
}
