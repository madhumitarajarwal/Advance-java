package com.in.rays.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestStoreFunction {
 public static void main(String[] args) throws Exception {
	 Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
		CallableStatement stmt=conn.prepareCall("{? = CALL square(?)}");
		stmt.setInt(2,10);
		stmt.registerOutParameter(1,Types.INTEGER);
		stmt.execute();
		System.out.println("square"+stmt.getInt(1));
	
}
}
