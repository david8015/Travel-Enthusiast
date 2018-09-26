package com.TravelEnthusiast2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.TravelEnthusiast2.Bean.*;
import com.TravelEnthusiast2.Connection.MYSQLConnection;

public class EventDataDAO {

	public List<EventData> getEventsByExperienceTitle(String experienceTitle) {

		List<EventData> eventByExpTitle = new ArrayList<EventData>();
		// declare global variable sql
		String sql = "select event.id, username, event.event_title, image, date_format(event.posted_date, '%M %e, %Y') as 'posted date', event.description, "
				+ "date_format(event.event_date, '%M %e, %Y') as 'event date'" + " from user"
				+ " join Experience on user.id = experience.user_id"
				+ " join event on Experience.id = event.experience_id" + " join picture on picture.event_id = event.id"
				+ " where Experience.title like ? ";

		// set database connection to null (no connection)
		Connection conn = null;

		// catch exception
		try {
			// initiate database connection
			conn = MYSQLConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + experienceTitle + "%");
			stmt.executeQuery();

			// capture results from query
			ResultSet rs = stmt.executeQuery();

			// add each experience to the experience list
			while (rs.next()) {
				EventData row = new EventData();
				row.setEventId(rs.getInt("event.id"));
				row.setUserName(rs.getString("username"));
				row.setEventTitle(rs.getString("event.event_title"));
				row.setEventImage(rs.getString("image"));
				row.setEventPostedDate(rs.getString("posted date"));
				row.setEventDescription(rs.getString("event.description"));
				row.setEventDate(rs.getString("event date"));

				eventByExpTitle.add(row);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// close connection
				if (!conn.equals(null)) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// return the list of experiences
		return eventByExpTitle;
	}

	
	
	public List<EventData> getEventDataByEventID(int eventID) {

		List<EventData> ed = new ArrayList<EventData>();
		// declare global variable sql
		String sql = "select event.id, username, event.event_title, image, date_format(event.posted_date, '%M %e, %Y') as 'posted date', event.description, "
				+ "date_format(event.event_date, '%M %e, %Y') as 'event date'" + " from user"
				+ " join Experience on user.id = experience.user_id"
				+ " join event on Experience.id = event.experience_id" + " join picture on picture.event_id = event.id"
				+ " where event.id = ? ";

		// set database connection to null (no connection)
		Connection conn = null;

		// catch exception
		try {
			// initiate database connection
			conn = MYSQLConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, eventID);
			stmt.executeQuery();

			// capture results from query
			ResultSet rs = stmt.executeQuery();

			// add each experience to the experience list
			while (rs.next()) {
				EventData row = new EventData();
				row.setEventId(rs.getInt("event.id"));
				row.setUserName(rs.getString("username"));
				row.setEventTitle(rs.getString("event.event_title"));
				row.setEventImage(rs.getString("image"));
				row.setEventPostedDate(rs.getString("posted date"));
				row.setEventDescription(rs.getString("event.description"));
				row.setEventDate(rs.getString("event date"));
				
				ed.add(row);			
				
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// close connection
				if (!conn.equals(null)) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// return the list of experiences
		return ed;
	}
	
	
	

	public int addEventData(Event x, int expID, Picture p) {
		int c = 0;
		// set connection to null (no connection)
		Connection conn = null;
		int b = 0;

		try {
			// initiate oracle connection
			conn = MYSQLConnection.getConnection();
			// query the database
			String sql = "insert into Event "
					+ "(event_title, event_type, airline, airline_rating, hotel, hotel_rating, description, other_recommendations, event_date, experience_id) "
					+ "values " + "(?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, x.getEventTitle());
			stmt.setString(2, x.getEventType());
			stmt.setString(3, x.getAirline());
			stmt.setString(4, x.getAirlineRating());
			stmt.setString(5, x.getHotel());
			stmt.setString(6, x.getHotelRating());
			stmt.setString(7, x.getEventDescription());
			stmt.setString(8, x.getOtherRecommendations());
			stmt.setString(9, x.getEventDate());
			stmt.setInt(10, expID);

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				b = rs.getInt(1);
			}
			// capture exceptions
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close connection
			if (!conn.equals(null)) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		try {
			// initiate oracle connection
			conn = MYSQLConnection.getConnection();
			// query the database
			String sql = "insert into picture (title, image, picture_of, photo_date, landmark, description, event_id) values "
					+ "(?,?,?,?,?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, p.getPictureTitle());
			stmt.setString(2, p.getImage());
			stmt.setString(3, p.getPicture_of());
			stmt.setString(4, p.getPhoto_date());
			stmt.setBoolean(5, p.isLandmark());
			stmt.setString(6, p.getPictureDescription());
			stmt.setInt(7, b);

			c = stmt.executeUpdate();

			// capture exceptions
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close connection
			if (!conn.equals(null)) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return c;
	}

}
