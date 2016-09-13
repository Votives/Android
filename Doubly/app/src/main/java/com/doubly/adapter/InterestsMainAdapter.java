package com.doubly.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.doubly.R;
import com.doubly.activity.MainActivity;
import com.doubly.fragment.InterestMainFragment;
import com.doubly.object.Interest;

import java.util.ArrayList;

/**
 * Created by darkbobo on 12/13/15.
 */
public class InterestsMainAdapter extends MyBaseAdapter {
	ArrayList<Interest> interests;

	public InterestsMainAdapter(Context context, ArrayList<Interest> interests){
		super(context);
		this.interests = interests;
	}

	@Override
	public int getCount() {
		return interests.size();
	}

	@Override
	public Object getItem(int position) {
		return interests.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null){
			convertView = inflater.inflate(R.layout.row_interest, parent, false);
			holder = new ViewHolder();
			holder.interestsTitle = (TextView)convertView.findViewById(R.id.interests_title);
			holder.interestsMatching = (TextView)convertView.findViewById(R.id.interests_matching);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();
		}

		Interest interest = (Interest)getItem(position);
		//interestListener.onInterestSelected(interest);
		holder.interestsTitle.setText(interest.getInterestTitle());
		holder.interestsMatching.setText(Integer.toString(interest.getInterestMatchCount()));
		return convertView;
	}

	private class ViewHolder{
		TextView interestsTitle;
		TextView interestsMatching;
	}
}
