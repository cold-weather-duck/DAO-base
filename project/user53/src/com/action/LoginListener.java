package com.action;

import javax.servlet.http.*;
import com.entity.*;

public class LoginListener implements HttpSessionAttributeListener {


	public void attributeAdded(HttpSessionBindingEvent arg0) {
		/*
		 * ���е�¼����
		 * ��С������������������¼
		 */
		String name = arg0.getName();//session ��  key
		Object value = arg0.getValue();//session �� value
		
		if ("userInfo".equals(name)) {
			Users uo = (Users)value;
			if ("С��".equals(uo.getUname())) {
				arg0.getSession().removeAttribute("userInfo");
			}
		}
		
	}


	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		
	}


	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		
	}

}
