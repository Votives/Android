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
import com.doubly.listener.MyOnClickListener;
import com.doubly.listener.MyPagerListener;
import com.doubly.utils.L;
import com.doubly.utils.Session;
import com.doubly.utils.SessionKeys;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends FragmentActivity {
	private static FragmentManager manager;
	public static ArrayList<BaseFragment> pagerFragments;
	public static HashMap<String,BaseFragment> otherFragments;
	public HashMap<String,MyOnClickListener> listeners;
	PagerAdapter pagerAdapter;
	static ViewPager pager;
	static FrameLayout otherFragmentsView;
	ToolbarFragment toolbarFragment;
	MyPagerListener pageListener;
	public static final String CHAT_INFO = "chat_info";
	public static final String RECEIVER_ID = "receiver_id";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		manager = getSupportFragmentManager();
		initMVC();

		pagerAdapter = new PagerAdapter(manager);
		pager = (ViewPager)findViewById(R.id.main_pager);
		pager.setAdapter(pagerAdapter);
		pager.setCurrentItem(0);
		pager.setOffscreenPageLimit(3);
		pageListener = new MyPagerListener();
		pageListener.setFragmentManager(manager);
		pager.setOnPageChangeListener(pageListener);
		otherFragmentsView = (FrameLayout)findViewById(R.id.fragment);
	}

	public static void changeScreen(String newScreen){
		if(otherFragments.containsKey(newScreen)) {
			pager.setVisibility(View.GONE);
			otherFragmentsView.setVisibility(View.VISIBLE);
			manager.beginTransaction().add(R.id.fragment, otherFragments.get(newScreen)).commit();
		}else{
			L.e(newScreen);
			pager.setVisibility(View.VISIBLE);
			otherFragmentsView.setVisibility(View.GONE);
			pager.setCurrentItem(ScreenKeys.getPagerScreenLocation(newScreen));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		//if (id == R.id.action_settings) {
		//	return true;
		//}

		return super.onOptionsItemSelected(item);
	}

	public void initMVC(){
		pagerFragments = new ArrayList<>();

		pagerFragments.add(InterestMainFragment.newInstance());
		pagerFragments.add(ContactsMainFragment.newInstance());
		pagerFragments.add(DiscoverMainFragment.newInstance());

		otherFragments = new HashMap<>();
		otherFragments.put(ScreenKeys.getScreenByIntKey(0), LoginFragment.newInstance());
		otherFragments.put(ScreenKeys.getScreenByIntKey(2), CreateUserFragment.newInstance());
		otherFragments.put(ScreenKeys.getScreenByIntKey(5), InterestUserListFragment.newInstance());

		listeners = new HashMap<>();
		listeners.put(ScreenKeys.LOGIN_SCREEN, new LoginListener(this));
		listeners.put(ScreenKeys.INTERESTS_MAIN, new InterestMainListener(this));
		listeners.put(ScreenKeys.CREATE_USER, new CreateUserListener(this));
		listeners.put(ScreenKeys.MESSAGES_MAIN, new ContactsMainListener(this));
		listeners.put(ScreenKeys.DISCOVER_MAIN, new DiscoverMainListener(this));
		listeners.put(ScreenKeys.INTERESTS_USER_LIST, new InterestUserListListener(this));

		pagerFragments.get(0).setListener(listeners.get(ScreenKeys.INTERESTS_MAIN));
		pagerFragments.get(1).setListener(listeners.get(ScreenKeys.MESSAGES_MAIN));
		pagerFragments.get(2).setListener(listeners.get(ScreenKeys.DISCOVER_MAIN));

		listeners.get(ScreenKeys.INTERESTS_MAIN).setView(pagerFragments.get(0));
		listeners.get(ScreenKeys.MESSAGES_MAIN).setView(pagerFragments.get(1));
		listeners.get(ScreenKeys.DISCOVER_MAIN).setView(pagerFragments.get(2));

		for(String key : otherFragments.keySet()){
			otherFragments.get(key).setListener(listeners.get(key));
			listeners.get(key).setView(otherFragments.get(key));
		}

		toolbarFragment = ToolbarFragment.newInstance(0);
		manager.beginTransaction().add(R.id.tool_bar, toolbarFragment).commit();
	}
}
