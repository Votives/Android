package com.doubly.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.doubly.object.User;

import java.util.ArrayList;

/**
 * Created by tinyiota on 1/25/16.
 */
public class InterestUserAdapter extends MyBaseAdapter {
    ArrayList<User> users;

    public InterestUserAdapter(Context context, ArrayList<User> users) {
        super(context);
        this.users = users;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    private class ViewHolder{
        TextView interestsTitle;
        TextView interestsMatching;
    }
}
