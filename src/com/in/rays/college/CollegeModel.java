package com.in.rays.college;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.sql.SQLException;

import com.in.rays.bean.UserBean;
import com.in.rays.util.DataPool;

public class CollegeModel {
	public int pk() throws Exception {
		int pk=0;
		Connection conn=DataPool.getConnection();
		PreparedStatement stmt=conn.prepareStatement("select max(id) from college");
		ResultSet r=stmt.executeQuery();
		while(r.next()) {
			pk=(int)r.getLong(1);
		}
		return pk+1;
	}
	public void add(CollegeBean bean) throws Exception {
		int pk=pk();
		Connection conn = DataPool.getConnection();
		PreparedStatement stmt = conn.prepareStatement("insert into college values(?,?,?,?,?,?,?,?,?,?)");
		stmt.setLong(1, pk);
		stmt.setString(2, bean.getName());
		stmt.setString(3, bean.getAddress());
		stmt.setString(4, bean.getState());
		stmt.setString(5, bean.getCity());
		stmt.setString(6, bean.getContact());
		stmt.setString(7, bean.getCreatedBy());
		stmt.setString(8, bean.getModifiedBy());
		stmt.setTimestamp(9, bean.getCreatedDateTime());
		stmt.setTimestamp(10, bean.getModifiedDateTime());
		int i = stmt.executeUpdate();
		DataPool.closeConnection(conn);
		System.out.println("query updated=>" + i);

	}

	public void update(CollegeBean bean) throws Exception {
		Connection conn = DataPool.getConnection();
		PreparedStatement stmt = conn.prepareStatement(
				" update college set name=? ,address=? ,state=? ,city=? ,contact=? , created_by=? ,modified_by=?,created_datetime=?,modified_datetime=? where id=? ");
		stmt.setString(1, bean.getName());
		stmt.setString(2, bean.getAddress());
		stmt.setString(3, bean.getState());
		stmt.setString(4, bean.getCity());
		stmt.setString(5, bean.getContact());
		stmt.setString(6, bean.getCreatedBy());
		stmt.setString(7, bean.getModifiedBy());
		stmt.setTimestamp(8, bean.getCreatedDateTime());
		stmt.setTimestamp(9, bean.getModifiedDateTime());
		stmt.setLong(10, bean.getId());

		int i = stmt.executeUpdate();
		DataPool.closeConnection(conn);
		System.out.println("query updated=>" + i);
	}

	public void delete(long id) throws Exception {
		Connection conn = DataPool.getConnection();
		PreparedStatement stmt = conn.prepareStatement("delete from college where id=?");
		stmt.setLong(1, id);
		int i = stmt.executeUpdate();
		DataPool.closeConnection(conn);
		System.out.println("query deleted=>" + i);
	}

	public CollegeBean findbypk(long id) throws Exception {
		Connection conn = DataPool.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from college where id = ?");
		stmt.setLong(1, id);
		ResultSet r = stmt.executeQuery();
		CollegeBean bean = null;
		while (r.next()) {
			bean = new CollegeBean();
			bean.setId(r.getLong(1));
			bean.setName(r.getString(2));
			bean.setAddress(r.getString(3));
			bean.setState(r.getString(4));
			bean.setCity(r.getString(5));
			bean.setContact(r.getString(6));
			bean.setCreatedBy(r.getString(7));
			bean.setModifiedBy(r.getString(8));
			bean.setCreatedDateTime(r.getTimestamp(9));
			bean.setModifiedDateTime(r.getTimestamp(10));
		}
		DataPool.closeConnection(conn);
		return bean;

	}

	public List search(CollegeBean bean, int pageNo, int pageSize) throws Exception {
		Connection conn = DataPool.getConnection();
		StringBuffer sql = new StringBuffer(" select * from college where 1=1 ");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");

			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}
		System.out.println("sql=>" + sql);
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		ResultSet r = stmt.executeQuery();

		List list = new ArrayList();

		while (r.next()) {
			bean = new CollegeBean();
			bean.setId(r.getInt(1));
			bean.setName(r.getString(2));
			bean.setAddress(r.getString(3));
			bean.setState(r.getString(4));
			bean.setCity(r.getString(5));
			bean.setContact(r.getString(6));
			bean.setCreatedBy(r.getString(7));
			bean.setModifiedBy(r.getString(8));
			bean.setCreatedDateTime(r.getTimestamp(9));
			bean.setModifiedDateTime(r.getTimestamp(10));

			list.add(bean);
		}
		DataPool.closeConnection(conn);
		return list;
	}

}
