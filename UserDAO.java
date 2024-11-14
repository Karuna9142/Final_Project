package com.demo;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.User;

public class UserDAO
{
	// Function for adding a new member
		public static void registerMember(User user) {
			
			try {
				
				Configuration cfg = new Configuration();
				cfg.configure("hibernate.cfg.xml");
				SessionFactory sf = cfg.buildSessionFactory();
				Session session = sf.openSession();
				Transaction transaction = session.beginTransaction();
				
				session.save(user);
				
				transaction.commit();
				session.close();
				sf.close();
			} 
			catch (Exception e) {
				e.getMessage();
			}
		}
		public static List<User> listUsers() {
			try (Session session = new Configuration().configure().buildSessionFactory().openSession()) {
				return session.createQuery("from User", User.class).list();
			}
		}
			// Function for updating an existing member information
			public static void updateUser(int newId, String newName, String newEmail) {

				try {

					Configuration cfg = new Configuration();
					cfg.configure("hibernate.cfg.xml");
					SessionFactory sf = cfg.buildSessionFactory();
					Session session = sf.openSession();
					Transaction transaction = session.beginTransaction();

					User ud = session.get(User.class,newId);
					
					ud.setName(newName);
					ud.setEmail(newEmail);

					transaction.commit();
					session.close();
					sf.close();
				} catch (Exception e)
				{
					e.getMessage();
				}	
	      }
			// Function for deleting an existing User
			public static void deleteUser(int userId)
			{
				try {

					Configuration cfg = new Configuration();
					cfg.configure("hibernate.cfg.xml");
					SessionFactory sf = cfg.buildSessionFactory();
					Session session = sf.openSession();
					Transaction transaction = session.beginTransaction();

					User deletedUser = session.get(User.class, userId);

					if(deletedUser != null) {
						session.delete(deletedUser);
					} 
					else {
						System.out.println("User doesn't exists!!!");
					}

					transaction.commit();
					session.close();
					sf.close();
				} catch (Exception e) {
					e.getMessage();
				}
			}
			

}
