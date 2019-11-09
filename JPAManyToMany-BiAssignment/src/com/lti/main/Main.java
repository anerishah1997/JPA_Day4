package com.lti.main;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Author;
import com.lti.model.Book;
import com.lti.service.AuthorBookServiceImpl;

public class Main {
	private static AuthorBookServiceImpl service;
	static{
		service = new AuthorBookServiceImpl();
	}
	public static void main(String[] args) {
		
		// find all books
		List<Book> list = service.findAllBook();
		for(Book b: list)
		{
			System.out.println(b);
			
		}
		
		// find book by author id.
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter authorName: ");
		List<Book> list1 = service.findBookByAuthorName(sc.nextLine());
		System.out.println(list1.size());
		for(Book b: list1)
		{
			System.out.println(b);
			
		}
		
		// books between min max
		List<Book> list2 = service.findBooksByPrice(1000, 2000);
		for(Book b: list2)
		{
			System.out.println(b);
			
		}
		
		// find author by Book Name
		List<Author> list3 = service.findAuthorByBookId(sc.nextInt());
		for(Author b: list3)
		{
			System.out.println(b);
			
		}
	}

}
