package com.dao.impl;

import java.sql.*;

public class JdbcUtil {
	
	private static Connection con = null;

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/xsh?useSSL=false";
	private static String user = "root";
	private static String password = "root";

	// jdbc连接
	public static Connection getConn() {
		if (con == null) {
			try {
				Class.forName(driver);

				con = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return con;
	}

	// 关连接
	public static void closeConn() {
		try {
			con.close();
			con = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//增删改的通用操作
	public static int commonUpdate(String sql,Object ...args) throws Exception{
		//Connection con = null;
        PreparedStatement ps = null;

        int num = 0 ;
        
        try{
            //获取连接
            con = getConn();
            //预编译SQL语句,返回preparedStatement实例
            ps = con.prepareStatement(sql);
            //填充占位符
            for(int i=0;i< args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            //执行操作
            num = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
//        finally {
//            //关闭资源
//            closeConn();
//        }
        return num;
	}
}
