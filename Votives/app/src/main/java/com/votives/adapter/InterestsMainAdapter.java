package com.votives.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.votives.R;
import com.votives.objects.Interest;
import com.votives.views.MyTextView;

import java.util.ArrayList;

/**
 * Created by darkbobo on 12/13/15.
 */
public class InterestsMainAdapter extends BaseAdapter {
	ArrayList<Interest> interests;
	LayoutInflater inflater;
	Context context;

	public InterestsMainAdapter(Context context, ArrayList<Interest> interests){
		this.context = context;
		this.interests = interests;
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
			holder.interestsTitle = (MyTextView)convertView.findViewById(R.id.interests_title);
			holder.interestsMatching = (MyTextView)convertView.findViewById(R.id.interests_matching);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();
		}

		Interest interest = (Interest)getItem(position);
		holder.interestsTitle.setText(interest.getInterestTitle());
		holder.interestsMatching.setText(Integer.toString(interest.getInterestMatchCount()));
		return convertView;
	}

	private class ViewHolder{
		MyTextView interestsTitle;
		MyTextView interestsMatching;
	}
}
