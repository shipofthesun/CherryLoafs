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
	String userFirstName;
	String userLastName;
	String userName;
	
	/**
	 * DefaultUserViewData's constructors:
	 */
	
	/**
	 * Constructor used to show a User's first and last name in the UserAccountUIElement at
	 * top right corner of screen.
	 * 
	 * @param userFirstName
	 * @param userLastName
	 */
	public DefaultUserViewData(String userFirstName, String userLastName) {
		this.userFirstName = userFirstName;
		this.userLastName =userLastName;
		userName = null;
	}
	
	/**
	 * Constructor used to show a User's userName in the UserAccountUIElement at
	 * top right corner of the screen.
	 * 
	 * @param userName
	 */
	public DefaultUserViewData(String userName) {
		this.userName = userName;
		userFirstName = null;
		userLastName = null;
	}
	
	/**
	 * DefaultGuestViewData's data access methods:
	 */
	
	/**
	 * Get String representation of a User's first name.  Returns null if the userFirstName 
	 * was not provided when this object was instantiated.
	 * 
	 * @return userFirstName or null if userFirstName is not populated.
	 */
	String getUserFirstName() {
		return userFirstName;
	}
	
	/**
	 * Get String representation of a User's last name.  Returns null if userLastName 
	 * was not provided when this object was instantiated.
	 * 
	 * @return userLastName or null if userLastName is not populated.
	 */
	String getUserLastName() {
		return userLastName;
	}
	
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
