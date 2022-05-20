package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 * A GoToUpdateProjectFormViewData represents data sent from the FrontEnd signaling that
 * a LoanRecipientUser wishes to update the Project with a provided projectIDNumber.
 * 
 * @author peter
 *
 */
public class GoToUpdateProjectFormViewData {
	
	/**
	 * GoToUpdateProjectFormViewData's member variables:
	 */
	
	// Values to be supplied from session or request.
	String projectIDNumber;
	
	/**
	 * GoToUpdateProjectFormViewData's constructors:
	 */
	public GoToUpdateProjectFormViewData(String projectIDNumber) {
		this.projectIDNumber = projectIDNumber;
	}
	
	/**
	 * GoToUpdateProjectFormViewData's data access methods:
	 */
	public String getProjectIDNumber() {
		return projectIDNumber;
	}
}
