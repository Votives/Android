package com.votives.activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.votives.R;
import com.votives.adapter.PagerAdapter;
import com.votives.adapter.ScreenKeys;
import com.votives.fragment.BaseFragment;
import com.votives.fragment.CreateUserFragment;
import com.votives.fragment.DiscoverMainFragment;
import com.votives.fragment.InterestMainFragment;
import com.votives.fragment.LoginFragment;
import com.votives.fragment.MessagesMainFragment;
import com.votives.fragment.ToolbarFragment;
import com.votives.listener.CreateUserListener;
import com.votives.listener.InterestMainListener;
import com.votives.listener.LoginListener;
import com.votives.listener.MessagesMainListener;
import com.votives.listener.MyOnClickListener;
import com.votives.listener.MyPagerListener;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends FragmentActivity {
	private static FragmentManager manager;
	public static ArrayList<BaseFragment> pagerFragments;
	public static HashMap<String,BaseFragment> otherFragments;
	public HashMap<String,MyOnClickListener> listeners;
	PagerAdapter pagerAdapter;
	ViewPager pager;
	FrameLayout otherFragmentsView;
	ToolbarFragment toolbarFragment;
	MyPagerListener pageListener;

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
	}

	public void changeScreen(String newScreen){
		if(otherFragments.containsKey(newScreen)) {
			pager.setVisibility(View.GONE);
			otherFragmentsView.setVisibility(View.VISIBLE);
			manager.beginTransaction().add(R.id.fragment, otherFragments.get(newScreen)).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	public void initMVC(){
		pagerFragments = new ArrayList<>();

		pagerFragments.add(InterestMainFragment.newInstance());
		pagerFragments.add(MessagesMainFragment.newInstance());
		pagerFragments.add(DiscoverMainFragment.newInstance());

		otherFragments = new HashMap<>();
		otherFragments.put(ScreenKeys.getScreenByIntKey(0), LoginFragment.newInstance());
		otherFragments.put(ScreenKeys.getScreenByIntKey(2), CreateUserFragment.newInstance());

		listeners = new HashMap<>();
		listeners.put(ScreenKeys.getScreenByIntKey(0), new LoginListener());
		listeners.put(ScreenKeys.getScreenByIntKey(1), new InterestMainListener());
		listeners.put(ScreenKeys.getScreenByIntKey(2), new CreateUserListener());
		listeners.put(ScreenKeys.getScreenByIntKey(3), new MessagesMainListener());


		for(int i = 0; i < pagerFragments.size(); i++){
			pagerFragments.get(i).setListener(listeners.get(ScreenKeys.getScreenByIntKey(i)));
			listeners.get(ScreenKeys.getScreenByIntKey(i)).setView(pagerFragments.get(i));
		}
		toolbarFragment = ToolbarFragment.newInstance(1);
		manager.beginTransaction().add(R.id.tool_bar, toolbarFragment).commit();
	}
}
