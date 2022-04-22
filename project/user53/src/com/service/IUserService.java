package com.service;

import java.util.*;
import com.entity.*;


//User�ķ���ӿ�
public interface IUserService {
	
	List<Users> selectAll();//��ѯ����
	
	Users selectLogin(String user,String pwd);//��¼��ѯ
	
	Users selectOne(Integer usid);//��ѯ����
	
	Users selectOne(String uname);//��ѯ����(�����û���)
	
	int insertUser(Users u);//����
	
	int updateUser(Users u);//�޸�
	
	int deleteUser(Integer usid);//ɾ��
	
	Map<String, Object> selectPage(int pageno,int pagesize);//��ҳ��ѯ
	
}
