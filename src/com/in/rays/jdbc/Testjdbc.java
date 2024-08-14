package com.in.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Testjdbc {
    public static void main(String[] args) throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver"); //class loader
    	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java","root","root");
    	Statement stm=conn.createStatement();//query execute
    	//int i=stm.executeUpdate("insert into user values(10,'sqw',6700)");
    	//int u=stm.executeUpdate("update user set name='zzz' where id=1");
    	//System.out.println("data inserted"+i);
    	//System.out.println("data update"+u);
    	//int d=stm.executeUpdate("delete from user where name='zzz'");
    	//System.out.println("data delete"+d);
    	int a=stm.executeUpdate("alter table user add grade int");
    	System.out.println("data alter"+a);
    	
    	
    	
    }
}
