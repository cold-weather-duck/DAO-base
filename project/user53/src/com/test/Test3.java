package com.test;

import com.entity.Users;
import com.service.IUserService;
import com.service.impl.*;

public class Test3 {

	public static void main(String[] args) {
		IUserService us = new UserService();
		
		Users u = us.selectOne(11);
		
		u.setUpwd("admin");
		int num = us.updateUser(u);
		
		System.out.println(num);
	}

}
