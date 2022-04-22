package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.alibaba.fastjson.JSON;
import com.entity.Book;
import com.mysql.fabric.xmlrpc.base.Param;
import com.service.IBookService;
import com.service.impl.BookService;


//http://127.0.0.1:8090/book/BookAction
@WebServlet("/BookAction")
public class BookAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IBookService ib = new BookService();
	
	
    public BookAction() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		
		if("main".equals(method)){
			main(request, response);
		}else if("add".equals(method)){
			add(request, response);
		}else if("delete".equals(method)){
			delete(request, response);
		}
	}
	
	//http://127.0.0.1:8090/book/BookAction?method=main
	private void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Book> list = ib.selectAll();
		
		request.setAttribute("list",list);
		
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
	
	//http://127.0.0.1:8090/book/BookAction?method=add
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		
		String time = request.getParameter("time");
		String t = "^[1-9]{4}-[0-2]{1}[0-9]{1}-[0-2]{1}[0-9]{1}";
		boolean ck = Pattern.matches(t,time);
		
		String type = request.getParameter("type");
		Book b = new Book();
		if(name!=""&&author!=""&&time!=""&&type!=""&&ck){
			b.setName(name);
			b.setAuthor(author);
			b.setTime(time);
			b.setType(type);
			int num = ib.insertBook(b);
			
			request.setAttribute("addCode", num);//判断是否新增成功
			request.getRequestDispatcher("/BookAction?method=main").forward(request, response);
		}else {
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
		
	}
	
	//http://127.0.0.1:8090/book/BookAction?method=delete
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");

		long num = ib.deleteBook(Long.parseLong(id));

		Map<String, Object> rm = new HashMap<>();// 封装返回的信息
		rm.put("deleteCode", num);
		if (num < 1) {
			rm.put("info", "删除失败");
		} else {
			rm.put("info", "删除成功");
		}

		// 转json
		String js = JSON.toJSONString(rm);
		System.out.println("----js=" + js);

		out.print(js);// 不要加ln

		out.flush();
		out.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
