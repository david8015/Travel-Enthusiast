package com.TravelEnthusiast2.DAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.TravelEnthusiast2.Bean.*;
import com.TravelEnthusiast2.Connection.*;

public class UserDAO{
	
	
	public User getUserByUserName(String userName) {
		// declare variables
		User s = null;
		// set connection to null (no connection)
		Connection conn = null;

		try {
			// initiate oracle connection
			conn = MYSQLConnection.getConnection();
			// query the database
			String sql = "select * from user where username =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);
			stmt.executeQuery();

			// capture result of query
			ResultSet rs = stmt.executeQuery();
			// save results of query

//				System.out.println("TEST");
			while (rs.next()) {

				s = new User(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"),
						rs.getString("username"), rs.getString("password"), rs.getString("country"), rs.getInt("userType"));
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

		// return User
		return s;
	}

	public int RegisterUser(User u) {
		int register = 0;
		
		// set connection to null (no connection)
		Connection conn = null;

		try {
			// initiate oracle connection
			conn = MYSQLConnection.getConnection();
			// query the database
			String sql = "insert into user (firstname, lastname, email, username, password, country) values "
					+ "(?,?,?,?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getLastName());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getUserName());
			stmt.setString(5, u.getPassword());
			stmt.setString(6, u.getCountry());

			register = stmt.executeUpdate();
//			conn.commit();
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
		return register;
	}

	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<User>();
		// declare global variable sql
		String sql = "Select * from user ";

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
				User row = new User();
				row.setUserID(rs.getInt("id"));
				row.setFirstName(rs.getString("firstname"));
				row.setLastName(rs.getString("lastname"));
				row.setEmail(rs.getString("email"));
				row.setUserName(rs.getString("username"));
				row.setPassword(rs.getString("password"));
				row.setCountry(rs.getString("country"));

				allUsers.add(row);
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
		return allUsers;
	}

	
	public Boolean deleteUser(String userName) {
		// set connection to null (no connection)
		Connection conn = null;
		Boolean didItDeleteUser = false;

		try {
			// initiate oracle connection
			conn = MYSQLConnection.getConnection();
			// query the database
			String sql = "delete from user where username =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);
			stmt.executeUpdate();
			
			if(stmt.executeUpdate() > 0) {
				didItDeleteUser = true;
			}
			else
				didItDeleteUser = false;

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
		
		return didItDeleteUser;

	}
	
	public boolean validateUser(String pass, String comparablePass) {
		return pass.equals(comparablePass)? true: false;
	}
	
	
	public boolean editUserFName(String fName, int userID) {
		// set connection to null (no connection)
		Connection conn = null;
		
		boolean update = false;

		try {
			// initiate oracle connection
			conn = MYSQLConnection.getConnection();
			
			// query the database
			String sql = "update user " + 
					"set firstname = ? " + 
					"where id = ? ";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, fName);
			stmt.setInt(2, userID);
			stmt.executeUpdate();
			
			if (stmt.executeUpdate() == 1) {
			 update = true;
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

		// return User
		return update;
	}
	
	public boolean editUserLName(String LName, int userID) {
		// set connection to null (no connection)
		Connection conn = null;
		
		boolean update = false;

		try {
			// initiate oracle connection
			conn = MYSQLConnection.getConnection();
			
			// query the database
			String sql = "update user " + 
					"set lastname = ? " + 
					"where id = ? ";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, LName);
			stmt.setInt(2, userID);
			stmt.executeUpdate();
			
			if (stmt.executeUpdate() == 1) {
			 update = true;
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

		// return User
		return update;
	}
	
	public boolean editUserEmail(String Email, int userID) {
		// set connection to null (no connection)
		Connection conn = null;
		
		boolean update = false;

		try {
			// initiate oracle connection
			conn = MYSQLConnection.getConnection();
			
			// query the database
			String sql = "update user " + 
					"set email = ? " + 
					"where id = ? ";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, Email);
			stmt.setInt(2, userID);
			stmt.executeUpdate();
			
			if (stmt.executeUpdate() == 1) {
			 update = true;
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

		// return User
		return update;
	}
	
	public boolean editUserPassword(String Password, int userID) {
		// set connection to null (no connection)
		Connection conn = null;
		
		boolean update = false;

		try {
			// initiate oracle connection
			conn = MYSQLConnection.getConnection();
			
			// query the database
			String sql = "update user " + 
					"set password = ? " + 
					"where id = ? ";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, Password);
			stmt.setInt(2, userID);
			stmt.executeUpdate();
			
			if (stmt.executeUpdate() == 1) {
			 update = true;
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

		// return User
		return update;
	}

	
	public boolean editUserCountry(String Country, int userID) {
		// set connection to null (no connection)
		Connection conn = null;
		
		boolean update = false;

		try {
			// initiate oracle connection
			conn = MYSQLConnection.getConnection();
			
			// query the database
			String sql = "update user " + 
					"set country = ? " + 
					"where id = ? ";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, Country);
			stmt.setInt(2, userID);
			stmt.executeUpdate();
			
			if (stmt.executeUpdate() == 1) {
			 update = true;
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

		// return User
		return update;
	}
}
