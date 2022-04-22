package com.action;

import javax.servlet.http.*;
import com.entity.*;

public class LoginListener implements HttpSessionAttributeListener {


	public void attributeAdded(HttpSessionBindingEvent arg0) {
		/*
		 * 先有登录过滤
		 * 将小明加入黑名单不允许登录
		 */
		String name = arg0.getName();//session 的  key
		Object value = arg0.getValue();//session 的 value
		
		if ("userInfo".equals(name)) {
			Users uo = (Users)value;
			if ("小明".equals(uo.getUname())) {
				arg0.getSession().removeAttribute("userInfo");
			}
		}
		
	}


	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		
	}


	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		
	}

}
