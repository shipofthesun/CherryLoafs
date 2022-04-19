package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 * A GenericLoanTransactionFailedViewData represents data needed to populate a 
 * GenericLoanTransactionFailedView.  This class also serves as a signal to the FrontEnd that 
 * when this object is returned an attempt to loan funds towards a Project was unsuccessful
 * due to an unspecified error.  This will serve as a catch all for errors that are not a specific
 * type of error.
 * 
 * @author peter
 *
 */
public class GenericLoanTransactionFailedViewData extends ViewData {

	/**
	 * GenericLoanTransactionFailedView's messages:
	 */
	final String GENERIC_LOAN_TRANSACTION_FAILED_MESSAGE = "The attempt to loan funds"
										   + " towards this Project has ended in failure.  Please try again later.";
	
	/**
	 * GenericLoanTransactionFailedView's member variables:
	 */
	String projectName;	// Name of Project not successfully loaned to.
	String amount;			// Guest or user input amount for attempted LoanFunds
	
	/**	
	 * GenericLoanTransactionFailedView's constructors:																										
	 */
	
	public GenericLoanTransactionFailedViewData(String projectName, String amount) {
		this.projectName = projectName;
		this.amount = amount;
	}
	
	/**
	 * GenericLoanTransactionFailedViewData's data access methods:
	 */
	public String getProjectName() {
		return projectName;
	}
	
	public String getAmount() {
		return amount;
	}
	public String getGenericFailureMessage() {
		return GENERIC_LOAN_TRANSACTION_FAILED_MESSAGE;
	}
}
