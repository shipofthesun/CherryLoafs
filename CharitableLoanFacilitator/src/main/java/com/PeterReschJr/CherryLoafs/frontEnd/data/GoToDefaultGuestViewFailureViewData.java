package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/**
 * A GoToDefaultGuestViewFailureViewData represents a signal to the FrontEnd that the
 * Guest's default view has failed to load.  The specific errors are contained in the 
 * validationErrorList, and the FrontEnd 
 * @author peter
 *
 */
public class GoToDefaultGuestViewFailureViewData extends ViewData{
	
	/**
	 * GoToDefaultGuestViewFailureViewData's member variables:
	 */
	ValidationErrorList validationErrorList;
	
	/**
	 * GoToDefaultGuestViewFailureViewData's constructors:
	 */
	
	/**
	 * Single constructor requiring a ValidationErrorList to set local validationErrorList.
	 * @param validationErrorList
	 */
	public GoToDefaultGuestViewFailureViewData(ValidationErrorList validationErrorList) {
		this.validationErrorList = validationErrorList;
	}
	
	/**
	 * GoToDefaultGuestViewFailureViewData's data access methods:
	 */
	
	/**
	 * 
	 * @return
	 */
	public ValidationErrorList getValidationErrorList() {
		return validationErrorList;
	}
}
