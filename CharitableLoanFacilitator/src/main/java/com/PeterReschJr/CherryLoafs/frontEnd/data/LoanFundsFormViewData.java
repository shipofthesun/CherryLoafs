package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 * A LoanFundsCreationFormViewData represents the data needed to populate a 
 * LoanFundsCreationFormView.
 * 
 * @author peter
 *
 */
public class LoanFundsFormViewData extends ViewData {

	/**
	 * LoanFundsCreationFormViewData's member variables:
	 */
	String projectIDNumber;		
	String amount;
	String loanerIDNumber;		// userID number of the user making the loan.  This field will 
													// be null the case of a Guest Loaning Funds.  This also indicates
													// that the LoanFund is being created anonymously.
	
	/**
	 * LoanFundsCreationFormViewData's constructors:
	 */
	
	/**
	 * Constructor to create new instance with only projectIDNumber and amount specified.
	 * This is used by a Guest to "anonymously" create LoanFunds towards a Project.  The
	 * loanerIDNumber is automatically set to null.
	 */
	public LoanFundsFormViewData(String projectIDNumber, String amount) {
		this.projectIDNumber = projectIDNumber;
		this.amount = amount;
		loanerIDNumber = null;
	}
	
	/**
	 * Constructor create an object with only the projectIDNumber specified.  This indicates 
	 * that a blank LoanFundsForm for the specified Project should be shown.
	 * 
	 * @param projectIDNumber
	 */
	public LoanFundsFormViewData(String projectIDNumber) {
		this.projectIDNumber = projectIDNumber;
		this.amount = 0;
		loanerIDNumber = null;
	}
	
	/**
	 * LoanFundsCreationFormViewData's data access methods:
	 */
	
	/**
	 * 
	 * @return projectIDNumber
	 */
	public String getProjectIDNumber() {
		return projectIDNumber;
	}
	
	/**
	 * 
	 * @return amount
	 */
	public String getAmount() {
		return amount;
	}
	
	/**
	 * 
	 * @return loanerIDNumber
	 */
	public String getLoanerIDNumber() {
		return loanerIDNumber;
	}
}
