package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.frontEnd.data.ViewData;
import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/**
 * A GoToUserCreationFormFailureViewData represents a signal to the FrontEnd that the 
 * the Guest's attempt to view the UserCreationFormView has failed for some generic 
 * reason.  This represents a catch all for any errors that might occur.
 * 
 * @author peter
 *
 */
public class GoToUserCreationFormFailureViewData extends ViewData {
	
	/**
	 * GoToUserCreationFormFailureViewData's messages:
	 */
	final String GENERIC_FAILED_TO_LOAD_USER_CREATION_FORM =
					  "The User Registration Form was not able to be retrieved.  Please try again later.";
	
	/**
	 * GoToUserCreationFormFailureViewData's member variables:
	 */
	ValidationErrorList validationErrorList;				// List of errors detected during User Creation 
																				// Form field validation.
	
	/**
	 * GoToUserCreationFormFailureViewData constructors:
	 */
	public GoToUserCreationFormFailureViewData(ValidationErrorList validationErrorList) {
		this.validationErrorList = validationErrorList;
	}
	
	/**
	 * GoToUserCreationFormFailureViewData's data access variables:
	 */
	public String getGenericFailureMessage() {
		return GENERIC_FAILED_TO_LOAD_USER_CREATION_FORM;
	}
	
	public String getValidationErrorList() {
		return validationErrorList;
	}
}
