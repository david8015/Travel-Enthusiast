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

public class ExperienceDAO {

	public List<Experience> getAllExperience() {
		List<Experience> allExperience = new ArrayList<Experience>();
		// declare global variable sql
		String sql = "Select * from experience ";

		// set database connection to null (no connection)
		Connection conn = null;

		// catch exception
		try {
			// initiate database connection
			conn = MYSQLConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			// capture results from query
			ResultSet rs = ps.executeQuery();

			// add each course to courses lists
			while (rs.next()) {
				Experience row = new Experience();
				row.setId(rs.getInt("id"));
				row.setTitle(rs.getString("title"));
				row.setExperiencedate(rs.getString("experience_date"));
				row.setExperiencetype(rs.getString("experience_type"));
				row.setPosteddate(rs.getString("posted_date"));
				row.setDescription(rs.getString("description"));

				allExperience.add(row);
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

		// return the list of all users
		return allExperience;

	}
	
	public List<Experience> getExperienceByUser(String userName) {
		List<Experience> allExpByUser = new ArrayList<Experience>();
		// declare global variable sql
		String sql = "select experience.ID, title, experience_date, experience_type, posted_date, description, user_id" + 
				" from experience" + 
				" join user on user.id = experience.user_id" + 
				" where username like ?";

		// set database connection to null (no connection)
		Connection conn = null;

		// catch exception
		try {
			// initiate database connection
			conn = MYSQLConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + userName + "%");

			// capture results from query
			ResultSet rs = ps.executeQuery();

			// add each course to courses lists
			while (rs.next()) {
				Experience row = new Experience();
				row.setId(rs.getInt("experience.ID"));
				row.setTitle(rs.getString("title"));
				row.setExperiencedate(rs.getString("experience_date"));
				row.setExperiencetype(rs.getString("experience_type"));
				row.setPosteddate(rs.getString("posted_date"));
				row.setDescription(rs.getString("description"));
				row.setUserID(rs.getInt("user_id"));

				allExpByUser.add(row);
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

		// return the list of all users
		return allExpByUser;

	}
	
	public int addExperience(Experience x, int userID) {
		// set connection to null (no connection)
		Connection conn = null;
//		ResultSet generatedExpPriKey = null;
		
//		List<Integer> a = new ArrayList<Integer>();
		int a = 0;

		try {
			// initiate oracle connection
			conn = MYSQLConnection.getConnection();
			// query the database
			String sql = "insert into Experience " + 
					"(title, experience_Date, experience_Type, description, user_id) values "
					+ "(?,?,?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, x.getTitle());
			stmt.setString(2, x.getExperiencedate());
			stmt.setString(3, x.getExperiencetype());
			stmt.setString(4, x.getDescription());
			stmt.setInt(5, userID);

			stmt.executeUpdate();	
			
			ResultSet rs = stmt.getGeneratedKeys();
	            if(rs != null && rs.next()){
//	                System.out.println("Generated Experience Id: "+ rs.getInt(1));
	                a = rs.getInt(1);
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
		return a;
	}
}
