package com.gtu.project.quickpay.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
	private static DataSource dataSource = null;
	
	public static DataSource getDataSource(){
		try {
			Context initContext = new InitialContext();
			Context envContext =(Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/whatever");
			System.out.println("got JNDI:"+dataSource);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("datasource not found");
			e.printStackTrace();
		}
		return dataSource;
	}

}
