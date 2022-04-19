package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 * A LoginFailureViewData represents data needed to populate a FrontEnd LoginFailureView.
 * It also serves as a message that a login attempt was unsuccessful.  
 * @author peter
 *
 */
public class LoginFailureViewData extends ViewData {
	
	/**
	 * LoginFailureViewData's member variables:
	 */
	final String GENERIC_LOGIN_FAILURE_MESSAGE = "Login could not be completed.";
			
	/**
	 * LoginFailureViewData's constructors:		
	 */
	public LoginFailureViewData() {
		
	}
	
	public String getGenericErrorMessage() {
		return GENERIC_LOGIN_FAILURE_MESSAGE;
	}
}
