package com.dao;

import java.util.List;
import com.entity.Book;


public interface IBookDao {
	
	List<Book> selectAll();//��ѯ����
	
	int deleteBook(Long id);//ɾ��
	
	int insertBook(Book b);//����

}
