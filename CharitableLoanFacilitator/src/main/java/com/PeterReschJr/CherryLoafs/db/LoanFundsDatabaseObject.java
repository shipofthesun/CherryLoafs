package com.PeterReschJr.CherryLoafs.db;

/**
 * A LoanFundsDatabaseObject represents a LoanFunds data object in the database.
 * 
 * @author peter
 *
 */
public class LoanFundsDatabaseObject extends DatabaseObject {
	
	/**
	 * LoanFundsDatabaseObject's member variables:
	 */
	String projectIDNumber;		
	String amount;
	String loanerIDNumber;		// userID number of the user making the loan.  This field would 
													// be null the case of a Guest Loaning Funds.  This also indicates
													// that a LoanFunds is anonymous.
	
	/**
	 * LoanFundsDatabaseObject's constructors:
	 */
	
	/**
	 * Constructor currently called only by Guest to make an "anonymous" Loan towards a Project.
	 * 
	 * @param projectIDNumber
	 * @param amount
	 */
	public LoanFundsDatabaseObject(String projectIDNumber, String amount) {
		this.projectIDNumber = projectIDNumber;
		this.amount = amount;
		loanerIDNumber = null;
	}
	
	/**
	 * LoanFundsDatabaseObject's data access methods:
	 */
	public String getProjectIDNumber() {
		return projectIDNumber;
	}
	
	public String getAmount() {
		return amount;
	}
	
	/**
	 * Get loanerIDNumberReturns; this field will be null if the LoanFunds were made 
	 * anonymously.
	 * 
	 * @return loanerIDNumber
	 */
	public String getLoanerIDNumber() {
		return loanerIDNumber;
	}
	
}
