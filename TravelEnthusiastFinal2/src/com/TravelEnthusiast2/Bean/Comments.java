package com.TravelEnthusiast2.Bean;

public class Comments {
	public String userName;
	public String commentsDescription;
	public String postedDate;
	
	public Comments() {
		super();
	}

	public Comments(String userName, String commentsDescription, String postedDate) {
		super();
		this.userName = userName;
		this.commentsDescription = commentsDescription;
		this.postedDate = postedDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCommentsDescription() {
		return commentsDescription;
	}

	public void setCommentsDescription(String commentsDescription) {
		this.commentsDescription = commentsDescription;
	}

	public String getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}

}
