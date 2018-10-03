package com.TravelEnthusiast2.Bean;

public class ExpData {
	
	private int experienceID;
	private String username;
	private String title;
	private String image;
	private String posted_date;
	private String description;
	private String experienceDate;
	

	public ExpData() {
		super();
	}


	public ExpData(int experienceID, String username, String title, String image, String posted_date, String description,
			String experienceDate) {
		super();
		this.experienceID = experienceID;
		this.username = username;
		this.title = title;
		this.image = image;
		this.posted_date = posted_date;
		this.description = description;
		this.experienceDate = experienceDate;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getPosted_date() {
		return posted_date;
	}


	public void setPosted_date(String posted_date) {
		this.posted_date = posted_date;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getExperienceDate() {
		return experienceDate;
	}


	public void setExperienceDate(String experienceDate) {
		this.experienceDate = experienceDate;
	}


	public int getExperienceID() {
		return experienceID;
	}


	public void setExperienceID(int experienceID) {
		this.experienceID = experienceID;
	}


}
