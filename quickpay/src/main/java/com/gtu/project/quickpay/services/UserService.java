package com.gtu.project.quickpay.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gtu.project.quickpay.dao.DBService;
import com.gtu.project.quickpay.models.LoggedUser;
import com.gtu.project.quickpay.models.User;

public class UserService {
	public static final String INSERT_USER = "INSERT INTO USERS";
	public static User createUser(long customerId,String password)
	{
		User user = new User(customerId,password);
		String SQL_WHERE_CASE=" VALUES('" +  user.getCustomerId()+ "','" + user.getPassword()+ "')";
		try {
			executeUpdateQuery(INSERT_USER+"(customerId,password)"+SQL_WHERE_CASE);
			System.out.println("inserted values successfully in user table");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to insert values in user table");
			e.printStackTrace();
		}
		return user;
	}
	public static void executeUpdateQuery(String query) throws SQLException,
	ClassNotFoundException {
		Connection con = DBService.getConnection();
		Statement stmt = con.createStatement();
		stmt.execute(query);
		DBService.closeConnection();
	}
	
	
	public static long loginUser(int userId, String password) {
		// TODO Auto-generated method stub
	    String query = "SELECT * FROM users WHERE userId='" + userId + "' && password='" + password+ "'";
	    long customerId = 0;
	    try {
			customerId = executeQuery(query);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerId;
	}
	
	public static long executeQuery(String query) throws ClassNotFoundException,
	SQLException {
		Connection con = DBService.getConnection();
		long customerId = 0;
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			customerId = rs.getLong("customerId");
		}
		DBService.closeConnection();
		return customerId;
	}
	
	public static LoggedUser getDetails(long custID){
		String query =  "select a.balance,a.accountNo,c.firstname,c.lastname,c.email from accounts a, customers c where c.customerId = ' "+custID+" ' AND c.accountNo = a.accountNo";
		return executeDetailsQuery(query);
		
	}
	private static LoggedUser executeDetailsQuery(String query) {
		// TODO Auto-generated method stub
		LoggedUser loggedUser = null;
		Statement stmt = null;
		ResultSet rs = null;
		Connection con = DBService.getConnection();

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				loggedUser = new LoggedUser(rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getLong("accountNo"),rs.getInt("balance"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DBService.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loggedUser;
	}
}

