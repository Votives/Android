package com.doubly.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;

import com.doubly.R;
import com.doubly.activity.DoublyApplication;
import com.doubly.adapter.PagerAdapter;
import com.doubly.adapter.ScreenKeys;
import com.doubly.listener.BaseListener;
import com.doubly.listener.ContactsMainListener;
import com.doubly.listener.CreateUserListener;
import com.doubly.listener.DiscoverMainListener;
import com.doubly.listener.InterestMainListener;
import com.doubly.listener.InterestUserListListener;
import com.doubly.listener.LoginListener;
import com.doubly.listener.MyPagerListener;
import com.doubly.object.BaseObject;
import com.doubly.utils.L;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tinyiota on 9/11/16.
 */
public class FragmentStore implements BaseFragment.OnRowSelectedListener, BaseFragment.OnButtonScreenChangeListener{
    ToolbarFragment toolbarFragment;
    MyPagerListener pageListener;
    private FragmentManager manager;
    ArrayList<BaseFragment> pagerFragments;
    HashMap<String,BaseFragment> supportFragments;
    HashMap<String,BaseListener> listeners;
    ViewPager pager;
    PagerAdapter pagerAdapter;
    FrameLayout supportFragmentView;
    boolean mainIsShowing;
    public static BaseFragment.OnRowSelectedListener rowSelectedListener;

    public FragmentStore(){
        pagerFragments = new ArrayList<>();
        supportFragments = new HashMap<>();
        listeners = new HashMap<>();
        mainIsShowing = true;
        rowSelectedListener = this;
    }

    public void setFragmentManager(FragmentManager manager){
        this.manager = manager;
    }

    public void setPager(ViewPager pager){
        this.pager = pager;
    }

    public void setSupportFragmentView(FrameLayout layout){
        this.supportFragmentView = layout;
    }

    public BaseFragment getPagerFragment(int index){
        return pagerFragments.get(index);
    }

    public int getPagerFragmentSize(){
        return pagerFragments.size();
    }

    public void initStore(){
        pagerFragments.add(InterestMainFragment.newInstance());
        pagerFragments.add(ContactsMainFragment.newInstance());
        pagerFragments.add(DiscoverMainFragment.newInstance());

        supportFragments.put(ScreenKeys.getScreenByIntKey(0), LoginFragment.newInstance());
        supportFragments.put(ScreenKeys.getScreenByIntKey(2), CreateUserFragment.newInstance());
        supportFragments.put(ScreenKeys.getScreenByIntKey(5), InterestUserListFragment.newInstance());

        listeners.put(ScreenKeys.LOGIN_SCREEN, new LoginListener(DoublyApplication.getContext()));
        listeners.put(ScreenKeys.INTERESTS_MAIN, new InterestMainListener(DoublyApplication.getContext()));
        listeners.put(ScreenKeys.CREATE_USER, new CreateUserListener(DoublyApplication.getContext()));
        listeners.put(ScreenKeys.MESSAGES_MAIN, new ContactsMainListener(DoublyApplication.getContext()));
        listeners.put(ScreenKeys.DISCOVER_MAIN, new DiscoverMainListener(DoublyApplication.getContext()));
        listeners.put(ScreenKeys.INTERESTS_USER_LIST, new InterestUserListListener(DoublyApplication.getContext()));

        pagerFragments.get(0).setListener(listeners.get(ScreenKeys.INTERESTS_MAIN));
        pagerFragments.get(1).setListener(listeners.get(ScreenKeys.MESSAGES_MAIN));
        pagerFragments.get(2).setListener(listeners.get(ScreenKeys.DISCOVER_MAIN));

        listeners.get(ScreenKeys.INTERESTS_MAIN).setView(pagerFragments.get(0));
        listeners.get(ScreenKeys.MESSAGES_MAIN).setView(pagerFragments.get(1));
        listeners.get(ScreenKeys.DISCOVER_MAIN).setView(pagerFragments.get(2));

        for(String key : supportFragments.keySet()){
            supportFragments.get(key).setListener(listeners.get(key));
            listeners.get(key).setView(supportFragments.get(key));
        }

        toolbarFragment = ToolbarFragment.newInstance(0);
        manager.beginTransaction().add(R.id.tool_bar, toolbarFragment).commit();

        // TODO: check to see if user is logged in, if not, go to login screen

        pagerAdapter = new PagerAdapter(manager);
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(0);
        pager.setOffscreenPageLimit(3);
        pageListener = new MyPagerListener();
        pageListener.setFragmentManager(manager);
        pager.setOnPageChangeListener(pageListener);
    }

    public void changeScreen(String newScreen){
        if(supportFragments.containsKey(newScreen)) {
            pager.setVisibility(View.GONE);
            supportFragmentView.setVisibility(View.VISIBLE);
            manager.beginTransaction().add(R.id.fragment, supportFragments.get(newScreen)).commit();
            mainIsShowing = false;
        }else{
            L.e(newScreen);
            pager.setVisibility(View.VISIBLE);
            supportFragmentView.setVisibility(View.GONE);
            pager.setCurrentItem(ScreenKeys.getPagerScreenLocation(newScreen));
            mainIsShowing = true;
        }
    }

    // to handle when a user selects a row on a listview
    // and therefore the screen changes
    // do not interact with the ObjectStore here
    @Override
    public void onRowSelected(String screenKey, BaseObject object) {

    }

    // to handle button screen swaps
    //      like when the user selects the button to create a user
    //      or when the user selects the button to add a new interest
    // do not interact with the ObjectStore here
    @Override
    public void onButtonScreenChanged(String oldScreen, String newScreen) {

    }
}
