package com.PeterReschJr.CherryLoafs.frontEnd;

import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToUserLoginFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ViewData;
import com.PeterReschJr.CherryLoafs.user.Guest;

/**
 * A GuestSpringMVCFrontEnd represents a Spring MVC implementation of a WebFrontEnd.  It
 * is a collection of controllers representing or supporting functional requirements for a Guest 
 * visiting the application.
 * 
 * @author peter
 *
 */
@Controller
public class GuestSpringMVCFrontEnd extends WebFrontEnd {
	
	@Override
	@RequestMapping("/projectSearch")
	public void projectSearch() {
		Guest guest = new Guest();
		UserViewData userViewData = new UserViewData(session.get/*get project id from session variable in superclass*/);
		guest.searchForProjects(userViewData);
	}

	@Override
	@RequestMapping("/viewproject")
	void projectView() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	@RequestMapping("/loanfunds");
	void loanFunds() {
		// TODO Auto-generated method stub
		
	}
	
	@RequestMapping("/userregistration")
	public void becomeUser() {
	
	}
	
	@RequestMapping("/userlogin")
	public void loginAsUser() {
		
	}
	
	@RequestMapping("/gotoloanfunds")
	public void goToLoanFundsFormView() {
		
	}
	
	@RequestMapping("/gotouserregistration")
	public void goToUserCreationForm() {
		
	}
	
	@RequestMapping("/gotouserlogin")
	public void goToUserLoginForm() {
		Guest guest = new Guest();
		GoToUserLoginFormViewData goToUserLoginFormViewData =
				new GoToUserLoginFormViewData();
		ViewData viewData = guest.goToUserLoginForm(goToUserLoginFormViewData);
		// TODO:
	}
	
	@RequestMapping("/gotohome")
	public void goToDefaultGuestView() {
		
	}
	
	
	
	
	
	
	
}
