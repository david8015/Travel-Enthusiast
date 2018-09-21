package com.TravelEnthusiast2.Bean;

public class Comments {
	public String userName;
	public String description;
	public String postedDate;
	
	public Comments() {
		super();
	}

	public Comments(String userName, String description, String postedDate) {
		super();
		this.userName = userName;
		this.description = description;
		this.postedDate = postedDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}

}
