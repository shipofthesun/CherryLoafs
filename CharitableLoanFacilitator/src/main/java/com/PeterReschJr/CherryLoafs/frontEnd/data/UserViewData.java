package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 * A GuestViewData represents data needed to populate a UserView.
 * 
 * @author peter
 *
 */
public class UserViewData extends ViewData {
	
	/**
	 * GuestViewData's member variables:
	 */
	String searchString;
	
	/**
	 * GuestViewData's constructors:
	 */
	
	/**
	 * Used to create a GuestViewData object that will represent
	 * @param searchString
	 */
	public UserViewData(String searchString) {
		this.searchString = searchString;
	}
	
	/**
	 * Data access functions:
	 */
	public String getSearchString() {
		return searchString;
	}
}
