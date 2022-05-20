package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.search.datastructs.KeywordList;
import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/**
 * An UpdateProjectFormErrorViewData represents a set of data needed to populate a
 * FrontEnd UpdateProjectFormErrorView.  It also serves as a signal to the FrontEnd that 
 * validation of the fields entered by the LoanRecipientUser attempting to update information
 * about an existing account has failed due to errors detected while validating input.  A
 * UpdateProjectFormErrorView should be displayed
 * 
 * @author peter
 *
 */
public class UpdateProjectFormErrorViewData extends ViewData {

	/**
	 * UpdateProjectFormErrorViewData's member variables:
	 */
	String projectName;
	String projectDescription;
	String projectGoalAmount;
	KeywordList keywordList;
	ValidationErrorList validationErrorList;
	
	/**
	 * UpdateProjectFormErrorViewData's constructors:
	 */
	public UpdateProjectFormErrorViewData(String projectName, String projectDescription, 
																		  String projectGoalAmount, 
																		  KeywordList keywordList,
																		  ValidationErrorList validationErrorList) {
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectGoalAmount = projectGoalAmount;
		this.keywordList = keywordList;
		this.validationErrorList = validationErrorList;
	}
	
	/**
	 * UpdateProjectFormErrorViewData's data access methods:
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
	 * @return validationErrorList
	 */
	public ValidationErrorList getValidationErrorList() {
		return validationErrorList;
	}
}
