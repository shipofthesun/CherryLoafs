package com.PeterReschJr.CherryLoafs.db.exception;

/**
 * LoanRecipientUserDatabaseObject is a set of data representing a LoanRecipientUser 
 * database object in the database.  An object of this type must be created, populated, and 
 * passed as an argument to the appropriate persist method in the Database object.
 * 
 * @author peter
 *
 */
public class LoanRecipientUserDatabaseObject {
	
	/**
	 * LoanRecipientUserDatabaseObject's member variables:
	 */
	String location;			// Verified location of the LoanRecipientUser.  This will be updated
										// periodically upon successful LoanRecipientUser login.  I am thinking
										// do the check every three months that the account has existed with
										// the LoanRecipientUser status.  The String value given will correspond 
										// with the value of an element in the Eligible Country or Region List.  
										// This list represents all eligible countries or regions of countries 
										// where LoanFunds can be collected towards Projects.  
										// This value will become null if their current location they are 
										//accessing the application from is determined to be outside of a 
										// location in the Eligible Country or Region List.
	
	/**
	 * LoanRecipientUserDatabaseObject's constructors:
	 */
	public LoanRecipientUserDatabaseObject(String location) {
		this.location = location;
	}
	
	/**
	 * LoanRecipientUserDatabaseObject's data access methods:
	 */
	
	/**
	 * 
	 * @return
	 */
	public String getLocation() {
		return location;
	}
}
