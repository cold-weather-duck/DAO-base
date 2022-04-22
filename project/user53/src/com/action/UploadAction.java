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
		// �ļ��ϴ�����
		// ���� post ����
		request.setCharacterEncoding("UTF-8");
		// String filePath = "C:/phpfind/WWW/img" ; // д�Լ���imgĿ¼��λ��
		// String webPath = "http://127.0.0.1/img/" ;
		String filePath = getServletContext().getInitParameter("filePath") ;
		String webPath = getServletContext().getInitParameter("webPath") ;
		
		// ��� enctype
		boolean ifMulti = ServletFileUpload.isMultipartContent(request);
		if(ifMulti){
			try {
				DiskFileItemFactory df = new DiskFileItemFactory(); // �����ļ���������
				ServletFileUpload sfu = new ServletFileUpload(df); // �ļ��ϴ��������
				sfu.setFileSizeMax(100*1024*1024); // �����ϴ��ļ��Ĵ�С 100MB ����λ byte 
				/* �ļ��ϴ��� 
				  request.getParameter(arg0) ����Ч
				*/
				List<FileItem> flist = sfu.parseRequest(request); // ʹ���������������
				String title = "" ; // ����
				String info = "" ; // ����
				String imgPath = ""; // ͼƬ·��
				// ѭ��
				for(FileItem fit : flist){
					if( fit.isFormField() ){ // ��ͨ��� : text , radio ,select
						if( fit.getFieldName().equals("title") ){
							title = fit.getString("UTF-8");
						}
						if( fit.getFieldName().equals("info") ){
							info = fit.getString("UTF-8");
						}
					}else{ // �ļ� : type = file
						//ȡԭ�ļ��� : 1.png
						String fname = fit.getName();
					    //ȷ��չ�� : .png
						int index = fname.lastIndexOf(".")	;
					    if(index != -1){ // ȷ���Ǹ��ļ�
					       String kz = fname.substring(index);
					       String rs = UUID.randomUUID().toString().replace("-", "");
					       fname = rs + kz ; // ����ļ���
					       System.out.println(" fname = "+ fname);
					       // �����ļ�
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
				
				// ��װ����
				Map<String,Object> hm = new HashMap();
				hm.put("title",title);
				hm.put("info",info);
				hm.put("imgPath",imgPath);
				
				// ������
				request.setAttribute("hm", hm);
				request.getRequestDispatcher("showInfo.jsp").forward(request, response);
				//
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			 throw new ServletException("----------enctype ���� multi!!");
		}
	}

}
