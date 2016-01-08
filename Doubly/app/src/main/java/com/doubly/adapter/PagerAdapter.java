package com.doubly.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.votives.activity.MainActivity;

/**
 * Created by darkbobo on 11/19/15.
 */
public class PagerAdapter extends FragmentPagerAdapter {

	public PagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		return MainActivity.pagerFragments.get(arg0);
	}

	@Override
	public int getCount() {
		return MainActivity.pagerFragments.size();
	}

}