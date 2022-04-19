package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 * A GenericDatabaseErrorViewData represents the data needed to populate a 
 * GenericDatabaseErrorView.
 * 
 * @author peter
 *
 */
public class GenericDatabaseErrorViewData extends ViewData {
	
	/**
	 * GenericDatabaseErrorViewData member variables.
	 */
	final String MESSAGE = "An Error Occured while attempting to comunicate with the database.  Please try again later.";
	
	
	/**
	 * GenericDatabaseErrorViewData data access methods:
	 * 
	 */
	public String getErrorMessage() {
		return MESSAGE;
	}
}
