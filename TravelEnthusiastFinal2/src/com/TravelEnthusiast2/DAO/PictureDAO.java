package com.TravelEnthusiast2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TravelEnthusiast2.Bean.*;
import com.TravelEnthusiast2.Connection.MYSQLConnection;

public class PictureDAO {
	public List<Picture> getAllPictures() {
		List<Picture> allPictures = new ArrayList<Picture>();
		// declare global variable sql
		String sql = "Select * from picture ";

		// set database connection to null (no connection)
		Connection conn = null;

		// catch exception
		try {
			// initiate database connection
			conn = MYSQLConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			// capture results from query
			ResultSet rs = ps.executeQuery();

			// add each picture to courses lists
			while (rs.next()) {
				Picture row = new Picture();
				row.setId(rs.getInt("id"));
				row.setImage(rs.getString("image"));
				row.setPicture_of(rs.getString("picture_of"));
				row.setPhoto_date(rs.getString("photo_date"));
				row.setLandmark(rs.getBoolean("landmark"));
				row.setDescription(rs.getString("description"));

				allPictures.add(row);
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

		// return the list of all pictures
		return allPictures;
	}
	
	public int AddPicture(Picture u, int b) {
		int a =0;
		// set connection to null (no connection)
				Connection conn = null;
				try {
					// initiate oracle connection
					conn = MYSQLConnection.getConnection();
					// query the database
					String sql = "insert into picture (title, image, picture_of, photo_date, landmark, description, experience_id) values "
							+ "(?,?,?,?,?,?,?)";

					PreparedStatement stmt = conn.prepareStatement(sql);

					stmt.setString(1, u.getTitle());
					stmt.setString(2, u.getImage());
					stmt.setString(3, u.getPicture_of());
					stmt.setString(4, u.getPhoto_date());
					stmt.setBoolean(5, u.isLandmark());
					stmt.setInt(6, b);

					a = stmt.executeUpdate();
//					conn.commit();
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
