package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 * A DeleteProjectViewData represents a signal from the FrontEnd that the LoanRecipientUser
 * has asked that the Project with the identification number specified in an object of this class
 * which also exists in their ProjectList of created Projects.
 * 
 * @author peter
 *
 */
public class DeleteProjectViewData extends ViewData {
	
	/**
	 * DeleteProjectViewData's member variables:
	 */
	String projectIDNumber;
	String loanRecipientUserCreatorIDNumber;
	
	/**
	 * DeleteProjectViewData's constructors:
	 */
	public DeleteProjectViewData(String projectIDNumber, String loanRecipientUserCreatorIDNumber) {
		this.projectIDNumber = projectIDNumber;
		this.loanRecipientUserCreatorIDNumber = loanRecipientUserCreatorIDNumber;
	}
	
	/**
	 * DeleteProjectViewData's data access methods:
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
	 * @return loanRecipientUserCreatorIDNumber
	 */
	public String getLoanRecipientUserCreatorIDNumber() {
		return loanRecipientUserCreatorIDNumber;
	}
	
}
