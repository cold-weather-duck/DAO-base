package com.dao;

import java.util.*;
import com.entity.*;

/*
 * UserDao的接口
 */
public interface IUserDao {
	
	List<Users> selectAll();//查询所有
	
	Users selectLogin(String user,String pwd);//登录查询
	
	Users selectOne(Integer usid);//查询单个
	
	Users selectOne(String uname);//查询单个(根据用户名)
	
	int insertUser(Users u);//新增
	
	int updateUser(Users u);//修改
	
	int deleteUser(Integer usid);//删除
	
	List<Users> selectPage(int start,int size);//分页
	
	int count();//总行数
}
