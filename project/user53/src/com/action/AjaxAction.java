package com.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.*;
import com.entity.*;
import com.service.impl.*;
import com.service.*;
import com.alibaba.fastjson.*;

//http://127.0.0.1:8090/user53/AjaxAction

@WebServlet("/AjaxAction")
public class AjaxAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUserService us = new UserService();

	public AjaxAction() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ������Ӧ��Ҫ��������������
		// Ajax���ܹ���ת�������ض���ֻ��������ʵ��
		String method = request.getParameter("method");

		if ("list".equals(method)) {
			list(request, response);
		} else if ("delete".equals(method)) {
			delete(request, response);
		} else if ("add".equals(method)) {
			add(request, response);
		}else if ("register".equals(method)) {
			register(request, response);
		}else if ("updateOne".equals(method)) {
			updateOne(request, response);
		}else if ("update".equals(method)) {
			update(request, response);
		}
	}
	
	// http://127.0.0.1:8090/user53/AjaxAction?method=update
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String usid = request.getParameter("usid");
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String sex = request.getParameter("sex");
		String cardNo = request.getParameter("cardNo");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		Users u1 = new Users();
		u1.setUsid(Integer.parseInt(usid));
		u1.setUname(uname);
		u1.setUpwd(upwd);
		u1.setSex(sex);
		u1.setCardNo(cardNo);
		u1.setEmail(email);
		u1.setMobile(mobile);
		
		int num = us.updateUser(u1);
		
		Map<String,Object> rm = new HashMap<>();
		
		if(num>0){
			rm.put("info","�޸ĳɹ�");
		}else{
			rm.put("info","�޸�ʧ��");
		}
		
		String js = JSON.toJSONString(rm);
		System.out.println("----js=" + js);

		out.print(js);
		
		out.flush();
		out.close();
	}
	
	// http://127.0.0.1:8090/user53/AjaxAction?method=updateOne
	private void updateOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int usid = Integer.parseInt(request.getParameter("usid"));
		
		Users u = us.selectOne(usid);
		Map<String,Object> rm = new HashMap<>();
		
		rm.put("uo",u);
		String js = JSON.toJSONString(rm);

		out.print(js);
		
		
		out.flush();
		out.close();
	}
	
	// http://127.0.0.1:8090/user53/AjaxAction?method=register
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Map<String, Object> rm = new HashMap<>();
		
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String sex = request.getParameter("sex");
		String cardNo = request.getParameter("cardNo");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		Users u = us.selectOne(uname);
		
		if(u.getUname()!=null){
			rm.put("info","ע��ʧ�ܣ����û����Ѵ��ڣ���");
			rm.put("registerCode",-1);
			// תjson
			String js = JSON.toJSONString(rm);
			System.out.println("----js=" + js);

			out.print(js);
		}else{
			Users u1 = new Users();
			u1.setUname(uname);
			u1.setUpwd(upwd);
			u1.setSex(sex);
			u1.setCardNo(cardNo);
			u1.setEmail(email);
			u1.setMobile(mobile);
			
			int num = us.insertUser(u1);

			rm.put("registerCode", num);
			if (num < 1) {
				rm.put("info", "ע��ʧ��");
			} else {
				rm.put("info", "ע��ɹ�");
			}

			// תjson
			String js = JSON.toJSONString(rm);
			System.out.println("----js=" + js);

			out.print(js);
		}
		
		out.flush();
		out.close();
	}

	// http://127.0.0.1:8090/user53/AjaxAction?method=add
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
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

		Map<String, Object> rm = new HashMap<>();// ��װ���ص���Ϣ
		rm.put("addCode", num);
		if (num < 1) {
			rm.put("info", "����ʧ��");
		} else {
			rm.put("info", "�����ɹ�");
		}

		// תjson
		String js = JSON.toJSONString(rm);
		System.out.println("----js=" + js);

		out.print(js);// ��Ҫ��ln

		out.flush();
		out.close();
	}

	// http://127.0.0.1:8090/user53/AjaxAction?method=list
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		// ȡ����
		List<Users> list = us.selectAll();

		// תjson
		String js = JSON.toJSONString(list);
		System.out.println("-----json" + js);

		// ��json�������Ӧ��
		out.print(js);// ��Ҫ��ln

		out.flush();
		out.close();
	}

	// http://127.0.0.1:8090/user53/AjaxAction?method=delete
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String usid = request.getParameter("usid");

		Integer num = us.deleteUser(Integer.parseInt(usid));

		Map<String, Object> rm = new HashMap<>();// ��װ���ص���Ϣ
		rm.put("deleteCode", num);
		if (num < 1) {
			rm.put("info", "ɾ��ʧ��");
		} else {
			rm.put("info", "ɾ���ɹ�");
		}

		// תjson
		String js = JSON.toJSONString(rm);
		System.out.println("----js=" + js);

		out.print(js);// ��Ҫ��ln

		out.flush();
		out.close();
	}

}
