package com.PeterReschJr.CherryLoafs.validation.datastructs;

import java.util.ArrayList;

import com.PeterReschJr.CherryLoafs.validation.ValidationError;

/**
 * A ValidationErrorList represent a list of ValidationErrors created during the execution of a
 * persist method in the Validator class.
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
	 * ValidationErrorList's constructors:
	 */
	
	/**
	 * Simple constructor to instantiate validationErrorArrayList.
	 */
	public ValidationErrorList() {
		validationErrorArrayList = new ArrayList<ValidationError>();
	}
	
	/**
	 * Constructor providing initial ValidationError to be stored in validationErrorArrayList.
	 * 
	 * @param validationError
	 */
	public ValidationErrorList(ValidationError validationError) {
		validationErrorArrayList = new ArrayList<ValidationError>();
		validationErrorArrayList.add(validationError);
	}
	
	/**
	 * ValidationErrorList's primary functionality methods:
	 */

	/**
	 * Adds a new ValidationError to validationErrorArrayList.
	 * 
	 * @param validationError
	 */
	public void add(ValidationError validationError) {
		validationErrorArrayList.add(validationError);
	}
	
}
