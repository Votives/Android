package com.doubly.object;

import com.doubly.activity.DoublyApplication;
import com.doubly.server.DBOpenHelper;

import java.util.ArrayList;

/**
 * Created by Curtis Mayott on 8/19/16.
 *
 * This is the Model portion of the MVC
 *
 * When an insert/delete occurs in the model,
 *      it should be added/removed from the local database and the arraylist.
 * Should be initiated on app open
 *      Should load database into instance (if not loaded already)
 */
public class ObjectStore {
    User user; // the user that is using this
    DBOpenHelper helper;
    ArrayList<Interest> discoverInterests;

    public void init(){
        // load db info into os
        helper = new DBOpenHelper(DoublyApplication.getContext());
        // load users

        // load interests

        // load messages

        helper.close();
    }

    public void insertInterest(Interest i){
        //user.insertInterest(i);
        //helper.insertInterest(i);
    }

    public ArrayList<Interest> getUserInterests(){
        return user.getInterests();
    }

    public ArrayList<MainChatMessage> getMainChatMessages(){
        // generate list of messages by users with count information, last time, and user info
        return null;
    }

    public boolean insertMessage(ChatMessage message){
        // boolean determines if message is inserted (a new one) or not
        // find out if message exists

        // insert

        // insert into database
        return false;
    }
}
