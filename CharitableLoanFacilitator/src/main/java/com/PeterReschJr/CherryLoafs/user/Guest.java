package com.PeterReschJr.CherryLoafs.user;

import com.PeterReschJr.CherryLoafs.project.ProjectManager;
import com.PeterReschJr.CherryLoafs.db.exception.DatabaseException;
import com.PeterReschJr.CherryLoafs.frontEnd.Session;
import com.PeterReschJr.CherryLoafs.frontEnd.data.DefaultGuestViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.DefaultUserViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GenericDatabaseErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToDefaultGuestViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToDefaultGuestViewFailureViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToLoanFundsFormErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToLoanFundsFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToUserCreationFormFailureViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToUserCreationFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToUserLoginFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.LoanFundsFormErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.LoanFundsFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSearchResultsViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSearchValidationErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSelectErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSelectViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserCreationErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserCreationFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserLoginFormErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserLoginFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ViewData;
import com.PeterReschJr.CherryLoafs.money.LoanFundsManager;
import com.PeterReschJr.CherryLoafs.validation.Validator;
import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/** 
 * A Guest represents a user of the application who has not registered.  They have the ability
 * to search for, view, and loan LoanFunds towards a Project.  The abilities of a Guest
 * at this point are almost identical to those of a registered User of the application.  Additional
 * key functionality to create Projects and receive funds is provided only to a 
 * LoanRecipientUser, which is a child class of User.
 * 
 * @author peter
 *
 */
public class Guest {
	
	/**
	 * Guest's basic functions (These represent core functionalities in requirements):
	 */
	
	/**
	 * Attempt to create a new registered User in the application.  The data required is 
	 * extracted from frontEndsUserCreationViewData.
	 * 
	 * Requirement met:  Allow Guest to Register as a User.
	 * 
	 * @return A Child class of ViewData:  A UserCreationErrorViewData on validation error,
	 *  a defaultGuestViewData on Successful addition (logs Guest in as a User), or a 
	 *  GenericDatabaseErrorViewData if an error communicating with database occurs.
	 */
	// TODO:  Something goofy going on with Guest.becomeUser(UserCreationViewData).  
	// Need to check this out.
	public ViewData becomeUser(UserCreationFormViewData callersUserCreationFormViewData) {
		// Validate data fields.
		Validator validator = Validator.getValidatorInstance();
		// Validator.validate() returns null if the validation was successful (no ValidationErrors were
		// found.)  Otherwise, it returns a populated ValidationErrorList.
		ValidationErrorList validationErrorList = validator.validate(callersUserCreationFormViewData);
		
		// Initialize DefaultGuestViewData to null, which indicates that the User has not (yet) been 
		// successfully added to the application.
		DefaultUserViewData defaultUserViewData = null;
		
		// If validationErrorList is null, no ValidationErrors were found, so user was successfully
		// Registered in the application.  DatabaseExceptions that occur during execution
		// of UserManager.addNewUser(UserCreationViewData) will cause generic 
		// DatabaseErrorView to be displayed.  I intend to add more specific types of 
		// DatabaseExceptions that extend DatabaseException to catch errors that the Guest
		// may be able to correct and resubmit.  Other actions can also be taken in response to 
		// specific database or other errors that occur.
		if(validationErrorList == null) {
			//Use validated data from FrontEnd to create new User object in Database.
			UserManager userManager = UserManager.getUserManagerInstance();
			try {
				// userManager.addNewUser returns null if the operation was unsuccessful.
				defaultUserViewData = userManager.addNewUser(callersUserCreationFormViewData);
			}
			catch (DatabaseException e) {
				// Return generic Database failure message to FrontEnd.
				return new GenericDatabaseErrorViewData();
			}
			catch (Throwable e) {
				e.printStackTrace();
			}
			
			// Check that a view was returned; return view if it exists, print generic user creation
			// failed message if not.
			if(defaultUserViewData != null) {
				return defaultUserViewData;
			}
			else {
				// Return UserCreationErrorViewData with no validation list to indicate that
				// the user creation was unsuccessful for some reason and allow the user to re-enter
				// field values.  This will be a catch all for any errors that occur for which their is no
				// specific handling in place.  I probably will need to add a UserCreationErrorsList class
				// at some point for specific error logging and handling.  Between validation errors
				// and exceptions related to Database operations, though, I feel like specific 
				// UserCreationErrors may not be necessary.
				return new UserCreationErrorViewData(
																		   callersUserCreationFormViewData.getFirstName(),
																		   callersUserCreationFormViewData.getLastName(),
																		   callersUserCreationFormViewData.getEmail(),
																		   callersUserCreationFormViewData.getPassword());
			}
		}
		else {
		// User was not successfully added due to NewUserCreation ValidationErrors having been
		// found.
			// Return a UserCreationErrorsView to FrontEnd to signal that the UserCreationErrorView
			// should be shown populated with the original data from the FrontEnd plus a 
			// validationErrorList that the controller will use to determine what error messages will 
			// displayed to the Guest depending on the type and nature of the ValidationErrors 
			// contained in the validationErrorList.
			return new UserCreationErrorViewData(
																		   callersUserCreationFormViewData.getFirstName(),
																		   callersUserCreationFormViewData.getLastName(),
																		   callersUserCreationFormViewData.getEmail(),
																		   callersUserCreationFormViewData.getPassword(),
				   														   validationErrorList);
		}
	}
	
	/**
	 * Allows a Guest to Search for a List of Projects by entering text into the FrontEnd
	 * ProjectSearchBarUIElement.  Extracts the value of GuestViewData.searchString 
	 * from userViewData input.
	 * 
	 * Requirement:  Allow Guest to Search for Projects.
	 * 
	 * @param userViewData
	 * @return a ViewData of child type projectSearchResultsViewData,
	 * GenericDatabaseErrorViewData, or projectSearchValidationErrorViewData object.
	 */
	public ViewData searchForProjects(UserViewData callersUserViewData) {
		
		// Validate input object.
		Validator validator = Validator.getValidatorInstance();
		// Validator.validate returns null if no validation errors occur.
		ValidationErrorList validationErrorList = validator.validate(callersUserViewData);
		
		if(validationErrorList == null) {
		// No validation errors were returned if validationErrorList is null.
			// Ask ProjectManager to search for words found in String by matching them with 
			// Keywords.
			ProjectManager projectManager = ProjectManager.getProjectManagerInstance();
			ProjectSearchResultsViewData projectSearchResultsViewData = null;
			// Test for Database or other exceptions thrown.
			try {
				projectSearchResultsViewData  = 
								projectManager.findProjectsByTextString(
																							 callersUserViewData.getSearchString());
			}
			catch(DatabaseException e) {
				e.printStackTrace();
				return new GenericDatabaseErrorViewData();
			}
			catch(Throwable e) {
				e.printStackTrace();
			}
			
			return projectSearchResultsViewData;
			
		}
		else {
			// Return ProjectSearchValidationErrorViewData with validationErrorList
			return new ProjectSearchValidationErrorViewData(
																						frontEndsUserViewData.getSearchString(),
																						validationErrorList);
		}
		
	}
	
	/**
	 * Allow guest to view details for a single Project.  This would include basic project details 
	 * followed by zero or more ProjectPosts created by a LoanRecipientUser who created the
	 * Project.
	 * 
	 * Requirement met:  Allow Guest to view ProjectPage.
	 */
	public ViewData viewProjectPage(ProjectSelectViewData projectSelectViewData) {
		// Validate ProjectIDNumber.
		Validator validator = Validator.getValidatorInstance();
		// Validator.validate returns null if no ValidationErrors were logged in ValidationErrorList.
		ValidationErrorList validationErrorList = validator.validate(projectSelectViewData);
		
		// Attempt to ask Database to acquire Project details or return ValidationErrorList if 
		// validation was unsuccessful.
		ViewData projectViewData = null;	// ViewData to be returned to FrontEnd to indicate
																	// what the response should be after processing the input.
		if(validationErrorList == null) {
		// No validation errors returned to validationErrorList, so attempt to retrieve Project Details
		// from Database.	
			// Ask ProjectManager to attempt to retrieve Project from Database using 
			// projectSelectViewData.projectIDNumber.
			ProjectManager projectManager = ProjectManager.getProjectManagerInstance();
			try {
				projectViewData = projectManager.getProjectDetails(projectSelectViewData);	
			}
			catch (DatabaseException e) {
				e.printStackTrace();
				return new GenericDatabaseErrorViewData();
			}
			catch(Throwable e) {
				e.printStackTrace();
			}
			return projectViewData;
		}
		else {
		// ValidationErrors were detected; return ValidationError messages to FrontEnd.
			return new ProjectSelectErrorViewData(projectSelectViewData.getProjectIDNumber(),
																			   												  validationErrorList);
		}
		
	}
	
	/**
	 * Allows Guest to Create LoanFunds toward a specific Project.  The projectIDNumber for the 
	 * project in question along with the amount will be extracted from 
	 * frontEndsloanFundsFormViewData's member variables.
	 * 
	 * Requirement met:  Allow Guest to Loan LoanFunds towards a Project.
	 * 
	 * @param project
	 */
	public ViewData loanFunds(LoanFundsFormViewData loanFundsFormViewData) {
		//Validate input.
		Validator validator = Validator.getValidatorInstance();
		// ValidationErrorList.validate(LoanFundsFormViewData) returns null if no ValidationErrors
		// are found.
		ValidationErrorList  validationErrorList = validator.validate(loanFundsFormViewData);
		

		ViewData viewData = null;  // Data set that will be returned to the FrontEnd to indicate 
													   // the required response given the input object's 
											           // (frontEndsloanFundsFormViewData's) contents.
		
		// Ask loanFundsManger to attempt to persist new LoanFunds specified by input to the
		// Database.
		if(validationErrorList == null) {
			// Request that loanFundsManager attempt to add LoanFunds as specified in form.
			LoanFundsManager loanFundsManager = 
																	   LoanFundsManager.getLoanFundsManagerInstance();
			try {
				viewData = loanFundsManager.addLoanFunds(loanFundsFormViewData);
			}
			catch (DatabaseException e) {
				e.printStackTrace();
				return new GenericDatabaseErrorViewData();
			}
			catch(Throwable e) {
				e.printStackTrace();
			}
			
			return viewData;
		}
		else {
			viewData = new LoanFundsFormErrorViewData(
																			  loanFundsFormViewData.getProjectIDNumber(),
																			  loanFundsFormViewData.getAmount(),
																			  validationErrorList);
			return viewData;
		}
		
	}
	
	
	
	/**
	 * Allow guest to login as a user.
	 * 
	 * Requirement met: Allow Guest to login as a User.
	 * 
	 * @param userLoginFormViewData
	 */
	public ViewData loginAsUser(UserLoginFormViewData userLoginFormViewData) {
		// Validate Guest input.
		Validator validator = Validator.getValidatorInstance();
		ValidationErrorList validationErrorList = validator.validate(userLoginFormViewData);
		
		// Check Guest's provided credentials for a match with a User in the Database.
		UserManager userManager = UserManager.getUserManagerInstance();
		ViewData viewData = null;
		if(validationErrorList == null) {
			try {
			//  UserManager.loginUser(LoginViewData) returns an instance of defaultUserViewData
			//  on success or an instance of LoginFailureViewData on failure;
				viewData = userManager.loginUser(userLoginFormViewData);
			}
			catch(DatabaseException e) {
				e.printStackTrace();
				// Return GenericDatabaseErrorViewData to signal to FrontEnd that a 
				// GenericDatabaseErrorView should be displayed populated by a generic 
				// DatabaseError message.
				return new GenericDatabaseErrorViewData();
			}
			catch(Throwable e) {
				e.printStackTrace();
			}
			
			// Returns DefaultUserViewData or LoginFailureViewData
			return viewData;	
		}
		else {
			return new UserLoginFormErrorViewData(userLoginFormViewData.getUserName(),
																				   validationErrorList);
		}
		
	}
	
	/**
	 * Guest's supporting methods:
	 */
	
	/**
	 * Sends guest to LoanFundsFormView for specified project.  The only way to specify a 
	 * Project currently is to click on a button on an item in a FrontEnd ProjectSearchResultsList.  
	 * The actual ID numbers are not shared with the user or allowed to be input in any place.
	 * 
	 * Supports Requirement: Allow Guest to Loan Funds towards a Project. 
	 *
	 * @param goToLoanFundsFormViewData
	 */
	public ViewData goToLoanFundsFormView(GoToLoanFundsFormViewData 
																										goToLoanFundsFormViewData) {
		// Validate input (though it comes from FrontEnd without the input of a user, so this may
		// not be unnecessary.  It is probably better to validate even this for saftey's sake.)
		Validator validator = Validator.getValidatorInstance();
		ValidationErrorList validationErrorList = validator.validate(goToLoanFundsFormViewData);
		
		if(validationErrorList == null) {
			// Return blank LoanFundsFormViewData to FrontEnd.
			return new LoanFundsFormViewData(
																	goToLoanFundsFormViewData.getProjectIDNumber());
		}
		else {
			GoToLoanFundsFormErrorViewData goToLoanFundsFormErrorViewData = 
																		new GoToLoanFundsFormErrorViewData(
																	goToLoanFundsFormViewData.getProjectIDNumber(), 
								   																							  validationErrorList);
			
			return goToLoanFundsFormErrorViewData;
		}
	}
	
	/**
	 * 
	 * @param goToUserCreationFormViewData
	 * @return a subclass of ViewData.
	 */
	public ViewData goToUserCreationForm(GoToUserCreationFormViewData 
																									goToUserCreationFormViewData) {
		// Validate input object.
		Validator validator = Validator.getValidatorInstance();
		ValidationErrorList validationErrorList 
																	= validator.validate(goToUserCreationFormViewData);
		
		if(validationErrorList == null) {
			return new UserCreationFormViewData("","","","","");
		}
		else {
			return new GoToUserCreationFormFailureViewData(validationErrorList);
		}
	}
	
	/**
	 * Go to UserLoginFormView.
	 * 
	 * Supports requirement:  Allow Guest to Login as a User.
	 * 
	 * @param goToUserLoginFormViewData
	 * @return a subclass of ViewData
	 */
	public ViewData goToUserLoginForm(GoToUserLoginFormViewData 
																										  goToUserLoginFormViewData) {
		// Validate input object.
		Validator validator = Validator.getValidatorInstance();
		ValidationErrorList validationErrorList = validator.validate(goToUserLoginFormViewData);
		
		if(validationErrorList == null) {
		// No validation errors were encountered, so signal to FrontEnd that a UserLoginForm
		// with all fields blank should be displayed to the Guest.
			return new UserLoginFormViewData("","");
		}
		else {
		// Return a GoToUserCreationFormFailureViewData to the FrontEnd to signal that one or 
		//	more errors have occured while attempting to authorize the Guest to view the 
		// UserLoginFormView.  Many of these may not be something that the actual Guest can 
		// help to resolve, and should be handled appropriately by the FrontEnd controller
		// based on what errors are included in the validationErrorList.
			return new GoToUserCreationFormFailureViewData(validationErrorList);
		}
	}
	
	public ViewData goToDefaultGuestView(GoToDefaultGuestViewData goToDefaultGuestViewData) {
		// Validate input object.
		Validator validator = Validator.getValidatorInstance();
		ValidationErrorList validationErrorList = validator.validate(goToDefaultGuestViewData);
		
		if(validationErrorList == null) {
			return new DefaultGuestViewData();
		}
		else {
			return new GoToDefaultGuestViewFailureViewData(validationErrorList);
		}
	}
	
	
}
