package com.digit.javaTraining.CRSApp;

import java.sql.Connection;
import java.sql.DriverManager;

public class Helper {
	private static Connection conn;
	private static String userName = "root";
	private static String password = "Phani@123";
	private static String url = "jdbc:mysql://localhost:3306/crs";

	public static Connection getConnectionInstance() {
		if (conn == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, userName, password);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return conn;
	}
}
