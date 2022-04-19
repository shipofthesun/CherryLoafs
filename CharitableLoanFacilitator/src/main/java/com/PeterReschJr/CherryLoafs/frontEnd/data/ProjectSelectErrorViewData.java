package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/**
 * A ProjectSelectErrorViewData represents Error data that was reported during Validation of
 * a Project identification number.
 * 
 * @author peter
 *
 */
public class ProjectSelectErrorViewData extends ViewData {
	
	/**
	 * ProjectSelectErrorViewData's member variables:
	 */
	String projectIDNumber;						 	// String representation of Project identification 
																     	// number.
	ValidationErrorList validationErrorList;		// List of ValidationErrors detected.
	
	/**
	 * ProjectSelectErrorViewData's constructors:
	 */
	public ProjectSelectErrorViewData(String projectIDNumber, ValidationErrorList validationErrorList) {
		this.projectIDNumber = projectIDNumber;
		this.validationErrorList = validationErrorList;
	}
	
	/**
	 * ProjectSelectErrorViewData's data access methods:
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
	 * @return validationErrorList
	 */
	public ValidationErrorList getValidationErrorList() {
		return validationErrorList;
	}
	
	
}
