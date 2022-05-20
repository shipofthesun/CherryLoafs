package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.search.datastructs.KeywordList;

/**
 * A CreateProjectFormViewData represents input data from the FrontEnd entered by 
 * a LoanRecipientUser in an attempt to create a new Project.
 * 
 * @author peter
 *
 */
public class CreateProjectFormViewData extends ViewData {

	/**
	 * CreateProjectFormViewData's member variables:
	 */
	// User input members.
	String projectName;									// Name of the Project.
	String projectDescription;							// Description of the Project.
	String projectGoalAmount;						// Funding raising goal of Project.
	KeywordList keywordList;							// List of keywords that the LoanRecipientUser 
																		// filling out the form wishes to initialize the Projects
																		// KeywordList with.
	
	// Need to be provided from session data/request object.
	String loanRecipientUserIDNumber;		// The ID number of the LoanRecipientUser who 
																		// filled out the form.				
	
	/**
	 * CreateProjectFormViewData's constructors:
	 */
	
	/**
	 * 
	 * @param projectName
	 * @param projectDescription
	 * @param projectGoalAmount
	 * @param keywordList
	 */
	public CreateProjectFormViewData(String projectName, String projectDescription,
																String projectGoalAmount, KeywordList keywordList) {
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectGoalAmount = projectGoalAmount;
		this.keywordList = keywordList;
	}
	
	/**
	 * CreateProjectFormViewData's data access methods:
	 */
	
	/**
	 * 
	 * @return projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	
	/**
	 * 
	 * @return projectDescription
	 */
	public String getProjectDescription() {
		return projectDescription;
	}
	
	/**
	 * 
	 * @return projectGoalAmount
	 */
	public String getProjectGoalAmount() {
		return projectGoalAmount;
	}
	
	/**
	 * 
	 * @return keywordList
	 */
	public KeywordList getKeywordList() {
		return keywordList;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLoanRecipientUserIDNumber() {
		return loanRecipientUserIDNumber;
	}
	
	
	
	
}
