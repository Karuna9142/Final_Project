package com.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product
{
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String name;
 private double price;
 private boolean isAvailable;

public Product() {
	this.isAvailable = true;
}

public Product(int id, String name, double price,  boolean isAvailable) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.isAvailable = isAvailable;
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

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}
public boolean isAvailable() {
	return isAvailable;
}

public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
}

@Override
public String toString()
{
	return "Product{id=" +id+ ", Name= " +name+ ", price= " +price+  "', available=" + isAvailable +"}";
}
 
 
}
