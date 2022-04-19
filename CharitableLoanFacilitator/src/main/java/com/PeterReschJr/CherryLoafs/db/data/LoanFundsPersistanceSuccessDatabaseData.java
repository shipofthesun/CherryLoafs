package com.PeterReschJr.CherryLoafs.db.data;

/**
 * A LoanFundsPersistanceSuccessDatabaseData represents Data from the Database needed 
 * in order to confirm with caller that LoanFunds persistence was successful.  Returned by
 * 
 * 
 * @author peter
 *
 */
public class LoanFundsPersistanceSuccessDatabaseData extends DatabaseData {
	
	/**
	 * LoanFundsPersistanceSuccessDatabaseData's member variables:
	 */
	String projectName;									// Name of the Project.
	String projectCreatorUserName;				// User name of the LoanRecipientUser who created
																		// the Project.
	String loanAmount;									// Currency Amount given in LoanFund
	String projectGoalAmount;						// The total Goal Amount of LoanFunds specified by
																		// Project.
	String projectCurrentTotalAmount;			// The current running collected total of LoanFunds 
																		// toward the Project.
	
	/**
	 * LoanFundsPersistanceSuccessDatabaseData's constructors:
	 */
	
	/**
	 * Constructor providing all required fields to be returned from a call to persist a LoanFunds
	 * to the Database where the transaction was successful.
	 * 
	 * @param projectName
	 * @param projectCreatorUserName
	 * @param loanAmount
	 * @param projectGoalAmount
	 * @param projectCurrentTotalAmount
	 */
	public LoanFundsPersistanceSuccessDatabaseData(String projectName, 
																						   String projectCreatorUserName,
																						   String loanAmount,
																						   String projectGoalAmount,
																						   String projectCurrentTotalAmount) {
		this.projectName = projectName;
		this.projectCreatorUserName = projectCreatorUserName;
		this.loanAmount = loanAmount;
		this.projectGoalAmount = projectGoalAmount;
		this.projectCurrentTotalAmount = projectCurrentTotalAmount;
	}
	
	/**
	 * LoanFundsPersistanceSuccessDatabaseData's data access methods:
	 */
	
	public String getProjectName() {
		return projectName;
	}
	
	public String getProjectCreatorUserName() {
		return projectCreatorUserName;
	}
	
	
	public String getLoanAmount() {
		return loanAmount;
	}
	public String getProjectGoalAmount() {
		return projectGoalAmount;
	}
	public String getProjectCurrentTotalAmount() {
		return projectCurrentTotalAmount;
	}
	
	
}
