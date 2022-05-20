package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 * A RequestLoanRecipientProjectListViewData represents data from the FrontEnd used
 * to determine what Projects should be returned as a result the LoanRecipientUser's request
 * to view a list of the Projects that they have created.
 * 
 * @author peter
 *
 */
public class RequestLoanRecipientProjectListViewData extends ViewData {
	
	/**
	 * RequestLoanRecipientProjectListViewData's member variables:
	 */
	// Value will be supplied by Session or Request by FrontEnd.
	String userIDNumber;		// User identification number of the LoanRecipientUser
	
	/**
	 * RequestLoanRecipientProjectListViewData's constructors:
	 */
	
	/**
	 * Constructor used when providing a userIDNumber to search for related Projects in the
	 * Database.
	 * 
	 * @param userIDNumber
	 */
	public RequestLoanRecipientProjectListViewData(String userIDNumber) {
		this.userIDNumber = userIDNumber;
	}
	
	/**
	 * RequestLoanRecipientProjectListViewData's data access methods:
	 */
	
	/**
	 * 
	 * @return userIDNumber
	 */
	public String getUserIDNumber() {
		return userIDNumber;
	}
}
