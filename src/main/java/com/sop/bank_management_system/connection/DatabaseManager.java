package com.sop.bank_management_system.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	public static Connection getConnection() {
		String url="jdbc:postgresql://localhost:5432/bank-management-system";
		String user="postgres";
		String password="Master@123";
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
