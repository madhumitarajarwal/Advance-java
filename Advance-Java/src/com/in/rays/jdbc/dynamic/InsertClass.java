package com.in.rays.jdbc.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.in.rays.bean.MarksheetBean;

public class InsertClass {
	public static void main(String[] args)throws Exception{
		MarksheetBean b=new MarksheetBean();
		b.setId(2);
		b.setRollNo(102);
		b.setName("piyush");
		b.setChemistry(50);
		b.setMaths(70);
		b.setPhysics(60);
		InsertData(b);
		
	}
		public static void InsertData(MarksheetBean bean)throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		PreparedStatement s=conn.prepareStatement("insert into marksheet1 values(?,?,?,?,?,?)");
	     s.setInt(1,bean.getId());
	     s.setInt(2,bean.getRollNo());
	     s.setString(3,bean.getName());
	     s.setInt(4,bean.getPhysics());
	     s.setInt(5,bean.getChemistry());
	     s.setInt(6,bean.getMaths());
	     int i=s.executeUpdate();
	     System.out.println("data inserted ==>"+i);
		
	}

}
