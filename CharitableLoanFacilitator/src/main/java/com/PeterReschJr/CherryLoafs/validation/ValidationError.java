package com.PeterReschJr.CherryLoafs.validation;

/**
 * A ValidationError represents an issue found during validation.
 * 
 * @author peter
 *
 */
public class ValidationError {
	
	/**
	 * ValidationError's member variables:
	 */
	String validationErrorName;
	String validationErrorDescription;
	String validationErrorMessage;
	
	/**
	 * ValidationError's constructors:
	 */
	public ValidationError(String validationErrorName, String validationErrorDescription
																									, String validationErrorMessage) {
		this.validationErrorName = validationErrorName;
		this.validationErrorDescription = validationErrorDescription;
		this.validationErrorMessage = validationErrorMessage;
	}
}
