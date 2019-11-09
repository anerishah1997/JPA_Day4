package com.lti.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Authors")
public class Author {
	@Id
	private int id;
	private String name;
	
	@ManyToMany(mappedBy="authors")
	private Set<Book> books = new HashSet<>();
	public Author(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Author() {
	
	}
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Author [Id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}
