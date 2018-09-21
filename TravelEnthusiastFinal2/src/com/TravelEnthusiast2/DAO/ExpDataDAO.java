package com.TravelEnthusiast2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TravelEnthusiast2.Bean.*;
import com.TravelEnthusiast2.Connection.MYSQLConnection;

public class ExpDataDAO {

	public List<ExpData> getAllExperience() {
		List<ExpData> allExp = new ArrayList<ExpData>();
		// declare global variable sql
		String sql = "select username, experience.title, image, date_format(posted_date, '%M %e, %Y') as 'posted date', "
				+ " experience.description, date_format(experience_date, '%M %e, %Y') as 'experience Date'"
				+ " from user" + " join Experience on user.id = experience.user_id"
				+ " join picture on picture.experience_id = experience.id ";

		// set database connection to null (no connection)
		Connection conn = null;

		// catch exception
		try {
			// initiate database connection
			conn = MYSQLConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			// capture results from query
			ResultSet rs = ps.executeQuery();

			// add each experience to the experience list
			while (rs.next()) {
				ExpData row = new ExpData();
				row.setUsername(rs.getString("username"));
				row.setTitle(rs.getString("experience.title"));
				row.setImage(rs.getString("image"));
				row.setPosted_date(rs.getString("posted date"));
				row.setDescription(rs.getString("experience.description"));
				row.setExperienceDate(rs.getString("experience Date"));

				allExp.add(row);
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
		return allExp;
	}
	
	
	public List<ExpData> getExperienceByTitle(String title){

	List<ExpData> expByTitle = new ArrayList<ExpData>();
	// declare global variable sql
	String sql = "select username, experience.title, image, date_format(posted_date, '%M %e, %Y') as 'posted date', " +
		    " experience.description, date_format(experience_date, '%M %e, %Y') as 'experience Date'" + 
			" from user" + 
			" join Experience on user.id = experience.user_id" + 
			" join picture on picture.experience_id = experience.id" + 
			" where experience.title like ? ";

	// set database connection to null (no connection)
	Connection conn = null;

	// catch exception
	try
	{
		// initiate database connection
		conn = MYSQLConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + title + "%");
		stmt.executeQuery();

		// capture results from query
		ResultSet rs = stmt.executeQuery();

		// add each experience to the experience list
		while (rs.next()) {
			ExpData row = new ExpData();
			row.setUsername(rs.getString("username"));
			row.setTitle(rs.getString("experience.title"));
			row.setImage(rs.getString("image"));
			row.setPosted_date(rs.getString("posted date"));
			row.setDescription(rs.getString("experience.description"));
			row.setExperienceDate(rs.getString("experience Date"));

			expByTitle.add(row);
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
	return expByTitle;
	}
	
	public List<ExpData> getExperienceByUser(String userName){

	List<ExpData> expByUser = new ArrayList<ExpData>();
	// declare global variable sql
	String sql = "select username, experience.id, experience.title, image, date_format(posted_date, '%M %e, %Y') as 'posted date', experience.description, " +
			" date_format(experience_date, '%M %e, %Y') as 'experience Date'" + 
			" from user" + 
			" join Experience on user.id = experience.user_id" + 
			" join picture on picture.experience_id = experience.id" + 
			" where username like ? ";

	// set database connection to null (no connection)
	Connection conn = null;

	// catch exception
	try
	{
		// initiate database connection
		conn = MYSQLConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + userName + "%");
		stmt.executeQuery();

		// capture results from query
		ResultSet rs = stmt.executeQuery();

		// add each experience to the experience list
		while (rs.next()) {
			ExpData row = new ExpData();
			row.setExperienceID(rs.getInt("experience.id"));
			row.setUsername(rs.getString("username"));
			row.setTitle(rs.getString("experience.title"));
			row.setImage(rs.getString("image"));
			row.setPosted_date(rs.getString("posted date"));
			row.setDescription(rs.getString("experience.description"));
			row.setExperienceDate(rs.getString("experience Date"));

			expByUser.add(row);
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
	return expByUser;
	}
}