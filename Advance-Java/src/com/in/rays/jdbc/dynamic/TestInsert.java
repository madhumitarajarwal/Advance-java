package com.in.rays.jdbc.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.in.rays.bean.MarksheetBean;

public class TestInsert {
	public static void main(String[] args)throws Exception{
		MarksheetBean bean=new MarksheetBean();
		bean.setId(14);
		bean.setRollNo(104);
		bean.setName("mrbean");
		bean.setChemistry(44);
		bean.setPhysics(45);
		bean.setMaths(80);
		testInsert4(bean);
		//testInsert1();
		//testInsert2();
		//testInsert3(22,102,"jjj",40,60,70);
	}
	public static void testInsert1()throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
        PreparedStatement pre=conn.prepareStatement("insert into marksheet values(6,101,'uvw',90,70,60)");
        int i=pre.executeUpdate();
        System.out.println("value inserted=>"+i);
	}
	public static void testInsert2()throws Exception{
		 Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	        PreparedStatement p=conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
	        p.setInt(1, 20);
	        p.setInt(2,101);
	        p.setString(3,"malti");
	        p.setInt(4, 50);
	        p.setInt(5,50);
	        p.setInt(6, 50);
	        int i=p.executeUpdate();
	        System.out.println("data inserted"+i);
	}
	
	public static void testInsert3(int id,int rollNo,String name,int physic,int chemistry,int maths)throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
        PreparedStatement p=conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
        p.setInt(1,id);
        p.setInt(2,rollNo);
        p.setString(3, name);
        p.setInt(4, physic);
        p.setInt(5, chemistry);
        p.setInt(6, maths);
        int i=p.executeUpdate();
        System.out.println("data inserted"+i);
        
		
	}
	public static void testInsert4(MarksheetBean bean) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
        PreparedStatement p=conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
        p.setInt(1,bean.getId());
        p.setInt(2, bean.getRollNo());
        p.setString(3,bean.getName());
        p.setInt(4,bean.getPhysics());
        p.setInt(5,bean.getChemistry());
        p.setInt(6,bean.getMaths());
        int i= p.executeUpdate();
        System.out.println("inset updated =>"+i);
	}
	

}
