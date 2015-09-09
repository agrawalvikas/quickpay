package com.gtu.project.quickpay.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gtu.project.quickpay.dao.DBService;
import com.gtu.project.quickpay.models.Account;
public class AccountService {

	public static final String GET_ACCOUNT = "SELECT * FROM ACCOUNTS";
	public static final String INSERT_USER = "INSERT INTO ACCOUNTS";


	public static List<Account> getAllAccounts(){
		List<Account> all = new ArrayList<Account>();
		try {
			all = executeQuery(GET_ACCOUNT);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("here is the problem");
			e.printStackTrace();
		}
		return all;
	}
	
	public static List<Account> executeQuery(String query) throws ClassNotFoundException,
	SQLException {
		Connection con = DBService.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		List<Account> als = convertPojoList(rs);
		DBService.closeConnection();
		return als;
	}

	private static List<Account> convertPojoList(ResultSet rs) throws SQLException {
		List<Account> asl = new ArrayList<Account>();
		while (rs.next()) {
			Account account  = new Account(rs.getInt("accountNo"),rs.getInt("balance"),rs.getInt("pin"),rs.getString("cardID"));
			asl.add(account);
		}
		return asl;
	}
	public static Account createAccount(int balance,int pin,String cardId){
		Account account = new Account(balance,pin,cardId);
		String SQL_WHERE_CASE=" VALUES('" + account.getAccountId() + "','" + account.getBalance() + "','" + account.getPin() + "','" + account.getCardId() + "')";
		try {
			executeUpdateQuery(INSERT_USER+SQL_WHERE_CASE);
			System.out.println("inserted values successfully");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to insert values");
			e.printStackTrace();
		}
		return account;
	}
	public static void executeUpdateQuery(String query) throws SQLException,
	ClassNotFoundException {
		Connection con = DBService.getConnection();
		Statement stmt = con.createStatement();
		stmt.execute(query);
		DBService.closeConnection();
	}
}
