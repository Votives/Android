package com.votives.objects;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by darkbobo on 12/13/15.
 */
public class TestData {
	public static ArrayList<Interest> interests;
	public static ArrayList<ChatMessage> messages;
	public static ArrayList<User> users;
	public static TestData data;

	public TestData(){
		interests = new ArrayList<>();
		messages = new ArrayList<>();
		users = new ArrayList<>();
	}

	public static ArrayList<Interest> getInterests(){
		return interests;
	}

	public static ArrayList<ChatMessage> getMessages(){
		return messages;
	}

	public static ArrayList<User> getUsers(){
		return users;
	}

	public static TestData getInstance(){
		if(data == null){
			data = new TestData();
			data.init();
		}
		return data;
	}

	public void init(){
		interests.add(new Interest("dog", 3));
		interests.add(new Interest("cat", 2));
		interests.add(new Interest("pen", 8));

		users.add(new User(1, "Jim", 123456, "M"));
		users.add(new User(2, "Pam", 2341323, "F"));
		users.add(new User(3, "Bill", 123423, "M"));
		users.add(new User(4, "Arai", 32121, "M"));

		messages.add(new ChatMessage(1, 1, 2, "hello", new Date().getTime()));
		messages.add(new ChatMessage(2, 2, 1, "hello to you too", new Date().getTime()));
		messages.add(new ChatMessage(3, 1, 2, "i think you're cute", new Date().getTime()));
		messages.add(new ChatMessage(4, 1, 3, "your mother", new Date().getTime()));
		messages.add(new ChatMessage(5, 3, 1, "what about that slut?", new Date().getTime()));
	}
}
