package com.action;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Encoding implements Filter {

	private String encodstr=null;//编码类型
	
	public void destroy() {
		// 结束时置空
		encodstr=null;
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// 进行过滤（过滤哪些页面是 web.xml中配置的）
		try{
			if(encodstr != null){
				//处理请求乱码
				arg0.setCharacterEncoding(encodstr);
				//处理响应乱码
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
		// 初始化编码类型，从 web.xml 中拿到参数
		encodstr = arg0.getInitParameter("encoding");
	}

}
