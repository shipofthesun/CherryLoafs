package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/**
 * A LoanRecipientUserValidationFailureViewData represents data needed to populate a 
 * FrontEnd LoanRecipientUserValidationFailureView.  This class also serves as a signal to the
 * FrontEnd that when an object of this type is received as a response, the User's attempt
 * to register as a LoanRecipientUser has ended in failure due to User input validation failing.
 * 
 * @author peter
 *
 */
public class LoanRecipientUserValidationFailureViewData extends ViewData {

	/**
	 * LoanRecipientUserValidationFailureViewData's member variables:
	 */
	ValidationErrorList validationErrorList;
	
	/**
	 * LoanRecipientUserValidationFailureViewData's constructors:
	 */
	public LoanRecipientUserValidationFailureViewData(ValidationErrorList validationErrorList) {
		this.validationErrorList = validationErrorList;
	}
	
	/**
	 * LoanRecipientUserValidationFailureViewData's data access methods:
	 */
	public ValidationErrorList getValidationErrorList() {
		return validationErrorList;
	}

}
