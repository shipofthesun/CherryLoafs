package com.PeterReschJr.CherryLoafs.frontEnd;

import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToRegisterAsLoanRecipientUserViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.LoanFundsFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSelectViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.RegisterAsLoanRecipientFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ViewData;
import com.PeterReschJr.CherryLoafs.geolocationverification.GeoLocationData;
import com.PeterReschJr.CherryLoafs.user.User;

/**
 * A UserSpingMVCFrontEnd represents a collection of controllers created with Spring MVC
 * to serve as a user interface to the application.  The controllers represent functional 
 * requirements for a User logged into the application.
 * 
 * @author peter
 *
 */
@Controller
public class UserSpingMVCFrontEnd extends WebFrontEnd {
	
	@Override
	@RequestMapping("/registereduser/projectsearch")
	void projectSearch() {
		// Create user object and call appropriate function.
		User user = new User();
		UserViewData userViewData = new UserViewData(/*TODO: Get search String*/);
		ViewData viewData = user.searchForProjects(userViewData);
		// TODO:  Evaluate viewData output object for actual type to determine and build 
		// response to return.
	}

	@Override
	@RequestMapping("/registereduser/viewproject")
	void projectView() {
		User user = new User();
		ProjectSelectViewData projectSelectViewData = 
											   new ProjectSelectViewData(/*TODO: get projectID from session*/);
		
		ViewData viewData = user.viewProjectPage(projectSelectViewData);
		// TODO:  Evaluate viewData output object for actual type to determine and build 
		// response to return.
	}

	@Override
	@RequestMapping("/registereduser/loanfunds")
	void loanFunds() {
		User user = new User();
		LoanFundsFormViewData loanFundsFormViewData = 
				new LoanFundsFormViewData(/*TODO: Get projectID, Get Loan amount , Get LoanerID*/);
		ViewData viewData = user.loanFunds(loanFundsFormViewData);
		// TODO:  Evaluate viewData output object for actual type to determine and build 
		// response to return.	
	}
	
	@RequestMapping("/registereduser/loanrecipientregistration")
	public void registerAsLoanRecipientUser() {
		User user = new User();
		GeoLocationData geoLocationData = new GeoLocationData(/*TODO: Add parameters (members variables to include in a GeoLocationData object have not yet been determined*/);
		RegisterAsLoanRecipientFormViewData registerAsLoanRecipientFormViewData = 
				new RegisterAsLoanRecipientFormViewData(geoLocationData);
		
		ViewData viewData = user.registerAsLoanRecipientUser(registerAsLoanRecipientFormViewData);
		// TODO:  Evaluate viewData output object for actual type to determine and build 
		// response to return.
	}
	
	@RequestMapping("/registereduser/gotoloanrecipientregistration")
	public void goToRegisterAsLoanRecipientUserForm() {
		User user = new User();
		GoToRegisterAsLoanRecipientUserViewData goToRegisterAsLoanRecipientUserViewData =
				new GoToRegisterAsLoanRecipientUserViewData();
		ViewData viewData = user.goToRegisterAsLoanRecipientUserForm(goToRegisterAsLoanRecipientUserViewData);
	}
	
	@RequestMapping("/registereduser/gotoloanfundsform")
	public void goToLoanFundsFormView() {
		
	}

}
