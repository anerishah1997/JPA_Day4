package com.lti.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Orders")
public class Order implements Serializable{
	@Id
	private int orderId;
	@Temporal(TemporalType.DATE) 
	private Date purchaseDate;
	
	// owner
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="OrderProduct",
	           joinColumns={@JoinColumn(name="OrderId")},
	           inverseJoinColumns={@JoinColumn(name="ProductId")}) 
	// above refers the seperate mapping table-- only in ManytoMany
	// will have to specify the columns it contains, for that use JoinColumn
	private Set<Product> products = new HashSet<>();
	
	public Order() {
		super();
	}
	public Order(int orderId, Date purchaseDate) {
		super();
		this.orderId = orderId;
		this.purchaseDate = purchaseDate;
	}
	
	public void addProduct(Product product)
	{
		products.add(product);
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", purchaseDate=" + purchaseDate + "]";
	}
	
	
	

}
