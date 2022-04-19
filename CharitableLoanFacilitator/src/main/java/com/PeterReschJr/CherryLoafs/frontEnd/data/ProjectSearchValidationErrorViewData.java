package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/**
 * A ProjectSearchValidationErrorViewData represents data needed
 * @author peter
 *
 */
public class ProjectSearchValidationErrorViewData extends ViewData {
	
	/**
	 * ProjectSearchValidationErrorViewData's member variables:
	 */
	String searchTerm;
	ValidationErrorList validationErrorList;			// List of ValidationErrors
	
	/**
	 * ProjectSearchValidationErrorViewData's constructors:
	 */
	public ProjectSearchValidationErrorViewData(String searchTerm, 
																							ValidationErrorList validationErrorList) {
		this.searchTerm = searchTerm;
		this.validationErrorList = validationErrorList;
	}
	
	/**
	 * Data access methods:
	 */
	
	public String getSearchTerm() {
		return searchTerm;
	}
	public ValidationErrorList getValidationErrorList() {
		return validationErrorList;
	}
}
