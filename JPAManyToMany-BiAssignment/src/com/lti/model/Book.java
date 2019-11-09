package com.lti.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Books")
public class Book {
    
	@Id
	private int iSBN;
	private String title;
	private double price;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="AuthorBook",
	           joinColumns={@JoinColumn(name="iSBN")},
	           inverseJoinColumns={@JoinColumn(name="id")})
	private Set<Author> authors = new HashSet<>();
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	public Book() {
	
	}
	public Book(int iSBN, String title, double price) {
		super();
		this.iSBN = iSBN;
		this.title = title;
		this.price = price;
	}
	
	public void addProduct(Author author)
	{
		authors.add(author);
	}
	
	public int getISBN() {
		return iSBN;
	}
	public void setISBN(int iSBN) {
		this.iSBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [iSBN=" + iSBN + ", title=" + title + ", price=" + price + ", authors=" + authors + "]";
	}
	
	
	
}
