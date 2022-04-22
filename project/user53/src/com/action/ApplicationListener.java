package com.action;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;

//���̼�����
public class ApplicationListener implements ServletContextListener{


	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("---���̽���");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("---���̿�ʼ");
		
		//�� web.xml ��ȡ
		String filePath = arg0.getServletContext().getInitParameter("filePath");
		
		File f = new File(filePath);
		if ( !f.exists()) {//û�оͽ�Ŀ¼
			f.mkdirs();//���Ŀ¼
			System.out.println("---�ϴ�Ŀ¼�ѽ�");
		}
	}
}
