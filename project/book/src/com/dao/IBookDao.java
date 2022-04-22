package com.dao;

import java.util.List;
import com.entity.Book;


public interface IBookDao {
	
	List<Book> selectAll();//查询所有
	
	int deleteBook(Long id);//删除
	
	int insertBook(Book b);//新增

}
