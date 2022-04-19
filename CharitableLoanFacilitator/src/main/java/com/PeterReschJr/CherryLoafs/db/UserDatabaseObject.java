package com.PeterReschJr.CherryLoafs.db;

/**
 * A UserDatabaseObject represents a user object from the database.
 * 
 * @author peter
 *
 */
public class UserDatabaseObject extends DatabaseObject {

	/**
	 * UserDatabaseObject's member variables:
	 */
	String firstName;
	String lastName;
	String userName;
	String password;
	String userIDNumber;
	
	/**
	 * UserDatabaseObject's constructors:
	 */
	public UserDatabaseObject(String firstName, String lastName, String userName, 
																	String password, String userIDNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.userIDNumber = userIDNumber;
	}
	
	/**
	 * UserDatabaseObject's data access methods:
	 */
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getUserName() {
		return username;
	}
	
	public String get
	
	

}
