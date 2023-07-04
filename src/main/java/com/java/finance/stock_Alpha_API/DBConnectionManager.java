package com.java.finance.stock_Alpha_API;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionManager {
	
	public static Connection ConnectToDB() throws Exception {
	      //Registering the Driver
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

	      //Getting the connection
	      String sqlUrl = "jdbc:sqlserver://portfoliorecomendation.database.windows.net;databaseName=Portfolio";
	      Connection con = DriverManager.getConnection(sqlUrl, "PortRecom", "Portfolio@007");
	      System.out.println("Connection established......");
	      return con;
	   }

}
