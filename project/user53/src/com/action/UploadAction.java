package com.action;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import com.entity.*;
import com.service.impl.*;
import com.service.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * http://127.0.0.1:8090/user53/page/UploadAction
 * http://127.0.0.1:8090/user53/page/upload.jsp
 */
@WebServlet("/page/UploadAction")
public class UploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService us = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文件上传处理
		// 处理 post 乱码
		request.setCharacterEncoding("UTF-8");
		// String filePath = "C:/phpfind/WWW/img" ; // 写自己的img目录的位置
		// String webPath = "http://127.0.0.1/img/" ;
		String filePath = getServletContext().getInitParameter("filePath") ;
		String webPath = getServletContext().getInitParameter("webPath") ;
		
		// 检查 enctype
		boolean ifMulti = ServletFileUpload.isMultipartContent(request);
		if(ifMulti){
			try {
				DiskFileItemFactory df = new DiskFileItemFactory(); // 磁盘文件工厂对象
				ServletFileUpload sfu = new ServletFileUpload(df); // 文件上传组件对象
				sfu.setFileSizeMax(100*1024*1024); // 设置上传文件的大小 100MB ；单位 byte 
				/* 文件上传中 
				  request.getParameter(arg0) 不生效
				*/
				List<FileItem> flist = sfu.parseRequest(request); // 使用组件来解析请求
				String title = "" ; // 标题
				String info = "" ; // 介绍
				String imgPath = ""; // 图片路径
				// 循环
				for(FileItem fit : flist){
					if( fit.isFormField() ){ // 普通组件 : text , radio ,select
						if( fit.getFieldName().equals("title") ){
							title = fit.getString("UTF-8");
						}
						if( fit.getFieldName().equals("info") ){
							info = fit.getString("UTF-8");
						}
					}else{ // 文件 : type = file
						//取原文件名 : 1.png
						String fname = fit.getName();
					    //确扩展名 : .png
						int index = fname.lastIndexOf(".")	;
					    if(index != -1){ // 确定是个文件
					       String kz = fname.substring(index);
					       String rs = UUID.randomUUID().toString().replace("-", "");
					       fname = rs + kz ; // 随机文件名
					       System.out.println(" fname = "+ fname);
					       // 保存文件
					       File newFile = new File(filePath,fname) ;
					       fit.write(newFile);
					       //
					       imgPath = webPath + fname;
					       //
					    }
					}
				}
				//
				System.out.println(" ---- title = "+ title);
				System.out.println(" ---- info = "+ info);
				System.out.println(" ---- imgPath = "+ imgPath);
				
				// 封装数据
				Map<String,Object> hm = new HashMap();
				hm.put("title",title);
				hm.put("info",info);
				hm.put("imgPath",imgPath);
				
				// 传数据
				request.setAttribute("hm", hm);
				request.getRequestDispatcher("showInfo.jsp").forward(request, response);
				//
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			 throw new ServletException("----------enctype 不是 multi!!");
		}
	}

}
