package com.in.rays.jdbc.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreateClass {
    public static void main(String[] args)throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
    	//PreparedStatement pt=conn.prepareStatement("create table my_class(id int primary key,name varchar(50))");
    	PreparedStatement wt=conn.prepareStatement("insert into my_class values(1,'madhu')");
    	//int i=wt.executeUpdate();
    	//System.out.println(i);
    	ResultSet rs=wt.executeQuery();
    	while(rs.next()){
    		System.out.println(rs.getInt(1));
    		System.out.println(rs.getString(2));
    	}
    	
    }
}
