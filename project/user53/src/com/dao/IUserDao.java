package com.dao;

import java.util.*;
import com.entity.*;

/*
 * UserDao�Ľӿ�
 */
public interface IUserDao {
	
	List<Users> selectAll();//��ѯ����
	
	Users selectLogin(String user,String pwd);//��¼��ѯ
	
	Users selectOne(Integer usid);//��ѯ����
	
	Users selectOne(String uname);//��ѯ����(�����û���)
	
	int insertUser(Users u);//����
	
	int updateUser(Users u);//�޸�
	
	int deleteUser(Integer usid);//ɾ��
	
	List<Users> selectPage(int start,int size);//��ҳ
	
	int count();//������
}
