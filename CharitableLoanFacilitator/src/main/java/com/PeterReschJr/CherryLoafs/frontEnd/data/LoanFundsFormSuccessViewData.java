package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.db.data.LoanFundsPersistanceSuccessDatabaseData;

/**
 * A LoanFundsFormSuccessViewData represents the data needed to populate a FrontEnd
 * LoanFundsFormSuccessView.  It also serves as a signal to the FrontEnd that the Guest or
 * User's loan attempt was successful and 
 * 
 * @author peter
 *
 */
public class LoanFundsFormSuccessViewData extends ViewData {
	
	/**
	 * LoanFundsFormSuccessViewData's messages:
	 */
	final String LOAN_SUCCESS_MESSAGE = "Loan successfully contributed!  Thank you so much"
																		+ "for your support of this Project's efforts!";
	/**
	 * LoanFundsFormSuccessViewData's member variables:
	 */
	String projectName;
	String projectCreatorName;
	String amount;											// Amount successfully Loaned.
	String projectGoalAmount;
	String projectCurrentTotalAmount;
	
	/**
	 * LoanFundsFormSuccessViewData's constructors:
	 */
	
	/**
	 * 
	 * @param loanFundsPersistanceSuccessDatabaseData
	 */
	public LoanFundsFormSuccessViewData(LoanFundsPersistanceSuccessDatabaseData 
																				loanFundsPersistanceSuccessDatabaseData) {
		this.projectName = loanFundsPersistanceSuccessDatabaseData.getProjectName();
		this.projectCreatorName = loanFundsPersistanceSuccessDatabaseData.getProjectCreatorUserName();
		this.amount = loanFundsPersistanceSuccessDatabaseData.getLoanAmount();
		this.projectGoalAmount = loanFundsPersistanceSuccessDatabaseData.getProjectGoalAmount();
		this.projectCurrentTotalAmount = loanFundsPersistanceSuccessDatabaseData.getProjectCurrentTotalAmount();
	}
	
	/**
	 * LoanFundsFormSuccessViewData's data access methods:
	 */
	public String getProjectName() {
		return projectName;
	}
	
	public String getProjectCreatorName() {
		return projectCreatorName;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public String getProjectGoalAmount() {
		return projectGoalAmount;
	}
	
	public String getProjectCurrentTotalAmount() {
		return projectCurrentTotalAmount;
	}
	
	public String getSuccessMessage() {
		return LOAN_SUCCESS_MESSAGE;
	}
}
