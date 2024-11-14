package com.demo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class OrderItem 
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 @ManyToOne
	 private Product product;
	 
	 @ManyToOne
	 private User user;
	 private Date orderDate;
	 private Date returnDate;
	 
	  public OrderItem()
	  {
		super();
	  }

	public OrderItem(int id, Product product,User user,Date orderDate, Date returnDate) {
		super();
		this.id = id;
		this.product = product;
		this.user = user;
		this.orderDate = orderDate;
		this.returnDate = returnDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Date getorderDate() {
		return orderDate;
	}

	public void setorderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	  
	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString()
	{
		return "OrderItem{id=" +id+ ", Product= " +product+  ", User= " +user+ ", Order Date =  " +orderDate+ ", Returndate= " +returnDate+ "}";
	}
	
	 
	 
}
