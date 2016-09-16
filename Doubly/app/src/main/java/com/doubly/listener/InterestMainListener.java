package com.doubly.listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.doubly.activity.MainActivity;
import com.doubly.R;
import com.doubly.adapter.InterestsMainAdapter;
import com.doubly.adapter.ScreenKeys;
import com.doubly.dialog.AddInterestDialog;
import com.doubly.fragment.InterestMainFragment;
import com.doubly.object.Interest;
import com.doubly.object.TestData;

/**
 * Created by darkbobo on 11/17/15.
 */
public class InterestMainListener extends BaseListener implements View.OnLongClickListener{
	public InterestMainListener(Context context){
		super(context);
	}

	@Override
	public void onClick(View v){
		if(v.equals(views.get("addInterestButton"))){
			AddInterestDialog iDialog = new AddInterestDialog(context);
			iDialog.init();
			iDialog.show();
		}
	}

	@Override
	public void initViews() {
		// code to add interests from ObjectStore
		adapter = new InterestsMainAdapter(context, TestData.getInstance().getInterests());
		((ListView)views.get("interestList")).setAdapter(adapter);
		((Button)views.get("addInterestButton")).setOnClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Toast.makeText(context, position + " clicked.", Toast.LENGTH_SHORT).show();
		//MainActivity.fs.changeScreen(ScreenKeys.INTERESTS_USER_LIST);
		MainActivity.fs.onRowSelected(ScreenKeys.INTERESTS_MAIN, (Interest)parent.getItemAtPosition(position));
	}


	@Override
	public boolean onLongClick(View v) {
		return false;
	}
}
