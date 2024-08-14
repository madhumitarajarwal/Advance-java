package com.in.rays.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestProcedureOut {
  public static void main(String[] args) throws Exception {
	 try {
	  Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
		CallableStatement stmt=conn.prepareCall("{CALL marksheet1Out(?)}");
		stmt.registerOutParameter(1, Types.INTEGER);
		stmt.execute();
		int resultValue = stmt.getInt(1);
		System.out.println("Result from empOut stored procedure: " + resultValue);
  }catch(Exception e) {
	  e.printStackTrace();
  }

}
}
