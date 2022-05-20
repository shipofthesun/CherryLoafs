package com.PeterReschJr.CherryLoafs.db;

/**
 * A LoanRecipientUserDatabaseObject represents a set of data associated with a 
 * LoanRecipientUser database object in the database.  An object of this type must be 
 * created, populated, and passed to the appropriate persist method in the Database class in
 * order to update a User to a LoanRecipientUser in the database.
 * 
 * @author peter
 *
 */
public class LoanRecipientUserDatabaseObject {
		
	/**
	 * LoanRecipientUserDatabaseObject's member variables
	 */
	String location;
	
	/**
	 * LoanRecipientUserDatabaseObject's constructors:
	 */
	
	/**
	 * 
	 * @param location
	 */
	public LoanRecipientUserDatabaseObject(String location) {
		this.location = location;
	}
	
	/**
	 * LoanRecipientUserDatabaseObject's data access methods:
	 */
	
	/**
	 * 
	 * @return location
	 */
	public String getLocation() {
		return location;
	}
}
