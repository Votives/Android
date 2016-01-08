package com.doubly.object;

import java.util.Date;

/**
 * Created by tinyiota on 12/27/15.
 */
public class MainChatMessage {
    int receiverID;
    Date timeCreated;
    Date DOB;
    String gender;
    String name;
    String messageText;
    int messageCount;
    boolean areFriends;

    public MainChatMessage(){

    }

    public MainChatMessage(int receiverID, Date timeCreated, Date DOB, String gender, String name, String messageText, int messageCount, boolean areFriends) {
        this.receiverID = receiverID;
        this.timeCreated = timeCreated;
        this.DOB = DOB;
        this.gender = gender;
        this.name = name;
        this.messageText = messageText;
        this.messageCount = messageCount;
        this.areFriends = areFriends;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    public boolean areFriends() {
        return areFriends;
    }

    public void setAreFriends(boolean areFriends) {
        this.areFriends = areFriends;
    }
}
