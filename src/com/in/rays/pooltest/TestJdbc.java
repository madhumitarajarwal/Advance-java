package com.in.rays.pooltest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.in.rays.util.JDBCDataSource;
import com.in.rays.util.JdbcDataSource;

public class TestJdbc {
 public static void main(String[] args) throws Exception {
	testGet();
}
 

private static void testGet()throws Exception{
	Connection conn = JdbcDataSource.getConnection();
	PreparedStatement stmt=conn.prepareStatement("select * from bank where id=1");
    ResultSet rs=stmt.executeQuery();
    while(rs.next()) {
    	System.out.print(rs.getInt(1));
    	System.out.print("\t"+rs.getString(2));
    	System.out.print("\t"+rs.getString(3));
    	System.out.print("\t"+rs.getString(4));
    	System.out.print("\t"+rs.getString(5));
    	System.out.print("\t"+rs.getDate(6));
    }
    JdbcDataSource.closeConnection(conn);
}
}