package com.PeterReschJr.CherryLoafs.frontEnd;

import com.PeterReschJr.CherryLoafs.frontEnd.data.UserViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ViewData;
import com.PeterReschJr.CherryLoafs.user.LoanRecipientUser;

/**
 * A LoanRecipientUserSpringMVCFrontEnd represents a collection of controllers configured
 * using the Spring MVC Framework to represent or support functional requirements for a 
 * LoanRecipientUser logged into the application.  The baseic design pattern of the controllers
 * is as follows:  A LoanRecipientUser object is instantiated so that the specified function of the underlying class
 * can be called, the appropriate input object is created and populated with values from 
 * Session or form data
 * 
 * @author peter
 *
 */
public class LoanRecipientUserSpringMVCFrontEnd extends FrontEnd {
	
	@Override
	public void projectSearch() {
		// Create loanRecipientUser object to perform projectSearch function.
		LoanRecipientUser loanRecipientUser = new LoanRecipientUser();
		// Create input object to the application to submit to 
		// LoanRecipipientUser.searchForProjects(userViewData)
		UserViewData userViewData = new UserViewData(session.getAttribute("projectidnumber"));
		ViewData viewData = loanRecipientUser.searchForProjects(userViewData);
		// TODO: Determine response based on actual type of ViewData.
	}

	@Override
	void projectView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void loanFunds() {
		// TODO Auto-generated method stub
		
	}
}
