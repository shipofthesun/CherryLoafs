package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 * A GoToLoanFundsFormViewData represents data from the FrontEnd signaling that a Project
 * has been selected and the details of it need to be displayed to the user.  There is no corresponding
 * actual View as this functionality will only be accessed via selection of an item from a list.  The 
 * button or other FrontEnd UI element will pass the ProjectID number to enable the 
 * application to identify the Project and load its details.
 *  
 * @author peter
 *
 */
public class GoToLoanFundsFormViewData {
	
	/**
	 * GoToLoanFundsFormViewData's member variables:
	 */
	String projectIDNumber;
	
	/**
	 * GoToLoanFundsFormViewData's constructors:
	 */
	public GoToLoanFundsFormViewData(String projectIDNumber) {
		this.projectIDNumber = projectIDNumber;
	}
	
	/**
	 * GoToLoanFundsFormViewData's data access methods:
	 */
	
	public String getProjectIDNumber() {
		return projectIDNumber;
	}
}
