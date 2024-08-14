package com.in.rays.jdbc.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateClass {
    public static void main(String[] args) throws Exception {
    	updatedata1();
    }
    public static void  updatedata()throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
   PreparedStatement p=c.prepareStatement("update marksheet1 set name='sanju' where id=1");
    	int i=p.executeUpdate();
    	System.out.println("data updated"+i);
    	
    }
    public static void  updatedata1()throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
   PreparedStatement p=c.prepareStatement("update marksheet1 set name=? where id=?");
   p.setInt(1,1);
   p.setString(2,"madhu");
    	int i=p.executeUpdate();
    	System.out.println("data updated"+i);
    	
    }
    
}
