package com.test;

import com.service.*;
import com.service.impl.*;
import java.util.*;
import com.entity.*;

public class Test1 {

	public static void main(String[] args) {
		
		IUserService us = new UserService();
		
		List<Users> list = us.selectAll();
		
		for (Users u : list) {
			System.out.println(u);
		}
		
	}

}
