package com.doubly.listener;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.doubly.R;
import com.doubly.adapter.InterestsMainAdapter;
import com.doubly.dialog.AddInterestDialog;
import com.doubly.object.TestData;

/**
 * Created by darkbobo on 11/17/15.
 */
public class InterestMainListener extends MyOnClickListener {

	public InterestMainListener(Context context){
		super(context);
	}

	@Override
	public void onClick(View v){
		switch (v.getId())
		{
			case R.id.add_interest:
				AddInterestDialog iDialog = new AddInterestDialog(context);
				iDialog.init();
				iDialog.show();
				break;
		}
	}

	@Override
	public void initViews() {
		// code to add interests from DB
		adapter = new InterestsMainAdapter(context, TestData.getInstance().getInterests());
		((ListView)views.get("interestList")).setAdapter(adapter);
		((Button)views.get("addInterestButton")).setOnClickListener(this);
	}
}
