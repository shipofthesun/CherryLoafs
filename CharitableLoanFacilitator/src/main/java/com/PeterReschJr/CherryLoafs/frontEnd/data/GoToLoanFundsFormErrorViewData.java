package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/**
 * A GoToLoanFundsFormErrorViewData represents the data needed to populate a 
 * GoToLoanFundsFormErrorView.  This will occur if some ValidationError(s) are detected  
 * related to the projectIDNumber of the Project associated with the LoanFunds.  If the 
 * FrontEnd ever receives this type of ViewData, it should respond by simply canceling the 
 * operation and returning the user or guest back to the default landing page.
 * 
 * @author peter
 *
 */
public class GoToLoanFundsFormErrorViewData extends ViewData{
	
	/**
	 * GoToLoanFundsFormErrorViewData's member variables:
	 */
	String projectIDNumber;
	ValidationErrorList validationErrorList;
	
	/**
	 * GoToLoanFundsFormErrorViewData's constructors:
	 */
	public GoToLoanFundsFormErrorViewData(String projectIDNumber, ValidationErrorList validationErrorList) {
		this.projectIDNumber = projectIDNumber;
		this.validationErrorList = validationErrorList;
	}
	
	/**
	 * GoToLoanFundsFormErrorViewData's data access methods:
	 */
	
	/**
	 * Get String representation of the Project identification number delivered from FrontEnd.
	 * @return projectIDNumber
	 */
	public String getProjectIDNumber() {
		return projectIDNumber;
	}
	
	/**
	 * Get populated validation errors list.
	 * 
	 * @return validationErrorList
	 */
	public ValidationErrorList getValidationErrorList() {
		return validationErrorList;
	}

}
