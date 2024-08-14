package com.in.rays.jdbc.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteClass {
   public static void main(String[] args) throws Exception{
	   //deletedata(2);
	   //testDelete2();
	   //testDelete1();
   }
   public static void deletedata( int id)throws Exception {
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	     PreparedStatement p=c.prepareStatement("delete from marksheet1 where id=?");
	      p.setInt(1,id);
	      int i=p.executeUpdate();
	      System.out.println("data deleted =>"+i);
	      
   }
   public static void testDelete2() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");

		pstmt.setInt(1, 1);

		int i = pstmt.executeUpdate();

		System.out.println("data deleted => " + i);

	}
   public static void testDelete1() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = 10");

		int i = pstmt.executeUpdate();

		System.out.println("data deleted => " + i);

	}
}
