package com.TravelEnthusiast2.Bean;

public class Experience {
	  private int id;
	  private String title;
	  private String experiencedate;
	  private String experiencetype;
	  private String posteddate;
	  private String description;
	  private int userID;
	  
	public Experience() {
		super();
	}

	public Experience(int id, String title, String experiencedate, String experiencetype, String posteddate,
			String description, int userID) {
		super();
		this.id = id;
		this.title = title;
		this.experiencedate = experiencedate;
		this.experiencetype = experiencetype;
		this.posteddate = posteddate;
		this.description = description;
		this.userID = userID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getExperiencedate() {
		return experiencedate;
	}

	public void setExperiencedate(String experiencedate) {
		this.experiencedate = experiencedate;
	}

	public String getExperiencetype() {
		return experiencetype;
	}

	public void setExperiencetype(String experiencetype) {
		this.experiencetype = experiencetype;
	}

	public String getPosteddate() {
		return posteddate;
	}

	public void setPosteddate(String posteddate) {
		this.posteddate = posteddate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	} 
}
