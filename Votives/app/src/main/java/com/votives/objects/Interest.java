package com.votives.objects;

/**
 * Created by darkbobo on 12/13/15.
 */
public class Interest {
	private int interestID;
	private String interestTitle;
	private int interestMatchCount;

	public Interest() {
	}

	public Interest(String interestTitle, int interestMatchCount){
		setInterestTitle(interestTitle);
		setInterestMatchCount(interestMatchCount);
	}

	public Interest(int interestID, String interestTitle, int interestMatchCount) {
		this.interestID = interestID;
		this.interestTitle = interestTitle;
		this.interestMatchCount = interestMatchCount;
	}

	public int getInterestID() {
		return interestID;
	}

	public void setInterestID(int interestID) {
		this.interestID = interestID;
	}

	public String getInterestTitle() {
		return interestTitle;
	}

	public void setInterestTitle(String interestTitle) {
		this.interestTitle = interestTitle;
	}

	public int getInterestMatchCount() {
		return interestMatchCount;
	}

	public void setInterestMatchCount(int interestMatchCount) {
		this.interestMatchCount = interestMatchCount;
	}
}
