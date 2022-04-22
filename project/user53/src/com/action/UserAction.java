package com.action;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.entity.*;
import com.service.*;
import com.service.impl.*;

/**
 * Servlet implementation class UserAction
 */
@WebServlet("/UserAction")
public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUserService us = new UserService();

	public UserAction() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * request.setCharacterEncoding("UTF-8");
		 * 
		 * //��Ӧ�����봦�� response.setCharacterEncoding("UTF-8");
		 * 
		 * response.setContentType("text/html;charset=UTF-8");
		 */

		String method = request.getParameter("method");// �����߼��Ĳ���
		if ("login".equals(method)) {// ��¼�߼�
			login(request, response);
		} else if ("main".equals(method)) {
			main(request, response);
		}else if ("add".equals(method)) {
			add(request, response);
		}else if ("one".equals(method)) {
			one(request, response);
		}else if ("update".equals(method)) {
			update(request, response);
		}else if ("delete".equals(method)) {
			delete(request, response);
		}
	}

	// ��¼:http://127.0.0.1:8090/user53/UserAction?method=login
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		// ������
		Users uo = us.selectLogin(uname, upwd);
		if (uo != null && uo.getUsid() != null) {// ��¼�ɹ�
			// �û���Ϣ��session
			request.getSession().setAttribute("userInfo", uo);
			// response.sendRedirect("/user53/index.jsp");
			response.sendRedirect("/user53/UserAction?method=main");
		} else {
			request.setAttribute("loginCode", "1");// 1�û������������
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	// ��ҳ //��¼:http:127.0.0.1:8090/user53/UserAction?method=main
	private void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// List<Users> ulist = us.selectAll();
		int no = 1;
		int size = 4;

		try {
			String pno = request.getParameter("pno");
			no = Integer.parseInt(pno);
		} catch (Exception e) {
			no = 1;
		}

		Map<String, Object> hm = us.selectPage(no, size);
		/*
		 * List<Users> ulist = (List<Users>)hm.get("list"); int pagenum =
		 * (Integer)hm.get("pagenum"); int pagecount =
		 * (Integer)hm.get("pagecount"); int all = (Integer)hm.get("all");
		 */

		request.setAttribute("hm", hm);// ��map���Ϸ��� request
		List<Integer> numList = new ArrayList();
		for (int i = 1; i <= (Integer) hm.get("pagecount"); i++) {
			numList.add(i);
		}
		request.setAttribute("numList", numList);// ��map���Ϸ��� request

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String sex = request.getParameter("sex");
		String cardNo = request.getParameter("cardNo");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		Users u = new Users();
		u.setUname(uname);
		u.setUpwd(upwd);
		u.setSex(sex);
		u.setCardNo(cardNo);
		u.setEmail(email);
		u.setMobile(mobile);
		
		int num = us.insertUser(u);
		
		request.setAttribute("addCode", num);//�ж��Ƿ������ɹ�
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}
	
	private void one(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ȡԭʼ��ֵ
		String usid = request.getParameter("usid");
		
		Users u = us.selectOne(Integer.parseInt(usid));
		
		request.setAttribute("uo",u);
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usid = request.getParameter("usid");
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String sex = request.getParameter("sex");
		String cardNo = request.getParameter("cardNo");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		Users u = new Users();
		u.setUname(uname);
		u.setUpwd(upwd);
		u.setSex(sex);
		u.setCardNo(cardNo);
		u.setEmail(email);
		u.setMobile(mobile);
		u.setUsid(Integer.parseInt(usid));
		
		int num = us.updateUser(u);
		
		request.setAttribute("updateCode", num);//�ж��Ƿ������ɹ�
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usid = request.getParameter("usid");
		
		int num = us.deleteUser(Integer.parseInt(usid));
		
		request.setAttribute("deleteCode", num);//�ж��Ƿ������ɹ�
		request.getRequestDispatcher("/UserAction?method=main").forward(request, response);
	}
}
