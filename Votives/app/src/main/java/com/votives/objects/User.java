package com.votives.objects;

/**
 * Created by darkbobo on 12/13/15.
 */
public class User {
	int userID;
	String userName;
	long DOB;
	String gender;

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
}
