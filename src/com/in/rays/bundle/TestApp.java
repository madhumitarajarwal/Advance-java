package com.in.rays.bundle;

import java.util.ResourceBundle;

public class TestApp {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("com.in.rays.bundle.app");

		System.out.println(rb.getString("greeting"));

		System.out.println(rb.getString("msg"));

	}

}
