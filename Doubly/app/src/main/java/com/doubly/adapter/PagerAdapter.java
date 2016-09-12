package com.doubly.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.doubly.activity.MainActivity;

/**
 * Created by darkbobo on 11/19/15.
 */
public class PagerAdapter extends FragmentPagerAdapter {
	public PagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		return MainActivity.fs.getPagerFragment(arg0);
	}

	@Override
	public int getCount() {
		return MainActivity.fs.getPagerFragmentSize();
	}
}