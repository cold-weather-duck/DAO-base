package com.dao.impl;

import java.sql.*;

public class JdbcUtil {
	
	private static Connection con = null;

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/xsh?useSSL=false";
	private static String user = "root";
	private static String password = "root";

	// jdbc����
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

	// ������
	public static void closeConn() {
		try {
			con.close();
			con = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//��ɾ�ĵ�ͨ�ò���
	public static int commonUpdate(String sql,Object ...args) throws Exception{
		//Connection con = null;
        PreparedStatement ps = null;

        int num = 0 ;
        
        try{
            //��ȡ����
            con = getConn();
            //Ԥ����SQL���,����preparedStatementʵ��
            ps = con.prepareStatement(sql);
            //���ռλ��
            for(int i=0;i< args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            //ִ�в���
            num = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
//        finally {
//            //�ر���Դ
//            closeConn();
//        }
        return num;
	}
}
