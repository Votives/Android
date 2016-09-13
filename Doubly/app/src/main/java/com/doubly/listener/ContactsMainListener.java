package com.doubly.listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.doubly.activity.MainActivity;
import com.doubly.adapter.MessagesMainAdapter;
import com.doubly.adapter.ScreenKeys;
import com.doubly.object.TestData;
import com.doubly.object.User;

/**
 * Created by darkbobo on 11/19/15.
 */
public class ContactsMainListener extends BaseListener {

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

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		MainActivity.fs.onRowSelected(ScreenKeys.MESSAGES_MAIN, (User)parent.getItemAtPosition(position));
	}
}
