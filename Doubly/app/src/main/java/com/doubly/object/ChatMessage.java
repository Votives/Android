package com.doubly.object;

/**
 * Created by darkbobo on 12/13/15.
 */
public class ChatMessage {
	int messageID;
	int senderID;
	int receiverID;
	String messageText;
	long timeCreated;

	public ChatMessage() {
	}

	public ChatMessage(int messageID, int senderID, int receiverID, String messageText, long timeCreated) {
		this.messageID = messageID;
		this.senderID = senderID;
		this.receiverID = receiverID;
		this.messageText = messageText;
		this.timeCreated = timeCreated;
	}

	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public int getSenderID() {
		return senderID;
	}

	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}

	public int getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(int receiverID) {
		this.receiverID = receiverID;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public long getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(long timeCreated) {
		this.timeCreated = timeCreated;
	}
}
