package com.in.rays.duplicaterecordexception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class TestMetaData {
 public static void main(String[] args) throws Exception {
	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet1");	
		ResultSet rs=pstmt.executeQuery();
		ResultSetMetaData metaData=rs.getMetaData();
		System.out.println("Catalog Name: " + metaData.getCatalogName(1));

		System.out.println("Table Name: " + metaData.getTableName(1));

		System.out.println("Column Count: " + metaData.getColumnCount());
		
		System.out.println(" rrr:"+ metaData.getColumnName(5));
		System.out.println(" colum type"+metaData.getColumnType(1));
		System.out.println(metaData.getColumnClassName(3));
 }
}
