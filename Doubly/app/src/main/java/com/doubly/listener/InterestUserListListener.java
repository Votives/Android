package com.doubly.listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import com.doubly.activity.MainActivity;
import com.doubly.adapter.InterestUserAdapter;
import com.doubly.adapter.ScreenKeys;
import com.doubly.object.User;

import java.util.ArrayList;

/**
 * Created by darkbobo on 12/17/15.
 */
public class InterestUserListListener extends BaseListener {

	public InterestUserListListener(Context context) {
		super(context);
	}

	@Override
	public void onClick(View v) {

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		MainActivity.fs.onRowSelected(ScreenKeys.INTERESTS_USER_LIST, (User)parent.getItemAtPosition(position));
	}

	@Override
	public void initViews() {
		InterestUserAdapter adapter = new InterestUserAdapter(context, new ArrayList<User>());
	}
}
