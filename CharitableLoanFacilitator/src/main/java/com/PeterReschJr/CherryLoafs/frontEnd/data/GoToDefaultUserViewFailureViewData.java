package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/**
 * A GoToDefaultUserViewFailureViewData represents a signal to the FrontEnd that the
 * attempt to load the DefaultUserView was unsuccessful due to validationErrors detected.
 * 
 * @author peter
 *
 */
public class GoToDefaultUserViewFailureViewData extends ViewData {
	/**
	 * GoToDefaultUserViewFailureViewData's member variables:
	 */
	ValidationErrorList validationErrorList;
	
	/**
	 * GoToDefaultUserViewFailureViewData's constructors:
	 */
	
	/**
	 * Single constructor requiring a ValidationErrorList to set local validationErrorList.
	 * 
	 * @param validationErrorList
	 */
	public GoToDefaultUserViewFailureViewData(ValidationErrorList validationErrorList) {
		this.validationErrorList = validationErrorList;
	}
	
	/**
	 * GoToDefaultGuestViewFailureViewData's data access methods:
	 */
	
	/**
	 * 
	 * @return validationErrorList
	 */
	public ValidationErrorList getValidationErrorList() {
		return validationErrorList;
	}
	
}
