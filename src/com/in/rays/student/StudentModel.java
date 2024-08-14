package com.in.rays.student;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.SQLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.in.rays.college.CollegeBean;
import com.in.rays.college.CollegeModel;
import com.in.rays.util.DataPool;

public class StudentModel {
	public int pk() throws Exception {
		int pk = 0;
		Connection conn = DataPool.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select max(id) from student");
		ResultSet r = stmt.executeQuery();
		while (r.next()) {
			pk = (int) r.getLong(1);
		}
		return pk + 1;
	}

	public void add(StudentBean bean) throws Exception {
		int pk = pk();
		CollegeModel clgmodel = new CollegeModel();
		CollegeBean clgbean = new CollegeBean();
		
		
		Connection conn = DataPool.getConnection();
		PreparedStatement stmt = conn.prepareStatement(" insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?) ");
		stmt.setLong(1, pk);
		stmt.setString(2, bean.getFirstName());
		stmt.setString(3, bean.getLastName());
		stmt.setDate(4, new java.sql.Date(bean.getDate().getTime()));
		stmt.setString(5, bean.getGender());
		stmt.setString(6, bean.getMobileNo());
		stmt.setString(7, bean.getEmail());
		stmt.setLong(8, bean.getCollegeId());
		stmt.setString(9, bean.getCollegeName());
		stmt.setString(10, bean.getCreatedBy());
		stmt.setString(11, bean.getModifiedBy());
		stmt.setTimestamp(12, bean.getCreatedDateTime());
		stmt.setTimestamp(13, bean.getModifiedDateTime());
		int i = stmt.executeUpdate();
		DataPool.closeConnection(conn);
		System.out.println("query inserted=>" + i);
	}

	public void update(StudentBean bean) throws Exception {
		Connection conn = DataPool.getConnection();
		PreparedStatement stmt = conn.prepareStatement(
				" update student Set first_name=? , last_name=? , dob=? , gender=? , mobile_no=? , email=? ,  college_id=? , college_name=? , created_by=?  ,  modified_by=? ,created_datetime=? ,modified_datetime=? Where  id =? ");
		stmt.setString(1, bean.getFirstName());
		stmt.setString(2, bean.getLastName());
		stmt.setDate(3, new java.sql.Date(bean.getDate().getTime()));
		stmt.setString(4, bean.getGender());
		stmt.setString(5, bean.getMobileNo());
		stmt.setString(6, bean.getEmail());
		stmt.setLong(7, bean.getCollegeId());
		stmt.setString(8, bean.getCollegeName());
		stmt.setString(9, bean.getCreatedBy());
		stmt.setString(10, bean.getModifiedBy());
		stmt.setTimestamp(11, bean.getCreatedDateTime());
		stmt.setTimestamp(12, bean.getModifiedDateTime());
		stmt.setLong(13, bean.getId());
		int i = stmt.executeUpdate();
		DataPool.closeConnection(conn);
		System.out.println("query updated=>" + i);

	}

	public void delete(long id) throws Exception {
		Connection conn = DataPool.getConnection();
		PreparedStatement stmt = conn.prepareStatement(" delete from student where id=? ");
		stmt.setLong(1, id);
		int i = stmt.executeUpdate();
		DataPool.closeConnection(conn);
		System.out.println("query deleted=>" + i);

	}

	public StudentBean findPk(long id) throws Exception {
		Connection conn = DataPool.getConnection();
		PreparedStatement stmt = conn.prepareStatement(" select * from student where id= ? ");
		stmt.setLong(1, id);
		ResultSet r = stmt.executeQuery();
		StudentBean bean = null;

		while (r.next()) {
			bean = new StudentBean();
			bean.setId(r.getLong(1));
			bean.setFirstName(r.getString(2));
			bean.setLastName(r.getString(3));
			bean.setDate(r.getDate(4));
			bean.setGender(r.getString(5));
			bean.setMobileNo(r.getString(6));
			bean.setEmail(r.getString(7));
			bean.setCollegeId(r.getLong(8));
			bean.setCollegeName(r.getString(9));
			bean.setCreatedBy(r.getString(10));
			bean.setModifiedBy(r.getString(11));
			bean.setCreatedDateTime(r.getTimestamp(12));
			bean.setModifiedDateTime(r.getTimestamp(13));
			// System.out.println("query read=>"+i);
		}
		DataPool.closeConnection(conn);
		return bean;
	}

	public List search(StudentBean bean, int pageNo, int pageSize) throws Exception {
		Connection conn = DataPool.getConnection();
		StringBuffer sql = new StringBuffer(" select * from student where 1=1 ");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getEmail() != null && bean.getEmail().length() > 0) {
				sql.append(" and email like '" + bean.getEmail() + "'%");
			}
			if (bean.getDate() != null && bean.getDate().getTime() > 0) {
				sql.append(" and date = " + new java.sql.Date(bean.getDate().getTime()) + "%'");
			}
		}
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		ResultSet r = stmt.executeQuery();
		List list = new ArrayList();
		while (r.next()) {
			bean = new StudentBean();
			bean.setId(r.getLong(1));
			bean.setFirstName(r.getString(2));
			bean.setLastName(r.getString(3));
			bean.setDate(r.getDate(4));
			bean.setGender(r.getString(5));
			bean.setMobileNo(r.getString(6));
			bean.setEmail(r.getString(7));
			bean.setCollegeId(r.getLong(8));
			bean.setCollegeName(r.getString(9));
			bean.setCreatedBy(r.getString(10));
			bean.setModifiedBy(r.getString(11));
			bean.setCreatedDateTime(r.getTimestamp(12));
			bean.setModifiedDateTime(r.getTimestamp(13));
			list.add(bean);
		}
		return list;

	}

}
