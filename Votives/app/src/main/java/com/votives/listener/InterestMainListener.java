package com.votives.listener;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.votives.adapter.InterestsMainAdapter;
import com.votives.objects.Interest;
import com.votives.objects.TestData;

import java.util.ArrayList;

/**
 * Created by darkbobo on 11/17/15.
 */
public class InterestMainListener extends MyOnClickListener {

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
		((ListView)views.get("interestsList")).setAdapter(adapter);
	}
}
