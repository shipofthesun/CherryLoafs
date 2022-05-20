package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/**
 * A GoToRegisterAsLoanRecipientFormFailureViewData represents a signal to the FrontEnd that
 * validation errors were encountered while attempting to authorize the 
 * RegisterAsLoanRecipientFormView to be loaded.  Currently, this can never be triggered
 * as their are no actual data fields to validate at this time.  This class exists for possible future 
 * use.
 * 
 * @author peter
 *
 */
public class GoToRegisterAsLoanRecipientFormFailureViewData extends ViewData {
	
	/**
	 * GoToRegisterAsLoanRecipientFormFailureViewData's member variables:
	 */
	ValidationErrorList validationErrorList;
	
	/**
	 * GoToRegisterAsLoanRecipientFormFailureViewData's constructors:
	 */
	public GoToRegisterAsLoanRecipientFormFailureViewData(ValidationErrorList validationErrorList) {
		this.validationErrorList = validationErrorList;
	}
	
	/**
	 * GoToRegisterAsLoanRecipientFormErrorViewData data access methods:
	 */
	public ValidationErrorList getValidationErrorList() {
		return validationErrorList;
	}
}
