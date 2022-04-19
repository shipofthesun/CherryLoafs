package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/**
 * A LoanFundsFormErrorViewData represents data required to populate a FrontEnd
 * LoanFundsErrorView.
 * 
 * @author peter
 *
 */
public class LoanFundsFormErrorViewData  extends ViewData {
	
	/**
	 * LoanFundsFormErrorViewData's member variables:
	 */
	String projectIDNumber;							// Identification number of project LoanFunds were attempted to be created towards.
	String amount;											// Amount that was attempted to be loaned as Loan funds to Project.
	ValidationErrorList validationErrorList;		// The list of validation errors found during validation of projectIDNumber and amount entered by the Guest.
	
	/**
	 * LoanFundsFormErrorViewData's constructors:
	 */
	public LoanFundsFormErrorViewData(String projectIDNumber, String amount, 
																							ValidationErrorList validationErrorList) {
		this.projectIDNumber = projectIDNumber;
		this.amount = amount;
		this.validationErrorList = validationErrorList;
	}
	
	/**
	 * LoanFundsFormErrorViewData's data access methods:
	 */
	public String getProjectIDNumber() {
		return projectIDNumber;
	}
	
	public ValidationErrorList getValidationErrorList() {
		return validationErrorList;
	}
	
}
