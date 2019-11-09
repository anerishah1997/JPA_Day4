package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.lti.model.Author;
import com.lti.model.Book;
import com.lti.utils.JpaUtils;

public class AuthorBookDaoImpl implements AuthorBookDao{

private EntityManager entityManager;
	
	
	public AuthorBookDaoImpl() {
		entityManager = JpaUtils.getEntityManager();
		init();
	}

	public void init(){

		Author auth1 = new Author();
		auth1.setId(15);
		auth1.setName("Chetan Bhagat");
		
		
		Author auth2 = new Author();
		auth2.setId(16);
		auth2.setName("Jk Rowling");
		
		Author auth3 = new Author();
		auth3.setId(17);
		auth3.setName("Mark Manson");
		
		// books
		Book book1 = new Book();
		book1.setISBN(1001);
		book1.setTitle("Two States");
		book1.setPrice(1000);
		
		book1.addProduct(auth1);
		book1.addProduct(auth3);
		
		Book book2 = new Book();
		book2.setISBN(1002);
		book2.setTitle("Harry Potter");
		book2.setPrice(4900);
		
		book2.addProduct(auth2);
		book2.addProduct(auth3);
		
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(book1);
		entityManager.persist(book2);
		entityManager.getTransaction().commit();
		
	}
	
	@Override
	public List<Book> readAllBook() {
		TypedQuery<Book> query = entityManager.createQuery("Select b from Book b", Book.class);
		List<Book> list = query.getResultList();
		return list;
	}

	@Override
	public List<Book> readBookByAuthorName(String authorName) {
		TypedQuery<Book> query = entityManager.createQuery("Select b from Book b Inner Join b.authors a where a.name=:name", Book.class);
		query.setParameter("name", authorName);
		List<Book> list = query.getResultList();
		return list;
		
	}

	@Override
	public List<Book> readBooksByPrice(double min, double max) {
		String query="select  b From Book b where b.price Between "+min+" and "+max;
		System.out.println(query);
		TypedQuery<Book> tquery=entityManager.createQuery(query, Book.class);
		List<Book> list=tquery.getResultList();
		return list;
	}

	@Override
	public List<Author> readAuthorByBookId(int ISBN) {
		TypedQuery<Author> query = entityManager.createQuery("Select a from Author a Inner Join a.books b where b.iSBN=:iSBN", Author.class);
		query.setParameter("iSBN", ISBN);
		List<Author> list = query.getResultList();
		return list;

	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void rollbackTransaction() {
		entityManager.getTransaction().rollback();
		
	}
	
	

}
