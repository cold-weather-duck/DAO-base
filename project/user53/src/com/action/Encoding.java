package com.action;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Encoding implements Filter {

	private String encodstr=null;//��������
	
	public void destroy() {
		// ����ʱ�ÿ�
		encodstr=null;
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// ���й��ˣ�������Щҳ���� web.xml�����õģ�
		try{
			if(encodstr != null){
				//������������
				arg0.setCharacterEncoding(encodstr);
				//������Ӧ����
				arg1.setCharacterEncoding(encodstr);
				String contentType="text/html;charset="+encodstr;
				arg1.setContentType(contentType);
			}
			
			arg2.doFilter(arg0, arg1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// ��ʼ���������ͣ��� web.xml ���õ�����
		encodstr = arg0.getInitParameter("encoding");
	}

}
