package com.in.rays.jdbc.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadPrep {
	public static void main(String[] args)throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		PreparedStatement pre=conn.prepareStatement("select * from emp");
		ResultSet rs=pre.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.println(" "+rs.getString(2));
		}
		
	}

}
