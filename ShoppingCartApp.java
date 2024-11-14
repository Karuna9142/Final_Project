package com.demo;


import java.util.List;
import java.util.Scanner;


public class ShoppingCartApp
{
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			// Give options for the operations
			System.out.println();
			System.out.println("Shopping Management System :");
			System.out.println("1 -> Add New Product");
			System.out.println("2 -> Register New User");
			System.out.println("3 -> Order Product");
			System.out.println("4 -> Return an Ordered Product");
			System.out.println("5 -> List of Product");
			System.out.println("6 -> List of User");
			System.out.println("7 -> List of OrderItem");
			System.out.println("8 -> Update a Product Record");
			System.out.println("9 -> Update a User Record");
			System.out.println("10 -> Delete a Product Record");
			System.out.println("11 -> Delete a User Record");
			System.out.println("12 -> Exit");
			
			// Enter the operation to perform
			System.out.print("Choose an option : ");
			int choice = sc.nextInt(); // Enter operation
			sc.nextLine(); // Consume newline
			
			switch (choice) {

			case 1:
				// input the name of the book
				System.out.print("Enter the Product Name : ");
				String pname = sc.nextLine();
				
				// input the price of the book
				System.out.print("Enter the price of product : ");
				double price = sc.nextDouble();
				
				// create a new Product
				Product newProduct = new Product();
				newProduct.setName(pname);
				newProduct.setPrice(price);
				
				// Call the addProduct function
				ProductDAO.addProduct(newProduct);
				System.out.println("New Product added successfully!!!");
				break;
				
			case 2:
				// input the name of the user you want to add
				System.out.print("Enter name of the user : ");
				String name = sc.nextLine();
				// input the email of the member you want to add
				System.out.print("Enter email of the user : ");
				String email = sc.nextLine();

				// create a new member
				User newUser = new User();
				newUser.setName(name);
				newUser.setEmail(email);
				// call the function to register the new member
				UserDAO.registerMember(newUser);
				System.out.println("User registered successfully!!!");
				break;
				
			case 3:
				// input the product id to order
				System.out.print("Enter product ID  : ");
				int productId = sc.nextInt();
				// input the user id who want to buy the product
				System.out.print("Enter user ID : ");
				int userId = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Product Ordered successfully");
				// call the function to order the product
				OrderItemDAO.orderProduct(productId, userId);
				break;
				
			case 4:
				// input the id to return
				System.out.print("Enter order ID to return: ");
				int orderId = sc.nextInt();
				// call the function to return the book
				OrderItemDAO.returnProduct(orderId);
				break;
				
			case 5:
				// Get the list of all the books
				List<Product> products = ProductDAO.listProduct();
				System.out.println();
				products.forEach(System.out::println);
				break;
				
			case 6:
				// Get the list of all the members
				List<User> users = UserDAO.listUsers();
				System.out.println();
				users.forEach(System.out::println);
				break;
				
			case 7:
				// Get the list of all the borrowing statement
				List<OrderItem> orderItem = OrderItemDAO.listOrderItem();
				System.out.println();
				orderItem.forEach(System.out::println);
				break;
			
			case 8:
				System.out.println("Enter the product ID you want to update : ");
				int updateId = sc.nextInt();
				// input the updated title of the book 
				sc.nextLine();
				System.out.print("Enter the updated product name : ");
				String updatedName = sc.nextLine();
				// input the updated author of the book
				System.out.print("Enter the updated price of Product  : ");
				double updatedPrice = sc.nextDouble();

				// Call the updateBook function
				ProductDAO.updateProduct(updateId, updatedName, updatedPrice);
				System.out.println("Product updated successfully!!!");
				break;

			case 9:

				System.out.println("Enter the ID of user you want to update : ");
				int updateUserId = sc.nextInt();
				sc.nextLine();
				
				// input the name of the user you want to update
				System.out.print("Enter updated name of the user : ");
				String updateName = sc.nextLine();
				
				// input the email of the member you want to update
				System.out.print("Enter updated email of the user : ");
				String updatedEmail = sc.nextLine();

				// call the function to update the existing member
				UserDAO.updateUser(updateUserId, updateName, updatedEmail);
				System.out.println("User updated successfully!!!");
				break;
			
			case 10:
				// input the id of product you want to delete
				System.out.print("Enter product ID to delete : ");
				int product_Id = sc.nextInt();
				// call the function to delete the book
				ProductDAO.deleteProduct(product_Id);
				System.out.println("Product deleted successfully!!!");
				break;
				
			case 11:
				// input the id of user you want to delete
				System.out.print("Enter user ID to delete : ");
				int user_Id = sc.nextInt();
				
				// call the function to delete the user
				UserDAO.deleteUser(user_Id);
				System.out.println("user deleted successfully!!!");
				break;

			case 12:
				// if User chose to be exited from the system
				System.out.println("Exited from the system...");
				sc.close();
				return;
				
				// In case of any other option taken rather than the above
			default:
				System.out.println("Invalid choice!");
			}
				
		}
	}

}
	
