package com.votives.adapter;

import com.votives.utils.L;

/**
 * Created by darkbobo on 12/13/15.
 */
public class ScreenKeys {
	public static String LOGIN_SCREEN = "loginScreen";
	public static String INTERESTS_MAIN = "interestsMain";
	public static String CREATE_USER = "createUser";
	public static String MESSAGES_MAIN = "messagesMain";
	public static String DISCOVER_MAIN = "discoverMain";
	public static String INTERESTS_USER_LIST = "interestsUserList";

	public ScreenKeys(){

	}

	public static String getScreenByIntKey(int index){
		if(index == 0){
			return LOGIN_SCREEN;
		}else if(index == 1){
			return INTERESTS_MAIN;
		}else if(index == 2){
			return CREATE_USER;
		}else if(index == 3){
			return MESSAGES_MAIN;
		}else if(index == 4){
			return DISCOVER_MAIN;
		}else if(index == 5){
			return INTERESTS_USER_LIST;
		}

		return "";
	}

	public static int getPagerScreenLocation(String screen){
		if(screen.equals(INTERESTS_MAIN)){
			return 0;
		}else if(screen.equals(MESSAGES_MAIN)){
			return 1;
		}else if(screen.equals(DISCOVER_MAIN)){
			return 2;
		}
		L.e("Error has occurred");
		return 0;
	}
}
