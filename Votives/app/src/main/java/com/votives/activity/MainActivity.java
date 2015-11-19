package com.votives.activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.votives.R;
import com.votives.adapter.PagerAdapter;
import com.votives.fragment.BaseFragment;
import com.votives.fragment.CreateUserFragment;
import com.votives.fragment.InterestMainFragment;
import com.votives.fragment.LoginFragment;
import com.votives.fragment.MessagesMainFragment;
import com.votives.fragment.ToolbarFragment;
import com.votives.listener.CreateUserListener;
import com.votives.listener.LoginListener;
import com.votives.listener.MessagesMainListener;
import com.votives.listener.MyOnClickListener;
import com.votives.listener.MyPagerListener;

import java.util.HashMap;


public class MainActivity extends FragmentActivity {
	private static FragmentManager manager;
	public static HashMap<String,BaseFragment> pagerFragments;
	public static HashMap<String,BaseFragment> otherFragments;
	public HashMap<String,MyOnClickListener> listeners;
	PagerAdapter pagerAdapter;
	ViewPager pager;

	public final String LOGIN_SCREEN = "loginScreen";
	public final String INTERESTS_MAIN = "interestsMain";
	public final String CREATE_USER = "createUser";
	public final String MESSAGES_MAIN = "messagesMain";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initMVC();

		pagerAdapter = new PagerAdapter(manager);
		pager = (ViewPager)findViewById(R.id.main_pager);
		pager.setAdapter(pagerAdapter);
		pager.setCurrentItem(0);
		pager.setOffscreenPageLimit(3);
		pager.setOnPageChangeListener(new MyPagerListener());

		manager = getSupportFragmentManager();
		manager.beginTransaction().add(R.id.fragment, pagerFragments.get(INTERESTS_MAIN)).commit();
	}

	public void changeScreen(String newScreen){
		manager.beginTransaction().add(R.id.fragment, pagerFragments.get(newScreen)).commit();
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
		pagerFragments = new HashMap<>();

		pagerFragments.put(INTERESTS_MAIN, InterestMainFragment.newInstance());
		pagerFragments.put(MESSAGES_MAIN, MessagesMainFragment.newInstance());

		otherFragments = new HashMap<>();
		otherFragments.put(LOGIN_SCREEN, LoginFragment.newInstance());
		otherFragments.put(CREATE_USER, CreateUserFragment.newInstance());

		listeners = new HashMap<>();
		listeners.put(LOGIN_SCREEN, new LoginListener());
		listeners.put(INTERESTS_MAIN, new LoginListener());
		listeners.put(CREATE_USER, new CreateUserListener());
		listeners.put(MESSAGES_MAIN, new MessagesMainListener());


		for(String key : pagerFragments.keySet()){
			pagerFragments.get(key).setListener(listeners.get(key));
			listeners.get(key).setView(pagerFragments.get(key));
		}
		ToolbarFragment tbFragment = ToolbarFragment.newInstance(1);
		manager.beginTransaction().add(R.id.tool_bar, tbFragment).commit();
	}
}
