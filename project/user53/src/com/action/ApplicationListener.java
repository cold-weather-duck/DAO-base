package com.action;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;

//工程监听器
public class ApplicationListener implements ServletContextListener{


	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("---工程结束");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("---工程开始");
		
		//从 web.xml 中取
		String filePath = arg0.getServletContext().getInitParameter("filePath");
		
		File f = new File(filePath);
		if ( !f.exists()) {//没有就建目录
			f.mkdirs();//多层目录
			System.out.println("---上传目录已建");
		}
	}
}
