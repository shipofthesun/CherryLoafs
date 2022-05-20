package com.PeterReschJr.CherryLoafs.db.data;

/**
 * A UserFoundDatabaseData represents data from the Database that needs to be delivered
 * when a Guest's attempt to Login as User is a success.  Objects of this type received as output 
 * from the Database also signal to the caller the outcome of the operation.  This includes
 * basic User information needed to populate the User's homepage with personalized 
 * information.  That only includes a userName currently to be displayed at top right corner.
 * 
 * @author peter
 */
public class UserFoundDatabaseData extends DatabaseData {
	
	/**
	 * UserFoundDatabaseData's member variables:
	 */
	String userName;
	
	/**
	 * UserFoundDatabaseData's constructors:
	 */
	public UserFoundDatabaseData(String userName) {
		this.userName = userName;
	}
	
	/**
	 * UserFoundDatabaseData's data access methods:
	 */
	public String getUserName() {
		return userName;
	}
	
}
