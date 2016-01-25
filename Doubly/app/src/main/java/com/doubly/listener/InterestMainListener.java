package com.doubly.listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.doubly.activity.MainActivity;
import com.doubly.adapter.InterestsMainAdapter;
import com.doubly.object.TestData;

/**
 * Created by darkbobo on 11/17/15.
 */
public class InterestMainListener extends MyOnClickListener implements AdapterView.OnItemClickListener {

	public InterestMainListener(Context context){
		super(context);
	}

	@Override
	public void onClick(View v){

	}

	@Override
	public void initViews() {
		// code to add interests from DB
		adapter = new InterestsMainAdapter(context, TestData.getInstance().getInterests());
		((ListView)views.get("interestList")).setAdapter(adapter);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Toast.makeText(context, position + " clicked.", Toast.LENGTH_SHORT).show();
		MainActivity.changeScreen(MainActivity.);
	}
}
