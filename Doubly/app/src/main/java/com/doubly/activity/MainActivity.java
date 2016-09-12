package com.doubly.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.doubly.R;
import com.doubly.adapter.PagerAdapter;
import com.doubly.adapter.ScreenKeys;
import com.doubly.fragment.BaseFragment;
import com.doubly.fragment.ContactsMainFragment;
import com.doubly.fragment.CreateUserFragment;
import com.doubly.fragment.DiscoverMainFragment;
import com.doubly.fragment.FragmentStore;
import com.doubly.fragment.InterestMainFragment;
import com.doubly.fragment.InterestUserListFragment;
import com.doubly.fragment.LoginFragment;
import com.doubly.fragment.ToolbarFragment;
import com.doubly.listener.ContactsMainListener;
import com.doubly.listener.CreateUserListener;
import com.doubly.listener.DiscoverMainListener;
import com.doubly.listener.InterestMainListener;
import com.doubly.listener.InterestUserListListener;
import com.doubly.listener.LoginListener;
import com.doubly.listener.BaseListener;
import com.doubly.listener.MyPagerListener;
import com.doubly.object.ObjectStore;
import com.doubly.utils.L;
import com.doubly.utils.Session;
import com.doubly.utils.SessionKeys;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends FragmentActivity {
	public static final String CHAT_INFO = "chat_info";
	public static final String RECEIVER_ID = "receiver_id";
	public static final ObjectStore os = new ObjectStore();
	public static final FragmentStore fs = new FragmentStore();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Session.setInt(SessionKeys.PREFFS_USER_ID, 1); //hardcoding jim
		ViewPager pager = (ViewPager)findViewById(R.id.main_pager);
		FrameLayout supportFragmentView = (FrameLayout)findViewById(R.id.fragment);
		fs.setFragmentManager(getSupportFragmentManager());
		fs.setPager(pager);
		fs.setSupportFragmentView(supportFragmentView);
		fs.initStore();
	}

	@Override
	public void onBackPressed(){
		super.onBackPressed();
	}
}
