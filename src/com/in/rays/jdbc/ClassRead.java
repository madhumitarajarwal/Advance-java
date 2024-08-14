package com.in.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClassRead {
    public static void main(String[]args)throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java","root","root");
    	Statement stmt=conn.createStatement();
    	ResultSet rs=stmt.executeQuery("select * from emp");
    	while(rs.next()) {
    		
    		System.out.print(rs.getInt(1));
    		System.out.println(" "+rs.getString(2));
    	}
    }
}
