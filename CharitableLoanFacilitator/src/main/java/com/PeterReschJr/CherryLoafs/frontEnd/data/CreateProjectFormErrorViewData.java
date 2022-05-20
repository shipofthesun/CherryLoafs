package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/**
 * A CreateProjectFormErrorViewData represents a set of data needed to populate a FrontEnd
 * CreateProjectFormErrorView.  It also serves as a signal to the FrontEnd that when an object
 * of this type is received, a CreateProjectFormErrorView should be displayed to the 
 * LoanRecipientUser populated by the data set in CreateProjectFormErrorViewData.
 * @author peter
 *
 */
public class CreateProjectFormErrorViewData extends ViewData {
	
	/**
	 * CreateProjectFormErrorViewData's member variables:
	 */
	ValidationErrorList validationErrorList;
	
	/**
	 * CreateProjectFormErrorViewData's constructors:
	 */
	public CreateProjectFormErrorViewData(ValidationErrorList validationErrorList) {
		this.validationErrorList = validationErrorList;
	}
	
	/**
	 * CreateProjectFormErrorViewData's data access methods:
	 */
	public ValidationErrorList getValidationErrorList() {
		return validationErrorList;
	}
}
