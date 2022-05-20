package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/**
 * A GoToUpdateProjectFormErrorViewData represents error information associated with
 * a preceding attempt by a LoanRecipientUser to go to the UpdateProjectView for a
 * specific Project.  Right now this would only occur if validation of the ProjectIDNumber
 * associated with the Project failed.  These would not be messages for any User to ever see.
 * The nature of the error messages found would determine what the FrontEnd controller 
 * should do in response.
 * 
 * @author peter
 *
 */
public class GoToUpdateProjectFormErrorViewData extends ViewData {
	
	/**
	 * GoToUpdateProjectFormErrorViewData's member variables:
	 */
	String projectIDNumber;
	ValidationErrorList validationErrorList;
	
	/**
	 * GoToUpdateProjectFormErrorViewData's constructors:
	 */
	public GoToUpdateProjectFormErrorViewData(String projectIDNumber, 
																				   ValidationErrorList validationErrorList) {
		this.projectIDNumber = projectIDNumber;
		this.validationErrorList = validationErrorList;
	}
	
	/**
	 * GoToUpdateProjectFormErrorViewData's data access methods:
	 */
	public String getProjectIDNumber() {
		return projectIDNumber;
	}
	
	public ValidationErrorList getValidationErrorList() {
		return validationErrorList;
	}
}
