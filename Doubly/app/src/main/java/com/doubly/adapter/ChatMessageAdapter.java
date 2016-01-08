package com.doubly.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.doubly.R;
import com.doubly.object.ChatMessage;

import java.util.ArrayList;

/**
 * Created by tinyiota on 12/28/15.
 */
public class ChatMessageAdapter extends MyBaseAdapter {
    ArrayList<ChatMessage> messages;
    public ChatMessageAdapter(Context context, ArrayList<ChatMessage> messages) {
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
            convertView = inflater.inflate(R.layout.row_chat_message, parent, false);
            holder = new ViewHolder();
            holder.messageText = (TextView)convertView.findViewById(R.id.message_text);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        ChatMessage message = (ChatMessage)getItem(position);
        holder.messageText.setText(message.getMessageText());
        return convertView;
    }

    private class ViewHolder {
        TextView messageText;
    }
}
