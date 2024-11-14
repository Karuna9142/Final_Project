package com.demo;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

import com.demo.Product;
import com.demo.OrderItem;
import com.demo.User;

public class OrderItemDAO
{
	public static void orderProduct(int productid, int userId)
	{
		
			try {
				Configuration cfg = new Configuration();
				cfg.configure("hibernate.cfg.xml");
				SessionFactory sf = cfg.buildSessionFactory();
				Session session = sf.openSession();
				Transaction transaction = session.beginTransaction();
				
				Product product1 = session.get(Product.class, productid);
				User user = session.get(User.class, userId);
				

				if (product1 != null && user != null && product1.isAvailable()) {
					OrderItem odi = new OrderItem();
					
					odi.setProduct(product1);
					odi.setUser(user);
					odi.setorderDate(new Date());
					product1.setAvailable(false);
					
					
					session.save(odi);
					session.update(product1);
					
					transaction.commit();
					session.close();
					sf.close();
					System.out.println("Product Ordered successfully!");
				} else {
					System.out.println("Product is unavailable or invalid user ID.");
				}
			}
			catch(Exception e) {
				e.getMessage();
			}
		}
	// Function for returning a Product book
		public static void returnProduct(int orderId)
		{
			try {
				
				Configuration cfg = new Configuration();
				cfg.configure("hibernate.cfg.xml");
				SessionFactory sf = cfg.buildSessionFactory();
				Session session = sf.openSession();
				Transaction transaction = session.beginTransaction();
				
				OrderItem od = session.get(OrderItem.class, orderId);

				if (od != null && od.getReturnDate() == null) {
					od.setReturnDate(new Date());
					od.getProduct().setAvailable(true);

					session.update(od);
					session.update(od.getProduct());
					
					transaction.commit();
					session.close();
					sf.close();
					System.out.println("Product returned successfully!");
				}
				else {
					System.out.println("Product ID invalid or Product already returned.");
				}
				
			} 
			catch(Exception e) {
				e.getMessage();
			}
		}
		// Function for getting the list of the Product available 
	
		public static List<OrderItem> listOrderItem() {
			try  (Session session = new Configuration().configure().buildSessionFactory().openSession()) {
				
				return session.createQuery("from OrderItem", OrderItem.class).list();
			}
		}
	}
			
	

