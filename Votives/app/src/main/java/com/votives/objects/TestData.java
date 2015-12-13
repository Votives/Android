package com.votives.objects;

import java.util.ArrayList;

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

		users.add(new User());
		users.add(new User());
		users.add(new User());
		users.add(new User());
		users.add(new User());

		messages.add(new ChatMessage());
		messages.add(new ChatMessage());
		messages.add(new ChatMessage());
		messages.add(new ChatMessage());
		messages.add(new ChatMessage());
	}
}
