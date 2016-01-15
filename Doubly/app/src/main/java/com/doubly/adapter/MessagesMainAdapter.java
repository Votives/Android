package com.doubly.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.doubly.R;
import com.doubly.activity.ChatActivity;
import com.doubly.activity.MainActivity;
import com.doubly.object.MainChatMessage;
import com.doubly.utils.L;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by tinyiota on 12/27/15.
 */
public class MessagesMainAdapter extends MyBaseAdapter{
    ArrayList<MainChatMessage> messages;

    public MessagesMainAdapter(Context context, ArrayList<MainChatMessage> messages){
        super(context);
        this.messages = messages;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.row_message_list_main, parent, false);
            holder = new ViewHolder();
            holder.container = (LinearLayout)convertView.findViewById(R.id.container);
            holder.userInfo = (TextView)convertView.findViewById(R.id.user_info);
            holder.dateTime = (TextView)convertView.findViewById(R.id.date_time);
            holder.messageSnippet = (TextView)convertView.findViewById(R.id.message_snippet);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        final MainChatMessage message = (MainChatMessage)getItem(position);
        if(message.areFriends()){
            holder.userInfo.setText(message.getName());
        }else{
            holder.userInfo.setText(getAge(message.getDOB()) + " " + message.getGender());
        }
        holder.dateTime.setText(String.valueOf(message.getTimeCreated()));
        holder.messageSnippet.setText(message.getMessageText());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ChatActivity.class);
                Bundle b = new Bundle();
                b.putInt(MainActivity.RECEIVER_ID, message.getReceiverID());
                i.putExtra(MainActivity.CHAT_INFO, b);
                context.startActivity(i);
                L.e("MessageMainListener", "OnItemClick " + message.getName());
            }
        });

        L.e(message.getName());
        return convertView;
    }

    public int getAge(Date DOB){
        GregorianCalendar calendar = new GregorianCalendar();
        int yearDOB = DOB.getYear();
        int monthDOB = DOB.getMonth();
        int dayDOB = DOB.getDay();
        int y, m, d, a;

        y = calendar.get(Calendar.YEAR);
        m = calendar.get(Calendar.MONTH);
        d = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(yearDOB, monthDOB, dayDOB);
        a = y - calendar.get(Calendar.YEAR);
        if ((m < calendar.get(Calendar.MONTH))
                || ((m == calendar.get(Calendar.MONTH)) && (d < calendar
                .get(Calendar.DAY_OF_MONTH)))) {
            --a;
        }
        if(a < 0)
            throw new IllegalArgumentException("Age < 0");
        return a;

    }

    private class ViewHolder{
        LinearLayout container;
        TextView userInfo;
        TextView dateTime;
        TextView messageSnippet;
    }
}
