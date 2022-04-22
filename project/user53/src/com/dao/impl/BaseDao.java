package com.dao.impl;

import java.sql.*;

/*
 * DAO�ĸ���
 * ���ж���protected,�ɱ��̳�
 */
public class BaseDao {
	
	protected Connection con = null;
	
	//��ʼ��
	protected void init() {
		con = JdbcUtil.getConn();
	}
	
	//�ر�����
	protected void close() {
		JdbcUtil.closeConn();
		con = null;
	}
	
	//ͳһ��ѯ
	protected ResultSet getRs(String sql,Object ...oarr) throws Exception{
		PreparedStatement ps = con.prepareStatement(sql);
		
		if(oarr!=null && oarr.length>0){
			for(int i=0;i<oarr.length;i++){
				if(oarr[i] instanceof Date){
					ps.setDate(i+1, (Date)oarr[i]);//ʱ������
				}else{
					ps.setObject(i+1, oarr[i]);
				}
			}
		}
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	
	//ͳһ�޸�
	protected int getNum(String sql,Object ...oarr) throws Exception{
		int num = 0;
		PreparedStatement ps = con.prepareStatement(sql);
		
		if(oarr!=null && oarr.length>0){
			for(int i=0;i<oarr.length;i++){
				if(oarr[i] instanceof Date){
					ps.setDate(i+1, (Date)oarr[i]);//ʱ������
				}else{
					ps.setObject(i+1, oarr[i]);
				}
			}
		}
		
		num = ps.executeUpdate();
		return num;
	}
	
	
}
