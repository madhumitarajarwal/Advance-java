package com.in.rays.txn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransaction {
   public static void main(String[] args) throws Exception {
	
	   Connection conn=null;
	   try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		  conn.setAutoCommit(false);
		  Statement stmt=conn.createStatement();
		  int i = stmt.executeUpdate("insert into marksheet values(22, 'aryant', 89, 22, 34,34)");

			i = stmt.executeUpdate("insert into marksheet values(23, 'aryant', 89, 22, 34,32)");

			i = stmt.executeUpdate("insert into marksheet values(24, 'aryant', 89, 22, 34,22)");
            conn.commit();
            System.out.println("data inserted =>"+i);
            
	   }catch(Exception e) {
		   
		   conn.rollback();
			System.out.println("exception: " + e.getMessage()); 
		   
	   } finally {
			conn.close();
		}
	   
}
}
