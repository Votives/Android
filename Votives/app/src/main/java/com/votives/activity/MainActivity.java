package com.votives.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;

import com.votives.R;
import com.votives.fragment.InterestMainFragment;
import com.votives.fragment.LoginFragment;

import java.util.HashMap;


public class MainActivity extends FragmentActivity {
	private static FragmentManager manager;
	public HashMap<String,Fragment> fragments;

	public final String LOGIN_SCREEN = "loginScreen";
	public final String INTERESTS_MAIN = "interestsMain";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		fragments = new HashMap<>();

		fragments.put(LOGIN_SCREEN, LoginFragment.newInstance());
		fragments.put(INTERESTS_MAIN, InterestMainFragment.newInstance());

		manager = getSupportFragmentManager();
		manager.beginTransaction().add(R.id.fragment, fragments.get(LOGIN_SCREEN)).commit();
	}

	public void changeScreen(String newScreen){
		manager.beginTransaction().add(R.id.fragment, fragments.get(newScreen));
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
}
