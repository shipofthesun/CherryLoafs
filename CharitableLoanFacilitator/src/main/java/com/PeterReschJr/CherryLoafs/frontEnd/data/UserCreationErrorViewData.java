package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/**
 * A UserCreationErrorViewData represents data related to errors found during User Creation.
 * This includes some of the data fields entered to be re-populated in the 
 * UserCreationErrorView.
 * @author peter
 *
 */
public class UserCreationErrorViewData extends ViewData {
	
	/**
	 * UserCreationErrorViewData's member variables:
	 */
	String firstName;
	String lastName;
	String email;
	String password;
	ValidationErrorList validationErrorList;
	final String GENERIC_USER_CREATION_OPERATION_FAILURE_MESSAGE = 
			"The User Creation Operation was unsuccessful.  Please try again.";
	
	/**
	 * UserCreationErrorViewData's constructors:
	 */
	
	/**
	 * Constructor to instantiate all member variables along with a ValidationErrorList containing
	 * validation errors detected during user creation form field validation.  Used during user
	 * creation to return a validation errors view to the user allowing them to correct errors and
	 * resubmit if desired.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param validationErrorList
	 */
	public UserCreationErrorViewData(String firstName, String lastName, String email, String password,
												   ValidationErrorList validationErrorList) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.validationErrorList = validationErrorList;
	}
	
	/**
	 * Constructor used when the response to be sent back as a result of a Guest attempting to register
	 * as a User causes a GENERIC_USER_CREATION_OPERATION_FAILURE_MESSAGE
	 * and a prompt to retry user creation.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 */
	public UserCreationErrorViewData(String firstName, String lastName, String email, 
														String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		validationErrorList = null;
	}
	
	/**
	 * UserCreationErrorViewData's data access function:
	 */
	
	/**
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Used to print generic user creation failure message to FrontEnd output.
	 * 
	 * @return GENERIC_USER_CREATION_OPERATION_FAILURE_MESSAGE
	 */
	public String getGenericUserCreationErrorMessage() {
		return GENERIC_USER_CREATION_OPERATION_FAILURE_MESSAGE;
	}
}
