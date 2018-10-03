/**
 * Imports 
 */
package com.TravelEnthusiast2.Bean;

/**
 * @author david H
 *
 */
public class Event {
	private int eventId;
	private String eventTitle;
	private String eventType;
	private String airline;
	private String airlineRating;
	private String hotel;
	private String hotelRating;
	private String eventDescription;
	private String otherRecommendations;
	private String eventDate;
	
	
	/**
	 * Default Constructor
	 */
	public Event() {
		super();
	}
	
	/**
	 * @param eventId
	 * @param eventTitle
	 * @param eventType
	 * @param airline
	 * @param airlineRating
	 * @param hotel
	 * @param hotelRating
	 * @param eventDescription
	 * @param otherRecommendations
	 * @param eventDate
	 */
	public Event(int eventId, String eventTitle, String eventType, String airline, String airlineRating, String hotel,
			String hotelRating, String eventDescription, String otherRecommendations, String eventDate) {
		super();
		this.eventId = eventId;
		this.eventTitle = eventTitle;
		this.eventType = eventType;
		this.airline = airline;
		this.airlineRating = airlineRating;
		this.hotel = hotel;
		this.hotelRating = hotelRating;
		this.eventDescription = eventDescription;
		this.otherRecommendations = otherRecommendations;
		this.eventDate = eventDate;
	}

	/**
	 * @return the eventId
	 */
	public int getEventId() {
		return eventId;
	}
	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	/**
	 * @return the eventTitle
	 */
	public String getEventTitle() {
		return eventTitle;
	}
	/**
	 * @param eventTitle the eventTitle to set
	 */
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}
	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	/**
	 * @return the airline
	 */
	public String getAirline() {
		return airline;
	}
	/**
	 * @param airline the airline to set
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}
	/**
	 * @return the airlineRating
	 */
	public String getAirlineRating() {
		return airlineRating;
	}
	/**
	 * @param airlineRating the airlineRating to set
	 */
	public void setAirlineRating(String airlineRating) {
		this.airlineRating = airlineRating;
	}
	/**
	 * @return the hotel
	 */
	public String getHotel() {
		return hotel;
	}
	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	/**
	 * @return the hotelRating
	 */
	public String getHotelRating() {
		return hotelRating;
	}
	/**
	 * @param hotelRating the hotelRating to set
	 */
	public void setHotelRating(String hotelRating) {
		this.hotelRating = hotelRating;
	}
	/**
	 * @return the eventDescription
	 */
	public String getEventDescription() {
		return eventDescription;
	}
	/**
	 * @param eventDescription the eventDescription to set
	 */
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	/**
	 * @return the otherRecommendations
	 */
	public String getOtherRecommendations() {
		return otherRecommendations;
	}
	/**
	 * @param otherRecommendations the otherRecommendations to set
	 */
	public void setOtherRecommendations(String otherRecommendations) {
		this.otherRecommendations = otherRecommendations;
	}
	/**
	 * @return the eventDate
	 */
	public String getEventDate() {
		return eventDate;
	}
	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
}
