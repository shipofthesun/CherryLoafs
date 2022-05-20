package com.PeterReschJr.CherryLoafs.db.data;

/**
 * A LoanRecipientRegistrationSuccessDatabaseData represents a signal to the caller that
 * the requested operation to update the User to LoanRecipientUser status was a success.  The
 * DatabaseData object will contain all necessary information needed to populate the 
 * DefaultLoanRecipientUserView, which is where the newly upgraded LoanRecipientUser will
 * currently be redirected to after successful registration.
 * 
 * @author peter
 *
 */
public class LoanRecipientRegistrationSuccessDatabaseData extends DatabaseData {
	
	/**
	 * LoanRecipientRegistrationSuccessDatabaseData's member variables:
	 */
	String userName;
	
	/**
	 * LoanRecipientRegistrationSuccessDatabaseData's constructors:
	 */
	public LoanRecipientRegistrationSuccessDatabaseData(String userName) {
		this.userName = userName;
	}
	
	/**
	 * LoanRecipientRegistrationSuccessDatabaseData's data access methods:
	 */
	
	/**
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
}
