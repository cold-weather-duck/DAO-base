package com.dao.impl;

import java.sql.*;
import java.util.*;
import com.dao.IUserDao;
import com.entity.*;

//JDBC操作类
public class UserDao extends BaseDao implements IUserDao {

	public List<Users> selectAll() {
		List<Users> list = new ArrayList<>();
		init();// 开始

		try {
			String sql = " SELECT * FROM users ";

			ResultSet rs = getRs(sql);

			while (rs.next()) {
				Users u = new Users();// 封装数据

				u.setUsid(rs.getInt("usid"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
				u.setSex(rs.getString("sex"));
				u.setCardNo(rs.getString("card_no"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getString("mobile"));

				list.add(u);// 加入集合
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();// 关闭
		return list;
	}

	public Users selectLogin(String user, String pwd) {
		Users u = null;
		init();
		try {
			String sql = " SELECT * FROM users WHERE uname = ? AND upwd = ? ";

			ResultSet rs = getRs(sql, user, pwd);

			while (rs.next()) {
				u = new Users();
				u.setUsid(rs.getInt("usid"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
				u.setSex(rs.getString("sex"));
				u.setCardNo(rs.getString("card_no"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getString("mobile"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return u;
	}

	public Users selectOne(Integer usid) {
		Users u = new Users();
		init();
		try {
			String sql = " SELECT * FROM users WHERE usid=? ";

			ResultSet rs = getRs(sql, usid);

			while (rs.next()) {
				u.setUsid(rs.getInt("usid"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
				u.setSex(rs.getString("sex"));
				u.setCardNo(rs.getString("card_no"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getString("mobile"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return u;
	}

	public int insertUser(Users u) {
		int num = 0;
		init();
		try {
			String sql = " INSERT INTO users VALUES(DEFAULT,?,?,?,?,?,?) ";

			num = getNum(sql, u.getUname(), u.getUpwd(), u.getSex(), u.getCardNo(), u.getEmail(), u.getMobile());

		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return num;
	}

	public int updateUser(Users u) {
		int num = 0;
		init();
		try {
			String sql = " UPDATE users ";
			sql += " SET uname=?,upwd=?,sex=?,card_no=?,email=?,mobile=? ";
			sql += " WHERE usid=? ";
			num = getNum(sql, u.getUname(), u.getUpwd(), u.getSex(), u.getCardNo(), u.getEmail(), u.getMobile(),
					u.getUsid());

		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return num;
	}

	public int deleteUser(Integer usid) {
		int num = 0;
		init();
		try {
			String sql = " DELETE FROM users WHERE usid=? ";

			num = getNum(sql, usid);

		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return num;
	}

	public List<Users> selectPage(int start, int size) {
		List<Users> list = new ArrayList<>();
		init();

		try {
			String sql = " SELECT * FROM users ORDER BY usid DESC LIMIT ?,? ";

			ResultSet rs = getRs(sql, start, size);

			while (rs.next()) {
				Users u = new Users();// 封装数据

				u.setUsid(rs.getInt("usid"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
				u.setSex(rs.getString("sex"));
				u.setCardNo(rs.getString("card_no"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getString("mobile"));

				list.add(u);// 加入集合
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		close();
		return list;
	}

	public int count() {
		int num = 0;
		init();

		try {
			String sql = " SELECT COUNT(usid) FROM users ";

			ResultSet rs = getRs(sql);

			if (rs.next()) {
				num = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		close();
		return num;
	}

	public Users selectOne(String uname) {
		Users u = new Users();
		init();
		try {
			String sql = " SELECT * FROM users WHERE uname=? ";

			ResultSet rs = getRs(sql, uname);

			while (rs.next()) {
				u.setUsid(rs.getInt("usid"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
				u.setSex(rs.getString("sex"));
				u.setCardNo(rs.getString("card_no"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getString("mobile"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return u;
	}

}
