package com.in.rays.student;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.in.rays.util.DataPool;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class StudentTest {
	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// testDelete();
		// testPk();
		testSearch();
	}

	public static void testAdd() throws Exception {
		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();
		bean.setId(1);
		bean.setFirstName("monika");
		bean.setLastName("sharma");
		bean.setDate(new Date());
		bean.setGender("female");
		bean.setMobileNo("1234567890");
		bean.setEmail("monika@gmail.com");
		bean.setCollegeId(101);
		bean.setCollegeName("ips institue");
		bean.setCreatedBy("vivek sharma");
		bean.setModifiedBy("auth");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.add(bean);
	}

	public static void testUpdate() throws Exception {
		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();
		bean.setFirstName("radha");
		bean.setLastName("sharma");
		bean.setDate(new Date());
		bean.setGender("female");
		bean.setMobileNo("1234567890");
		bean.setEmail("radha@gmail.com");
		bean.setCollegeId(101);
		bean.setCollegeName("ips institue");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		bean.setId(1);
		model.update(bean);
	}

	public static void testDelete() throws Exception {
		StudentModel model = new StudentModel();
		model.delete(1);

	}

	public static void testPk() throws Exception {
		StudentModel model = new StudentModel();
		StudentBean bean = model.findPk(2);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.print(bean.getFirstName());
			System.out.print(bean.getLastName());
			System.out.print(bean.getDate());
			System.out.print(bean.getGender());
			System.out.print(bean.getMobileNo());
			System.out.print(bean.getEmail());
			System.out.print(bean.getCollegeId());
			System.out.print(bean.getCollegeName());
			System.out.print(bean.getCreatedBy());
			System.out.print(bean.getModifiedBy());
			System.out.print(bean.getCreatedDateTime());
			System.out.print(bean.getModifiedDateTime());

		} else {
			System.out.println("id not found");
		}
	}

	private static void testSearch() throws Exception {
		StudentBean bean = new StudentBean();
		bean.setId(2);
		StudentModel model = new StudentModel();
		List list = model.search(bean, 1,10);
		Iterator i = list.iterator();

		while (i.hasNext()) {

			bean = (StudentBean) i.next();
			System.out.println(bean.getId());
			System.out.print(bean.getFirstName());
			System.out.print(bean.getLastName());
			System.out.print(bean.getDate());
			System.out.print(bean.getGender());
			System.out.print(bean.getMobileNo());
			System.out.print(bean.getEmail());
			System.out.print(bean.getCollegeId());
			System.out.print(bean.getCollegeName());
			System.out.print(bean.getCreatedBy());
			System.out.print(bean.getModifiedBy());
			System.out.print(bean.getCreatedDateTime());
			System.out.print(bean.getModifiedDateTime());
			
	

		}

	}

}
