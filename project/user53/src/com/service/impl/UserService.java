package com.service.impl;

import java.util.*;
import com.entity.*;
import com.service.*;
import com.dao.*;
import com.dao.impl.*;


//User�ķ�����
public class UserService implements IUserService{
	
	private IUserDao userDao = new UserDao();


	public List<Users> selectAll() {
		
		List<Users> list = userDao.selectAll();
		
		//ҵ���߼�
		for(Users u : list){
			String sex = u.getSex();
			if(sex.equals("1")){
				u.setSex("��");
			}else if (sex.equals("2")) {
				u.setSex("Ů");
			}
		}
		return list;
	}

	public Users selectLogin(String user, String pwd) {
		
		return userDao.selectLogin(user,pwd);
	}

	public Users selectOne(Integer usid) {
		return userDao.selectOne(usid);
	}

	public int insertUser(Users u) {
		return userDao.insertUser(u);
	}

	public int updateUser(Users u) {
		return userDao.updateUser(u);
	}

	public int deleteUser(Integer usid) {
		return userDao.deleteUser(usid);
	}
	
	/*
	 * pageno  ҳ���ϴ�������ҳ��(�ڼ�ҳ)
	 * pagesize  һҳ��������
	 */
	public Map<String, Object> selectPage(int pageno, int pagesize) {
		
		int pagenum = 1;//��֤�����ʵҳ��
		
		int pagecount = 1;//��ҳ��
		
		List<Users> list = new ArrayList<>();//��ǰҳ��ʾ������
		
		//-----------------------------------------
		//�ܼ�¼��
		int all = userDao.count();
		if(all>0){
			if(all % pagesize == 0){
				pagecount = all / pagesize;
			}else {
				pagecount = all / pagesize + 1;
			}
		}
		//��֤ҳ��   ���� < 1     ���� > pagecount
		if(pageno < 1){
			pagenum = 1;
		}else if (pageno > pagecount) {
			pagenum = pagecount;
		}else {
			pagenum = pageno;
		}
		//ȡ����
		int start = (pagenum - 1) * pagesize;
		list = userDao.selectPage(start, pagesize);
		for(Users u : list){
			String sex = u.getSex();
			if(sex.equals("1")){
				u.setSex("��");
			}else if (sex.equals("2")) {
				u.setSex("Ů");
			}
		}
		//-----------------------------------------
		
		Map<String, Object> rm = new HashMap<>();
		
		rm.put("pagenum",pagenum);
		rm.put("pagecount",pagecount);
		rm.put("list",list);
		rm.put("all",all);//�ܼ�¼��
		
		return rm;
	}

	public Users selectOne(String uname) {
		return userDao.selectOne(uname);
	}
	
	
}
