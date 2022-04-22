package com.action;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TestAction extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//session
		HttpSession session = request.getSession();
		//application
		ServletContext application = getServletContext();
		
		
		
		PrintWriter out = response.getWriter();
		out.print("<h1> TestAction³É¹¦ </h1>");
		
		out.flush();
		out.close();
	}
	
}
