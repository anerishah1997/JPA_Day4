package com.lti.service;

import java.util.List;

import com.lti.dao.AuthorBookDaoImpl;
import com.lti.model.Author;
import com.lti.model.Book;

public class AuthorBookServiceImpl implements AuthorBookService{
	AuthorBookDaoImpl dao = null;
	
	
	

	public AuthorBookServiceImpl() {
		dao = new AuthorBookDaoImpl();
	}

	@Override
	public List<Book> findAllBook() {
		dao.beginTransaction();
		List<Book> list = dao.readAllBook();
		dao.commitTransaction();
		return list;
	}

	@Override
	public List<Book> findBookByAuthorName(String authorName) {
		
		return dao.readBookByAuthorName(authorName);
	}

	@Override
	public List<Book> findBooksByPrice(double min, double max) {
		
		return dao.readBooksByPrice(min, max);
	}

	@Override
	public List<Author> findAuthorByBookId(int ISBN) {
		
		return dao.readAuthorByBookId(ISBN);
	}

}
