package com.service.impl;

import java.util.List;
import com.dao.IBookDao;
import com.dao.impl.BookDao;
import com.entity.Book;
import com.service.IBookService;

public class BookService implements IBookService {

	private IBookDao ib = new BookDao();

	@Override
	public List<Book> selectAll() {
		List<Book> list = ib.selectAll();

		// ҵ���߼�
		for (Book b : list) {
			String type = b.getType();
			if (type.equals("1")) {
				b.setType("�����/���");
			} else if (type.equals("2")) {
				b.setType("С˵/��ժ");
			}else if (type.equals("3")) {
				b.setType("����");
			}
			String time = b.getTime();
			String timString = time.substring(0,10);
			b.setTime(timString);
		}
		return list;
	}

	@Override
	public int deleteBook(Long id) {
		return ib.deleteBook(id);
	}

	@Override
	public int insertBook(Book b) {
		return ib.insertBook(b);
	}

}
