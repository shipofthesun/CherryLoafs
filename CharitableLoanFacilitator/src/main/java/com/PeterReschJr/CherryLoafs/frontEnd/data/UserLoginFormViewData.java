package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 * A UserLoginFormViewData represents data needed to populate a LoginView in FrontEnd.
 * 
 * @author peter
 *
 */
public class UserLoginFormViewData extends ViewData {
	
	/**
	 * LoginViewData's member variables:
	 */
	String userName;
	String password;
	
	/**
	 * LoginViewData's constructors:
	 */
	public UserLoginFormViewData(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * LoginViewData's data access functions:
	 */
	
	/**
	 * Get String representation of UserName.
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
}
