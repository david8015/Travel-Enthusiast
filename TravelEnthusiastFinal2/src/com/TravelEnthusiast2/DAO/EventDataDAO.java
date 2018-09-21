package com.TravelEnthusiast2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TravelEnthusiast2.Bean.*;
import com.TravelEnthusiast2.Connection.MYSQLConnection;

public class EventDataDAO {

	public List<EventData> getEventsByExperienceTitle(String experienceTitle){

		List<EventData> eventByExpTitle = new ArrayList<EventData>();
		// declare global variable sql
		String sql = "select username, event.event_title, image, date_format(event.posted_date, '%M %e, %Y') as 'posted date', event.description, "
				+ "date_format(event.event_date, '%M %e, %Y') as 'event date'" + 
				" from user" + 
				" join Experience on user.id = experience.user_id" + 
				" join event on Experience.id = event.experience_id" + 
				" join picture on picture.event_id = event.id" + 
				" where Experience.title like ? ";

		// set database connection to null (no connection)
		Connection conn = null;

		// catch exception
		try
		{
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
				row.setUserName(rs.getString("username"));
				row.setEventTitle(rs.getString("event.event_title"));
				row.setEventImage(rs.getString("image"));
				row.setEventPostedDate(rs.getString("posted date"));
				row.setEventDescription(rs.getString("event.description"));
				row.setEventDate(rs.getString("event date"));

				eventByExpTitle.add(row);
			}

		}catch(
		Exception e)
		{
			e.printStackTrace();
		}finally
		{
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
}
