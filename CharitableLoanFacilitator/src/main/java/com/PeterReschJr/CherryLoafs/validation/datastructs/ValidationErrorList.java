package com.PeterReschJr.CherryLoafs.validation.datastructs;

import java.util.ArrayList;

import com.PeterReschJr.CherryLoafs.validation.ValidationError;

/**
 * A ValidationErrorList represent a list of ValidationErrors found during validation.
 * 
 * @author peter
 *
 */
public class ValidationErrorList {

	/**
	 * ValidationErrorList's member variables:
	 */
	ArrayList<ValidationError> validationErrorArrayList;
	
	/**
	 * Adds a new ValidationError to validationErrorArrayList.
	 * @param validationError
	 */
	public void add(ValidationError validationError) {
		validationErrorArrayList.add(validationError);
	}
	
}
