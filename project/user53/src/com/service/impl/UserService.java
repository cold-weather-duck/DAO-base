package com.service.impl;

import java.util.*;
import com.entity.*;
import com.service.*;
import com.dao.*;
import com.dao.impl.*;


//User的服务类
public class UserService implements IUserService{
	
	private IUserDao userDao = new UserDao();


	public List<Users> selectAll() {
		
		List<Users> list = userDao.selectAll();
		
		//业务逻辑
		for(Users u : list){
			String sex = u.getSex();
			if(sex.equals("1")){
				u.setSex("男");
			}else if (sex.equals("2")) {
				u.setSex("女");
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
	 * pageno  页面上传下来的页数(第几页)
	 * pagesize  一页几行数据
	 */
	public Map<String, Object> selectPage(int pageno, int pagesize) {
		
		int pagenum = 1;//验证后的真实页码
		
		int pagecount = 1;//总页数
		
		List<Users> list = new ArrayList<>();//当前页显示的数据
		
		//-----------------------------------------
		//总记录数
		int all = userDao.count();
		if(all>0){
			if(all % pagesize == 0){
				pagecount = all / pagesize;
			}else {
				pagecount = all / pagesize + 1;
			}
		}
		//验证页码   不能 < 1     不能 > pagecount
		if(pageno < 1){
			pagenum = 1;
		}else if (pageno > pagecount) {
			pagenum = pagecount;
		}else {
			pagenum = pageno;
		}
		//取数据
		int start = (pagenum - 1) * pagesize;
		list = userDao.selectPage(start, pagesize);
		for(Users u : list){
			String sex = u.getSex();
			if(sex.equals("1")){
				u.setSex("男");
			}else if (sex.equals("2")) {
				u.setSex("女");
			}
		}
		//-----------------------------------------
		
		Map<String, Object> rm = new HashMap<>();
		
		rm.put("pagenum",pagenum);
		rm.put("pagecount",pagecount);
		rm.put("list",list);
		rm.put("all",all);//总记录数
		
		return rm;
	}

	public Users selectOne(String uname) {
		return userDao.selectOne(uname);
	}
	
	
}
