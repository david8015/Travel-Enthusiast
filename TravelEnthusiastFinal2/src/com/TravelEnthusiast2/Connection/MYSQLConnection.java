package com.TravelEnthusiast2.Connection;

import java.sql.*;
import java.sql.DriverManager;

public class MYSQLConnection {
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/TravelEnthusiast?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "root";
		String password = "23641471";

		conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
}
