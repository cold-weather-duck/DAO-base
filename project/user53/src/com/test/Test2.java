package com.test;

import com.entity.*;
import com.service.*;
import com.service.impl.*;

public class Test2 {
	public static void main(String[] args) {
		
		IUserService us = new UserService();
		
		Users u = us.selectLogin("tom1","123");
		
		System.out.println(u);
	}
}
