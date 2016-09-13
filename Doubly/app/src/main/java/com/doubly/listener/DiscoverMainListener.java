package com.doubly.listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import com.doubly.activity.MainActivity;
import com.doubly.adapter.ScreenKeys;
import com.doubly.object.Interest;

/**
 * Created by darkbobo on 12/13/15.
 */
public class DiscoverMainListener extends BaseListener {
	public DiscoverMainListener(Context context) {
		super(context);
	}

	@Override
	public void onClick(View v){

	}

	@Override
	public void initViews() {
		super.initViews();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		MainActivity.fs.onRowSelected(ScreenKeys.DISCOVER_MAIN, (Interest)parent.getItemAtPosition(position));
	}
}
