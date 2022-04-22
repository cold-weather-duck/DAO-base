package com.action;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.Response;

public class LoginFilter implements Filter {
	
	private List<String> flist = new ArrayList<>();//要拦截的地址
	
	private List<String> qlist = new ArrayList<>();//要放行的？后的参数

	public void destroy() {
		flist.clear();
		qlist.clear();
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		HttpSession session = request.getSession();
		
		String url = request.getRequestURI();//访问地址
		String qs = request.getQueryString();//？ 后的参数
//		System.out.println("url---"+url);
//		System.out.println("qs---"+qs);
		
		if (flist.contains(url) && !qlist.contains(qs)) {
			//拦住：判断session中有没有用户信息
			Object uobj = session.getAttribute("userInfo");
			if(uobj!=null){
				filterChain.doFilter(servletRequest, servletResponse);//放行
			}else {
				response.sendRedirect("/user53/login.jsp");//拦截跳到登录页面
			}
			
		}else{
			filterChain.doFilter(servletRequest, servletResponse);//放行
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		//加入要拦截的地址
		flist.add("/user53/UserAction");
		//要加入的参数
		qlist.add("method=login");
	}

}
