package com.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;





public class ProductDAO 
{
	public static void addProduct(Product product) {
      
         try {
			
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory sf = cfg.buildSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.save(product);
			
			transaction.commit();
			session.close();
			sf.close();
			
		} 
		catch (Exception e) {
			e.getMessage();
		}
	}
	
	// Function for getting the list of the products available 
		public static  List<Product> listProduct() {
			try (Session session = new Configuration().configure().buildSessionFactory().openSession()){
				return session.createQuery("from Product", Product.class).list();
			} 
		}
		
		// Function for updating an existing book information
		public static void updateProduct(int Id, String name, double price) {
			try {

				Configuration cfg = new Configuration();
				cfg.configure("hibernate.cfg.xml");
				SessionFactory sf = cfg.buildSessionFactory();
				Session session = sf.openSession();
				Transaction transaction = session.beginTransaction();

				Product pro = session.get(Product.class, Id);

				pro.setId(Id);
				pro.setName(name);
				pro.setPrice(price);

				transaction.commit();
				session.close();
				sf.close();

			} catch (Exception e) {
				e.getMessage();
			}
		}
		// Function for deleting an existing product
		public static void deleteProduct(int Id) {

			try {

				Configuration cfg = new Configuration();
				cfg.configure("hibernate.cfg.xml");
				SessionFactory sf = cfg.buildSessionFactory();
				Session session = sf.openSession();
				Transaction transaction = session.beginTransaction();

				Product deleteProduct = session.get(Product.class, Id);

				if (deleteProduct != null) {
					session.delete(deleteProduct);
				} else {
					System.out.println("Product doesn't exists!!!");
				}

				transaction.commit();
				session.close();
				sf.close();
			} 
			catch (Exception e)
			{
				e.getMessage();
			}
	}
}
