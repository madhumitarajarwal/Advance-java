package com.in.rays.test1;


public class CustomerTest {
  public static void main(String[] args) throws Exception {
	 testAdd();
}
  public static void testAdd() throws Exception {
	  CustomerBean bean=new CustomerBean();
	  CustomerModel model=new CustomerModel();
	  bean.setId(1);
	  bean.setName("arvi");
	  bean.setCity("indore");
	  bean.setDate("12/02/2021");
	  model.add(bean);
  }
}
