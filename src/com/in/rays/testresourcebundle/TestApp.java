package com.in.rays.testresourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestApp {
	public static void main(String[] args) {
		// ResourceBundle rb=ResourceBundle.getBundle("com.in.rays.bundle.app");
		// ResourceBundle rb1=ResourceBundle.getBundle("com.in.rays.bundle.app_hi");
		ResourceBundle rb2 = ResourceBundle.getBundle("com.in.rays.bundle.app", new Locale("hi"));
		//ResourceBundle rb1= ResourceBundle.getBundle("com.in.rays.bundle.app", new Locale("sp"));
		// System.out.println(rb2.getString("greeting"));
		System.out.println(rb2.getString("greeting"));
	}
}
