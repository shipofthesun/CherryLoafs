package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 * A DefaultUserViewData represents the data needed to populate the default user page.  
 * This class also serves as a message to the FrontEnd that the DefaultUserView should be 
 * displayed as a response.  This includes the SearchBarUIElement centered at the top, space
 * for the ProjectListUIElement or possibly the ProjectListUIElement populated with some 
 * note-worthy Projects judging by some metric(s).
 * 
 * @author peter
 *
 */
public class DefaultUserViewData extends ViewData {
	/**
	 * DefaultUserViewData's member variables:
	 */
	String userName;
	
	/**
	 * DefaultUserViewData's constructors:
	 */
	
	/**
	 * Constructor used to show a User's userName in the UserAccountUIElement at
	 * top right corner of the screen.
	 * 
	 * @param userName
	 */
	public DefaultUserViewData(String userName) {
		this.userName = userName;
	}
	
	/**
	 * DefaultGuestViewData's data access methods:
	 */
	
	/**
	 * Get String representation of a User's userName.  Returns null if userName 
	 * was not provided when this object was instantiated.
	 * 
	 * @return userName or null if userName is not populated.
	 */
	String getUserName() {
		return userName;
	}
}
