package com.aurionpro.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

public class CustomerConnection {

	private static Connection connection = DbConnection.connect();

	public static boolean checkLogin(String email, String password, String role) {
		

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select email, password, role from users where email=? and password=? and role=?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, role);

			ResultSet resultSet = preparedStatement.executeQuery();
			
			boolean isPresent = resultSet.next();

			return isPresent;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static int registerUser(String firstname, String lastname, String email, String role, String password) {

		int result = 0;

		try {
			Random random = new Random();

	        // Generate a random 3-digit number
	        int id = random.nextInt(900) + 100;
	        System.out.println(id);
	        
			PreparedStatement preparedStatement = connection.prepareStatement("insert into users values(?,?,?,?,?,?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, firstname);
			preparedStatement.setString(3, lastname);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, role);
			preparedStatement.setString(6, password);

			result = preparedStatement.executeUpdate();
			System.out.println("User added ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	public static List<UserTable> searchCustomer(String id) {
		
		List<UserTable> list = new ArrayList();
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from users where id=?");
			preparedStatement.setString(1, id);
		

			ResultSet resultSet = preparedStatement.executeQuery();
			String firstname = null, lastname = null, email = null, role = null, password = null;
			int id1=0;
			
			while (resultSet.next()) {
				id1=resultSet.getInt(1);
				firstname=resultSet.getString(2);
				lastname=resultSet.getString(3);
				email=resultSet.getString(4);
				role=resultSet.getString(5);
				password=resultSet.getString(6);

			}
			
			list.add(new UserTable(id1, firstname, lastname, email, role, password));

			System.out.println("Success");

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void addBankDetails(int idInt, String accountno) {
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into account values(?,?,?)");
			preparedStatement.setInt(1, idInt);
			preparedStatement.setString(2, accountno);
			preparedStatement.setInt(3, 0);


			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println("Bank Account added ");

			

		} catch (SQLException e) {
			e.printStackTrace();

		}
		
	}

	public static List<ViewCustomers> viewCustomers() {
		
		List<ViewCustomers> list = new ArrayList();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select firstname, lastname, accountnumber, balance from ACCOUNT INNER JOIN USERS on account.id=users.id where users.role='customer'");
		

			ResultSet resultSet = preparedStatement.executeQuery();
			String firstname = null, lastname = null;
			int balance = 0;
			Long accountnumber = null;
			
			while (resultSet.next()) {
				firstname=resultSet.getString("firstname");
				//System.out.println(firstname);
				lastname=resultSet.getString("lastname");
				accountnumber=Long.valueOf(resultSet.getString("accountnumber"));
				balance=Integer.parseInt(resultSet.getString("balance"));
				
				list.add(new ViewCustomers(firstname, lastname, accountnumber, balance));

			}
			

			//System.out.println("View Customers Successful");
			//System.out.println(list);
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

	public static void addTransaction(String accNo, String type, String receiverAcc, String amount) {
		
		try {
			
			Random random = new Random();

	        // Generate a random 4-digit number
	        int min = 1000;  // Minimum 4-digit number
	        int max = 9999;  // Maximum 4-digit number
	        int random4DigitNumber = random.nextInt(max - min + 1) + min;

	        // Generate a random 3-digit number
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	        // Format the LocalDate as a String
	        String formattedDate = date.format(formatter);
	        
			PreparedStatement preparedStatement = connection.prepareStatement("insert into transaction values(?,?,?,?,?,?)");
			preparedStatement.setInt(1, random4DigitNumber);
			preparedStatement.setString(2,(accNo));

			preparedStatement.setString(3,(receiverAcc) );
			preparedStatement.setString(4,type );
			preparedStatement.setString(5, amount);
			preparedStatement.setString(6, formattedDate);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			updateBalance(accNo,amount,type,receiverAcc);
			
						
			//ResultSet resultSet = preparedStatement.executeUpdate();
			System.out.println("Transaction added ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void updateBalance(String accNo, String amount, String type, String receiverAcc) {


		try {
	    
			System.out.println(type);
	        if(type.equals("credit"))
	        {
	        	System.out.println("credit");
	        	PreparedStatement preparedStatement = connection.prepareStatement("UPDATE account SET balance = balance +  ? WHERE accountnumber = ?");
				preparedStatement.setInt(1, Integer.parseInt(amount));
				System.out.println(amount);
				preparedStatement.setString(2,(accNo));
				System.out.println(accNo);

				ResultSet resultSet = preparedStatement.executeQuery();
	        }
	        
	        else if(type.equals("debit"))
	        {
	        	System.out.println("debit");
	        	PreparedStatement preparedStatement = connection.prepareStatement("UPDATE account SET balance =balance -  ? WHERE accountnumber=?");
				preparedStatement.setInt(1, Integer.parseInt(amount));
				System.out.println(amount);
				preparedStatement.setString(2,(accNo));
				System.out.println(accNo);

				ResultSet resultSet = preparedStatement.executeQuery();
	        }
	        else if(type.equals("transfer"))
	        {
	        	PreparedStatement preparedStatement = connection.prepareStatement("UPDATE account SET balance =balance -  ? WHERE accountnumber=?");
				preparedStatement.setString(1, amount);
				preparedStatement.setString(2,(accNo));

				preparedStatement.executeUpdate();
				
				PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE account SET balance =balance +  ? WHERE accountnumber=?");
				preparedStatement1.setString(1, amount);
				preparedStatement1.setString(2,(receiverAcc));

				preparedStatement1.executeUpdate();
	        }
			
						
						
			//ResultSet resultSet = preparedStatement.executeUpdate();
			System.out.println("Balance updated ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public static String findSenderAccNo(String username) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select accountnumber from ACCOUNT INNER JOIN USERS on account.id=users.id where email='anu@gmail.com'");
		

			ResultSet resultSet = preparedStatement.executeQuery();
			
			String accountnumber = null;
			
			while (resultSet.next()) {
				
				accountnumber=resultSet.getString("accountnumber");
				

			}
			
			//System.out.println(accountnumber);
			return accountnumber;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static List<Long> findReceiverAccNos() {
		
		List<Long> list = new ArrayList();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select accountnumber from ACCOUNT");
		

			ResultSet resultSet = preparedStatement.executeQuery();
			
			Long accountnumber = null;
			
			while (resultSet.next()) {
				
				accountnumber=Long.valueOf(resultSet.getString("accountnumber"));
				//System.out.println(accountnumber);
				list.add(accountnumber);

			}			

			//System.out.println("View Customers Successful");
			//System.out.println(list);
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static List<ViewPassbook> viewPassbook() {
		
		List<ViewPassbook> list = new ArrayList();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select firstname, lastname, accountnumber, balance from ACCOUNT INNER JOIN USERS on account.id=users.id where users.role='customer'");
		

			ResultSet resultSet = preparedStatement.executeQuery();
			String firstname = null, lastname = null;
			int balance = 0;
			Long accountnumber = null;
			
			while (resultSet.next()) {
				firstname=resultSet.getString("firstname");
				//System.out.println(firstname);
				lastname=resultSet.getString("lastname");
				accountnumber=Long.valueOf(resultSet.getString("accountnumber"));
				balance=Integer.parseInt(resultSet.getString("balance"));
				
				//list.add(new ViewPassbook(firstname, lastname, accountnumber, balance));

			}
			

			//System.out.println("View Customers Successful");
			//System.out.println(list);
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<ViewTransaction> viewTransaction() {
		
		List<ViewTransaction> list = new ArrayList();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select SENDERACCOUNTNUM, RECEIVERACCOUNTNUM, TYPE, AMOUNT, TRANSACTIONDATE from transaction");
		

			ResultSet resultSet = preparedStatement.executeQuery();
			Long senderaccountnum=null ;
			String type=null, date=null, receiveraccountnum=null;
			int amount=0;
			System.out.println("outside while");
			while (resultSet.next()) {
				System.out.println("inside while");
				senderaccountnum=Long.valueOf(resultSet.getString("senderaccountnum"));
				
				receiveraccountnum = resultSet.getString("receiveraccountnum");
				
				type=resultSet.getString("type");
				amount=Integer.parseInt(resultSet.getString("amount"));
				date=resultSet.getString("TRANSACTIONDATE");
				
//				System.out.println(senderaccountnum); 
//				System.out.println(receiveraccountnum); 
//				System.out.println(type);
//				System.out.println(amount);
//				System.out.println(date);
				

				list.add(new ViewTransaction(senderaccountnum, receiveraccountnum, type, amount, date));

			}
			

			System.out.println("View Transaction Successful");
			//System.out.println(list);
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static List<EditProfile> fetchProfileData(String username) {
		
		
		    
		try {
			
			List<EditProfile> list = new ArrayList();

			PreparedStatement preparedStatement = connection
					.prepareStatement("select FIRSTNAME, LASTNAME, PASSWORD from users where email=?");
		
			preparedStatement.setString(1,(username));

			ResultSet resultSet = preparedStatement.executeQuery();
			
			Long senderaccountnum=null ;
			String firstname=null, lastname=null, password=null;
			int amount=0;

			while (resultSet.next()) {

				firstname=resultSet.getString("firstname");
				//System.out.println(firstname);
				lastname=resultSet.getString("lastname");
				password=resultSet.getString("password");
				
				System.out.println(firstname); 
				System.out.println(lastname); 
				System.out.println(password);
			
				list.add(new EditProfile(firstname,lastname,password));
				

			}
			

			System.out.println("View Transaction Successful");
			//System.out.println(list);
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	public static void updateUser(String firstname, String lastname, String password, String username) {
		
		try {
			
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET firstname = ?, lastname=?, password=? WHERE email = ?");
		preparedStatement.setString(1, firstname);
		preparedStatement.setString(2, lastname);
		preparedStatement.setString(3, password);
		preparedStatement.setString(4, username);
		

		ResultSet resultSet = preparedStatement.executeQuery();
		
		System.out.println("Updated");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}