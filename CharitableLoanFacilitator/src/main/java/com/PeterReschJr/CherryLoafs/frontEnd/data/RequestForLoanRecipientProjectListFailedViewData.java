package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/**
 * A RequestForLoanRecipientProjectListFailedViewData represents a signal to the FrontEnd
 * that validation of the input used to look up failed due to errors detected.  The error list
 * is returned.  This information should likely not be for the User to see most likely as they
 * did not enter any of the input values.
 * 
 * @author peter
 *
 */
public class RequestForLoanRecipientProjectListFailedViewData extends ViewData {
	
	/**
	 * RequestForLoanRecipientProjectListFailedViewData's member variables:
	 */
	ValidationErrorList validationErrorList;
	
	/*
	 * RequestForLoanRecipientProjectListFailedViewData's constructors:
	 */
	public RequestForLoanRecipientProjectListFailedViewData(ValidationErrorList 
																															validationErrorList) {
		this.validationErrorList = validationErrorList;
	}
	
	/*
	 * RequestForLoanRecipientProjectListFailedViewData's data access methods:
	 */
	public ValidationErrorList getValidationErrorList() {
		return validationErrorList;
	}
	
}
