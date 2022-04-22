package com.action;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.Response;

public class LoginFilter implements Filter {
	
	private List<String> flist = new ArrayList<>();//Ҫ���صĵ�ַ
	
	private List<String> qlist = new ArrayList<>();//Ҫ���еģ���Ĳ���

	public void destroy() {
		flist.clear();
		qlist.clear();
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		HttpSession session = request.getSession();
		
		String url = request.getRequestURI();//���ʵ�ַ
		String qs = request.getQueryString();//�� ��Ĳ���
//		System.out.println("url---"+url);
//		System.out.println("qs---"+qs);
		
		if (flist.contains(url) && !qlist.contains(qs)) {
			//��ס���ж�session����û���û���Ϣ
			Object uobj = session.getAttribute("userInfo");
			if(uobj!=null){
				filterChain.doFilter(servletRequest, servletResponse);//����
			}else {
				response.sendRedirect("/user53/login.jsp");//����������¼ҳ��
			}
			
		}else{
			filterChain.doFilter(servletRequest, servletResponse);//����
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		//����Ҫ���صĵ�ַ
		flist.add("/user53/UserAction");
		//Ҫ����Ĳ���
		qlist.add("method=login");
	}

}
