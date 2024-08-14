package com.in.rays.college;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.in.rays.bean.UserBean;

public class CollegeTest {
	public static void main(String[] args) throws Exception {
		testAdd();
		// testUpdate();
		// testDelete();
		// testPk();
		//testSearch();
	}

	public static void testAdd() throws Exception {
		CollegeModel model = new CollegeModel();
		CollegeBean bean = new CollegeBean();
		bean.setId(3);
		bean.setName("madhu");
		bean.setAddress("81 paradise");
		bean.setState("mp");
		bean.setCity("indore");
		bean.setContact("1234567890");
		bean.setCreatedBy("monika");
		bean.setModifiedBy("auth");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.add(bean);

	}

	public static void testUpdate() throws Exception {
		CollegeModel model = new CollegeModel();
		CollegeBean bean = new CollegeBean();
		bean.setName("advi");
		bean.setAddress("84 park");
		bean.setState("up");
		bean.setCity("bhopal");
		bean.setContact("1234567890");
		bean.setCreatedBy("advi");
		bean.setModifiedBy("auth");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		bean.setId(2);
		model.update(bean);
	}

	public static void testDelete() throws Exception {
		CollegeModel model = new CollegeModel();
		model.delete(3);
	}

	public static void testPk() throws Exception {
		CollegeModel model = new CollegeModel();
		CollegeBean bean = model.findbypk(1);
		if (bean != null) {
			System.out.println(bean.getId());
			System.out.print(bean.getName());
			System.out.print(bean.getAddress());
			System.out.print(bean.getState());
			System.out.print(bean.getCity());
			System.out.print(bean.getContact());
			System.out.print(bean.getCreatedBy());
			System.out.print(bean.getModifiedBy());
			System.out.print(bean.getCreatedDateTime());
			System.out.print(bean.getModifiedDateTime());
		} else {
			System.out.println("id not found");
		}

	}

	public static void testSearch() throws Exception {
		CollegeBean bean = new CollegeBean();
		 bean.setId(1);
		// bean.setName("a");
		CollegeModel model = new CollegeModel();
		List list = model.search(bean, 1, 5);
		Iterator i = list.iterator();
		while (i.hasNext()) {
			
			bean = (CollegeBean) i.next();
			
			System.out.println(bean.getId());
			System.out.print(bean.getName());
			System.out.print(bean.getAddress());
			System.out.print(bean.getState());
			System.out.print(bean.getCity());
			System.out.print(bean.getContact());
			System.out.print(bean.getCreatedBy());
			System.out.print(bean.getModifiedBy());
			System.out.print(bean.getCreatedDateTime());
			System.out.print(bean.getModifiedDateTime());

		}
	}
}
