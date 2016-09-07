package com.doubly.listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import com.doubly.adapter.InterestUserAdapter;
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

	}

	@Override
	public void initViews() {
		InterestUserAdapter adapter = new InterestUserAdapter(context, new ArrayList<User>());
	}
}
