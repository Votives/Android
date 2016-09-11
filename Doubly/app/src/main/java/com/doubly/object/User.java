package com.doubly.object;

import java.util.ArrayList;

/**
 * Created by darkbobo on 12/13/15.
 */
public class User extends BaseObject {
	int userID;
	String userName;
	long DOB;
	String gender;
	ArrayList<Interest> interests;
	ArrayList<User> contacts;

	public User(){

	}

	public User(int userID, String userName, long DOB, String gender) {
		this.userID = userID;
		this.userName = userName;
		this.DOB = DOB;
		this.gender = gender;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getDOB() {
		return DOB;
	}

	public void setDOB(long DOB) {
		this.DOB = DOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setInterests(ArrayList<Interest> interests){
		this.interests = interests;
	}

	public ArrayList<Interest> getInterests(){
		return interests;
	}

	public void addInterest(Interest interest){
		this.interests.add(interest);
	}

	public void removeInterest(Interest interest){
		this.interests.remove(interest);
	}
}
