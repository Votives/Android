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
    ArrayList<ChatMessage> messages;
    ArrayList<User> contactUsers;
    ArrayList<User> discoverUsers;
    ArrayList<Interest> interests;
    ArrayList<Interest> discoverInterests;

    public void init(){
        // load db info into os
        DBOpenHelper helper = new DBOpenHelper(DoublyApplication.getContext());
        // load users

        // load interests

        // load messages

        helper.close();
    }

    public ArrayList<ChatMessage> getMessages() {
        return messages;
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

    public void setMessages(ArrayList<ChatMessage> messages) {
        this.messages = messages;
    }

    public ArrayList<User> getContactUsers() {
        return contactUsers;
    }

    public void setContactUsers(ArrayList<User> contactUsers) {
        this.contactUsers = contactUsers;
    }

    public ArrayList<User> getDiscoverUsers() {
        return discoverUsers;
    }

    public void setDiscoverUsers(ArrayList<User> discoverUsers) {
        this.discoverUsers = discoverUsers;
    }

    public ArrayList<Interest> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<Interest> interests) {
        this.interests = interests;
    }

    public ArrayList<Interest> getDiscoverInterests() {
        return discoverInterests;
    }

    public void setDiscoverInterests(ArrayList<Interest> discoverInterests) {
        this.discoverInterests = discoverInterests;
    }
}
