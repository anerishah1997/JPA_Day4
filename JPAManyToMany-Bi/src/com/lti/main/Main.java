package com.lti.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Order;
import com.lti.model.Product;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = factory.createEntityManager();
		
		// first define few produicts b4 we place an order.
		
		Product elecProduct = new Product();
		elecProduct.setProductId(1);
		elecProduct.setProductName("LED TV");
		elecProduct.setPrice(45000);
		
		Product beautyProduct = new Product();
		beautyProduct.setProductId(2);
		beautyProduct.setProductName("Face Wash");
		beautyProduct.setPrice(80);
		
		Product babyProduct = new Product();
		babyProduct.setProductId(3);
		babyProduct.setProductName("Pampers");
		babyProduct.setPrice(15);
		
		Product eleProduct = new Product();
		eleProduct.setProductId(4);
		eleProduct.setProductName("CFL Bulb");
		eleProduct.setPrice(250);
		
		// now define first order and add few products in it.
		Order firstOrder = new Order();
		firstOrder.setOrderId(1000);
		firstOrder.setPurchaseDate(new Date());
		
		firstOrder.addProduct(babyProduct);
		firstOrder.addProduct(elecProduct);
		firstOrder.addProduct(beautyProduct);
		
		// now define second order add few products
		Order secondOrder = new Order();
		secondOrder.setOrderId(1001);
		secondOrder.setPurchaseDate(new Date());
		
		secondOrder.addProduct(babyProduct);
		secondOrder.addProduct(elecProduct);
		secondOrder.addProduct(eleProduct);
		
		// save orders using entity managers
		entityManager.getTransaction().begin();
		entityManager.persist(firstOrder);
		entityManager.persist(secondOrder);
		entityManager.getTransaction().commit();
		
		
	}

}
