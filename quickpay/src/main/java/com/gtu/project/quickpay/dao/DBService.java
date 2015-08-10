package com.gtu.project.quickpay.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DBService {
	private static Connection conn = null;
	public static DBService dbService = null;

	public static Connection getConnection(){
		try {
			conn=DBConnection.getDataSource().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block]
			System.out.println("Error in getting connection");
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection() throws SQLException {
		if (conn!=null) {
			conn.close();
			conn = null;
			System.out.println("Connection is closed");
		}
	}
	public static DBService getInstance(){
		if(dbService==null){
			dbService = new DBService();
		}
		return dbService;
	}
}