package com.in.rays.test1;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.in.rays.util.DataPool;

public class CustomerModel {
   public void add(CustomerBean bean) throws Exception {
	   Connection conn = DataPool.getConnection();
		PreparedStatement stmt = conn.prepareStatement("insert into customer values(?,?,?,?)");
		stmt.setInt(1,bean.getId());
		stmt.setString(2, bean.getName());
		stmt.setString(3,bean.getCity());
		stmt.setString(4,bean.getDate());
		int i = stmt.executeUpdate();
		 DataPool.closeConnection(conn);
		System.out.println("query updated=>" +i);
		

   }
}
