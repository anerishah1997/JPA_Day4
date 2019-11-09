package com.lti.service;

import java.util.List;

import com.lti.model.Author;
import com.lti.model.Book;

public interface AuthorBookService {
	
	public List<Book> findAllBook();
	public List<Book> findBookByAuthorName(String authorName) ;
	public List<Book> findBooksByPrice(double min, double max);
	public List<Author> findAuthorByBookId(int ISBN);

}
