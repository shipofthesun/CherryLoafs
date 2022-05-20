package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 *  A UserCreationFormViewData represents a set of data from a FrontEnd 
 *  UserCreationFormView that is submitted by a Guest in attempt to register as a regular User
 *  of the application.  It can also serve as a signal back to the FrontEnd that the 
 *  UserCreationForm should be displayed to the Guest.  In this case, empty Strings are passed
 *  as arguments to the constructor to indicate that the form should be displayed as blank to 
 *  allow the Guest to fill out the Form.
 *  
 * @author peter
 *
 */
public class UserCreationFormViewData extends ViewData {

	/**
	 * UserCreationFormViewData's member variables:
	 */
	String firstName;		
	String lastName;
	String userName;
	String password;
	String email;
	
	/**
	 * UserCreationFormViewData's constructors:
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
	public UserCreationFormViewData(String firstName, String lastName, String userName, 
																										String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	
	/**
	 * UserCreationFormViewData's data access functions:
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
