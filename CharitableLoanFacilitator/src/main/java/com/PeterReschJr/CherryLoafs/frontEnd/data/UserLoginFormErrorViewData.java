package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/**
 * A UserLoginFormErrorViewData represents data needed to populate a 
 * UserLoginFormErrorView.  An object of this type is also used as a signal to the 
 * FrontEnd that User login form validation has failed and the contents of the member variable 
 * validationErrorList should be used to provide input error messages and allow the Guest to 
 * resubmit.
 * 
 * @author peter
 *
 */
public class UserLoginFormErrorViewData extends ViewData {
	
	/**
	 * UserLoginFormErrorViewData's member variables:
	 */
	String userName;
	ValidationErrorList validationErrorList;
	
	/**
	 * UserLoginFormErrorViewData's constructors:
	 */
	public UserLoginFormErrorViewData(String userName, ValidationErrorList validationErrorList) {
		this.userName = userName;
		this.validationErrorList = validationErrorList;
	}
	
	/**
	 * UserLoginFormErrorViewData's data access methods:
	 */
	
	/**
	 * Get the String entered into the username field by the Guest.
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Get the list of errors found during login form validation.
	 * 
	 * @return
	 */
	public ValidationErrorList getValidationErrorList() {
		return validationErrorList;
	}
}
