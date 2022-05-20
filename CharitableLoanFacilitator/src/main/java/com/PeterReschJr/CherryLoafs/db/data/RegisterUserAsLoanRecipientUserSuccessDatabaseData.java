package com.PeterReschJr.CherryLoafs.db.data;

/**
 * A RegisterUserAsLoanRecipientUserSuccessDatabaseData represents a set of data returned
 * from the Database as the result of a successful update of the User to LoanRecipientUser 
 * status in the Database.  It also serves as a signal to the caller that the persistence operation
 * to update the User's status was a success.  Currently, this success will result in the newly 
 * created LoanRecipientUser being sent to their DefaultLoanRecipientUserView.
 * 
 * @author peter
 *
 */
public class RegisterUserAsLoanRecipientUserSuccessDatabaseData {
	
	/**
	 * RegisterUserAsLoanRecipientUserSuccessDatabaseData's member variables:
	 */
	String username;
	
	/**
	 * RegisterUserAsLoanRecipientUserSuccessDatabaseData's constructors:
	 */
	public RegisterUserAsLoanRecipientUserSuccessDatabaseData(String username) {
		this.username	= username;
	}
	
	/**
	 * RegisterUserAsLoanRecipientUserSuccessDatabaseData's data access methods:
	 */
	public String getUsername() {
		return username;
	}
}
