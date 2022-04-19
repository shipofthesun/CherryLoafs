package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 * A UserCreationViewData represents a set of data from the front end that is used to create a 
 * new User in the database.
 * It is currently used to pass frontEnd
 * @author peter
 *
 */
public class UserCreationViewData extends ViewData {

	/**
	 * UserCreationViewData's member variables:
	 */
	String firstName;		
	String lastName;
	String userName;
	String password;
	String email;
	
	/**
	 * UserCreationViewData's constructors:
	 */
	
	/**
	 * Constructor to create a new UserCreationViewData's object with parameters specified by
	 * creator.
	 * 
	 * @param userIDNumber
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public UserCreationViewData(String firstName, String lastName, String userName, 
																										String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	
	/**
	 * UserCreationViewData's data access functions:
	 */
	
	/**
	 * Get member variable firstName's value.
	 * 
	 * @return firstName
	 */
	 public String getFirstName() {
		 return firstName;
	 }
	 
	 /**
	  * Get member variable lastName's value.
	  * 
	  * @return lastName
	  */
	 public String getLastName() {
		 return lastName;
	 }
	 
	 /**
	  * Get member variable email's value.
	  * 
	  * @return email
	  */
	 public String getUserName() {
		 return userName;
	 }
	 
	 /**
	  * Get member variable password's value.
	  * 
	  * @return password
	  */
	 public String getPassword() {
		 return password;
	 }
	 
	 public String getEmail() {
		 return email;
	 }
	
}
