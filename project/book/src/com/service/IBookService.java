package com.service;

import java.util.List;
import com.entity.Book;

public interface IBookService {

	List<Book> selectAll();// ��ѯ����

	int deleteBook(Long id);// ɾ��

	int insertBook(Book b);// ����
	
}
