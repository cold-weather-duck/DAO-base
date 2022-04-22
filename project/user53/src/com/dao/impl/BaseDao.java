package com.dao.impl;

import java.sql.*;

/*
 * DAO的父类
 * 所有都是protected,可被继承
 */
public class BaseDao {
	
	protected Connection con = null;
	
	//初始化
	protected void init() {
		con = JdbcUtil.getConn();
	}
	
	//关闭连接
	protected void close() {
		JdbcUtil.closeConn();
		con = null;
	}
	
	//统一查询
	protected ResultSet getRs(String sql,Object ...oarr) throws Exception{
		PreparedStatement ps = con.prepareStatement(sql);
		
		if(oarr!=null && oarr.length>0){
			for(int i=0;i<oarr.length;i++){
				if(oarr[i] instanceof Date){
					ps.setDate(i+1, (Date)oarr[i]);//时间类型
				}else{
					ps.setObject(i+1, oarr[i]);
				}
			}
		}
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	
	//统一修改
	protected int getNum(String sql,Object ...oarr) throws Exception{
		int num = 0;
		PreparedStatement ps = con.prepareStatement(sql);
		
		if(oarr!=null && oarr.length>0){
			for(int i=0;i<oarr.length;i++){
				if(oarr[i] instanceof Date){
					ps.setDate(i+1, (Date)oarr[i]);//时间类型
				}else{
					ps.setObject(i+1, oarr[i]);
				}
			}
		}
		
		num = ps.executeUpdate();
		return num;
	}
	
	
}
