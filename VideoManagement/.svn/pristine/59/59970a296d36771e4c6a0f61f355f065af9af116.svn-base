package com.videoManagement.longThread;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	private Connection ct = null;
	public Connection getConn(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://180.84.33.77:1433;databaseName=videoManagement";
			String user = "sa";
			String password = "123456";
			ct = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return ct;
	}
}
