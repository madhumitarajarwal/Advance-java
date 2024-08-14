package com.in.rays.testresourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceApp {
	public static void main(String[] args) {
		// ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");

				// ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app_hi");

				// ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app_sp");

				// ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app", new
				// Locale("hi"));

				//ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app", new Locale("sp"));

				//System.out.println(rb.getString("greeting"));


		String msg = getLanguage(null);

		System.out.println("msg: " + msg);

	}

	public static String getLanguage(String lang) {
		if (lang != null) {
			ResourceBundle rb = ResourceBundle.getBundle("com.in.rays.bundle.app", new Locale(lang));
			return rb.getString("greeting");
		}
		return "plz select any language hi or sp";
	}
}
