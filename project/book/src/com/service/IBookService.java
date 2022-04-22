package com.service;

import java.util.List;
import com.entity.Book;

public interface IBookService {

	List<Book> selectAll();// 查询所有

	int deleteBook(Long id);// 删除

	int insertBook(Book b);// 新增
	
}
