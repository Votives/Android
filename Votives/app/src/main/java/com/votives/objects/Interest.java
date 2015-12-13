package com.votives.objects;

/**
 * Created by darkbobo on 12/13/15.
 */
public class Interest {
	private String interestTitle;
	private int interestMatchCount;

	public Interest() {
	}

	public Interest(String interestTitle, int interestMatchCount){
		setInterestTitle(interestTitle);
		setInterestMatchCount(interestMatchCount);
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
