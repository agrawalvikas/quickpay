package com.gtu.project.quickpay.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.gtu.project.quickpay.dao.DBService;
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
}

