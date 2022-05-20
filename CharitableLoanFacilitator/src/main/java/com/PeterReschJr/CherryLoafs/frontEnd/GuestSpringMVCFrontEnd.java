package com.PeterReschJr.CherryLoafs.frontEnd;

import com.PeterReschJr.CherryLoafs.frontEnd.data.UserViewData;
import com.PeterReschJr.CherryLoafs.user.Guest;

/**
 * A GuestSpringMVCFrontEnd represents a Spring MVC implementation of a WebFrontEnd.  It
 * is a collection of controllers representing or supporting functional requirements for a Guest 
 * visiting the application.
 * 
 * @author peter
 *
 */
public class GuestSpringMVCFrontEnd extends WebFrontEnd {
	
	@Override
	public void projectSearch() {
		Guest guest = new Guest();
		UserViewData userViewData = new UserViewData(/*get project id from session*/);
		guest.searchForProjects(userViewData);
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
