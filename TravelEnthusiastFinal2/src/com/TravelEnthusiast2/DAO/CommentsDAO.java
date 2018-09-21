package com.TravelEnthusiast2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TravelEnthusiast2.Bean.Comments;
import com.TravelEnthusiast2.Connection.MYSQLConnection;

public class CommentsDAO {
	public List<Comments> getCommentsByExpTitle(String expTitle){
		List<Comments> commentsByExpTitle = new ArrayList<Comments>();
		// declare global variable sql
		String sql = "select username, comments.description, date_format (comments.posted_date, '%M %e, %Y' ) as 'posted date'" + 
				" from user" + 
				" join comments on user.id = comments.user_id" + 
				" join event on event.id = comments.event_id" + 
				" join experience on event.experience_id = Experience.ID" + 
				" where Experience.title like ?";

		// set database connection to null (no connection)
		Connection conn = null;

		// catch exception
		try
		{
			// initiate database connection
			conn = MYSQLConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + expTitle + "%");
			stmt.executeQuery();

			// capture results from query
			ResultSet rs = stmt.executeQuery();

			// add each experience to the experience list
			while (rs.next()) {
				Comments row = new Comments();
				row.setUserName(rs.getString("username"));
				row.setPostedDate(rs.getString("posted date"));
				row.setDescription(rs.getString("comments.description"));

				commentsByExpTitle.add(row);
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
		return commentsByExpTitle;
		}
	public List<Comments> getCommentsByEventTitle(String eventTitle){
		List<Comments> commentsByEventTitle = new ArrayList<Comments>();
		// declare global variable sql
		String sql = "select username, comments.description, date_format (comments.posted_date, '%M %e, %Y' ) as 'posted date'" + 
				" from user" + 
				" join comments on user.id = comments.user_id" + 
				" join event on event.id = comments.event_id" + 
				" where event.event_title like ?";

		// set database connection to null (no connection)
		Connection conn = null;

		// catch exception
		try
		{
			// initiate database connection
			conn = MYSQLConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + eventTitle + "%");
			stmt.executeQuery();

			// capture results from query
			ResultSet rs = stmt.executeQuery();

			// add each experience to the experience list
			while (rs.next()) {
				Comments row = new Comments();
				row.setUserName(rs.getString("username"));
				row.setPostedDate(rs.getString("posted date"));
				row.setDescription(rs.getString("comments.description"));

				commentsByEventTitle.add(row);
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
		return commentsByEventTitle;
		}

}
