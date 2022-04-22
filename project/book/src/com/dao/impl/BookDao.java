package com.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.dao.IBookDao;
import com.entity.Book;

public class BookDao extends BaseDao implements IBookDao {


	public List<Book> selectAll() {
		List<Book> list = new ArrayList<>();
		init();
		
		try {
			String sql = " SELECT * FROM bookmanage ORDER BY b_time DESC ";

			ResultSet rs = getRs(sql);

			while (rs.next()) {
				Book b = new Book();// 封装数据

				b.setId(rs.getLong("b_id"));
				b.setName(rs.getString("b_name"));
				b.setAuthor(rs.getString("b_author"));
				b.setTime(rs.getString("b_time"));
				b.setType(rs.getString("b_type"));

				list.add(b);// 加入集合
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();
		return list;
	}


	public int deleteBook(Long id) {
		int num = 0;
		init();
		
		try {
			String sql = " DELETE FROM bookmanage WHERE b_id=? ";

			num = getNum(sql, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();
		return num;
	}


	public int insertBook(Book b) {
		int num = 0;
		init();
		
		try {
			String sql = " INSERT INTO bookmanage VALUES(DEFAULT,?,?,?,?) ";

			num = getNum(sql, b.getName(), b.getAuthor(), b.getTime(), b.getType());

		} catch (Exception e) {
			e.printStackTrace();
		}
		close();

		return num;
	}

}
