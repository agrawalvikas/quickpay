package com.gtu.project.quickpay.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.gtu.project.quickpay.dao.DBService;
import com.gtu.project.quickpay.models.Customer;

public class CustomerService {
	public static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMERS";
	public static Customer createCustomer(String firstName,String middleName,String lastName,String gender,
			String address,int pincode,long phone,String email,
			long accountId)
	{
		Customer customer = new Customer(firstName,middleName, lastName,gender,
			address,pincode,phone,email,accountId);
		
		String SQL_WHERE_CASE=" VALUES('" + customer.getCustomerId()+ "','" + customer.getFirstName() + "','" 
			+ customer.getMiddleName() + "','" + customer.getLastName() + "','" + customer.getGender() + "'"
			+ ",'" + customer.getAddress() + "','" + customer.getPincode() + "','" + customer.getPhone() 
			+ "','" + customer.getEmail()+ "','" + customer.getAccountId() + "')";
		
		
		try {
			executeUpdateQuery(INSERT_CUSTOMER+SQL_WHERE_CASE);
			System.out.println("inserted values successfully in customer table");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to insert values in customer table");
			e.printStackTrace();
		}
		return customer;
	}
	public static void executeUpdateQuery(String query) throws SQLException,
	ClassNotFoundException {
		Connection con = DBService.getConnection();
		Statement stmt = con.createStatement();
		stmt.execute(query);
		DBService.closeConnection();
	}
}
