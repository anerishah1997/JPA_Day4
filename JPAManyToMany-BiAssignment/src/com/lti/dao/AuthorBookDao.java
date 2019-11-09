package com.lti.dao;

import java.util.List;

import com.lti.model.Author;
import com.lti.model.Book;

public interface AuthorBookDao {

	public List<Book> readAllBook();
	public List<Book> readBookByAuthorName(String authorName);
	public List<Book> readBooksByPrice(double min, double max);
	public List<Author> readAuthorByBookId(int ISBN);
	public void beginTransaction() ;
	public void commitTransaction();
	public void rollbackTransaction();
}
