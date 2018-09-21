package com.TravelEnthusiast2.Bean;

public class EventData {
	private String userName;
	private String eventTitle;
	private String eventImage;
	private String eventPostedDate;
	private String eventDescription;
	private String eventDate;

	public EventData() {
		super();
	}

	public EventData(String userName, String eventTitle, String eventImage, String eventPostedDate,
			String eventDescription, String eventDate) {
		super();
		this.userName = userName;
		this.eventTitle = eventTitle;
		this.eventImage = eventImage;
		this.eventPostedDate = eventPostedDate;
		this.eventDescription = eventDescription;
		this.eventDate = eventDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventImage() {
		return eventImage;
	}

	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}

	public String getEventPostedDate() {
		return eventPostedDate;
	}

	public void setEventPostedDate(String eventPostedDate) {
		this.eventPostedDate = eventPostedDate;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
}
