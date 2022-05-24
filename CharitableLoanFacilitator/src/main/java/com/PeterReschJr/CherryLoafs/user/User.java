package com.PeterReschJr.CherryLoafs.user;

import com.PeterReschJr.CherryLoafs.project.ProjectManager;
import com.PeterReschJr.CherryLoafs.db.exception.DatabaseException;
import com.PeterReschJr.CherryLoafs.frontEnd.Session;
import com.PeterReschJr.CherryLoafs.frontEnd.data.DefaultGuestViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.DefaultUserViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GenericDatabaseErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToDefaultGuestViewFailureViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToDefaultUserViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToDefaultUserViewFailureViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToLoanFundsFormErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToLoanFundsFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToRegisterAsLoanRecipientFormFailureViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToRegisterAsLoanRecipientUserViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.LoanFundsFormErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.LoanFundsFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.LoanRecipientUserValidationFailureViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.LoanRecipientUserVerificationFailureViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSearchResultsViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSearchValidationErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSelectErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSelectViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.RegisterAsLoanRecipientFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ViewData;
import com.PeterReschJr.CherryLoafs.geolocationverification.GeoLocationData;
import com.PeterReschJr.CherryLoafs.geolocationverification.GeoLocationVerifier;
import com.PeterReschJr.CherryLoafs.geolocationverification.datastructs.GeoLocationVerificationErrorList;
import com.PeterReschJr.CherryLoafs.money.LoanFundsManager;
import com.PeterReschJr.CherryLoafs.validation.Validator;
import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/* 
 * A User represents the functions that a User is able to perform in the application.  All Users 
 * are able to Loan money to projects.  Guests and any subclass of User is also allowed to loan 
 * funds towards any projects in the application.  All users of the application of any sort are 
 * able to lend money which will be received as Funds towards a Project created by a 
 * LoanRecipientUser, which is a subclass of User.  LoanRecipientUser extends the functionality of 
 * User to include creating Projects and adding Keyword to associate with Projects to aid with 
 * ProjectSearch functions.
*/

public class User {
	
	/**
	 * User's constructors:
	 */
	
	/**
	 * User's basic functions (These represent core functionality in requirements):
	 */
	
	/**
	 * Allows User to Search for projects by keywords found in searchFieldText(scrub then parse 
	 * input for keywords that have been associated with a Project by the loanRecipientUser)
	 * 
	 * Requirement met: Allow User to Search for Projects by SearchFieldText
	 * 
	 * @param userViewData
	 * @return a child of ViewData; namely ProjectSearchResultsViewData, 
	 * 	GenericDatabaseErrorViewData, or ProjectSearchValidationErrorViewData 
	 */
	public ViewData searchForProjects(UserViewData callersUserViewData) {	
			// Validate frontEndsUserViewData for proper format and no suspicious activity
			// such as the inclusion of sql code that may be an attempt at sql injection, for instance.
			Validator validator = Validator.getValidatorInstance();
			// Validator.validate returns null if no validation errors occur.
			ValidationErrorList validationErrorList = validator.validate(callersUserViewData);
			
			if(validationErrorList == null) {
			// No validation errors were returned if validationErrorList is null.
				// Ask ProjectManager to search for Projects by matching words found in the
				// input searchString with Keywords in the Keyword hash table (this associates 
				// Keywords with lists of ProjectIDs.  This is loaded into application memory at 
				// start up from the FileSystem or the Database and must always be kept up to date
				// as Keywords are successfully (Database transaction succeeds) added to and 
				// removed from Projects by the LoanRecipientUser
				// who created the Project.  Could use serialization to save the HashTable between 
				// runs.  I don't really want to keep this in the Database, but that may be the most 
				// sensible location as any instance of this application running must be able to 
				// acquire an accurate, up to date, and consistent version of this object.
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
				// Return ProjectSearchValidationErrorViewData with populated validationErrorList.
				return new ProjectSearchValidationErrorViewData(
																							  callersUserViewData.getSearchString(),
																							  validationErrorList);
			}		
	}
	
	/**
	 * Allows a User to view the details for a specified Project.
	 * 
	 * Requirement met: Allow User to view ProjectPage showing details for a given Project.
	 * 
	 * @param a child of ViewData
	 */
	public ViewData viewProjectPage(ProjectSelectViewData projectSelectViewData) {	
			// Validate ProjectIDNumber.
			Validator validator = Validator.getValidatorInstance();
			// Validator.validate returns null if no ValidationErrors were logged in 
			// ValidationErrorList.
			ValidationErrorList validationErrorList = validator.validate(projectSelectViewData);
			// Attempt to ask Database to acquire Project details or return ValidationErrorList if 
			// validation was unsuccessful.
			ViewData viewData = null;	// ViewData that will be returned to the FrontEnd to
															// signal the response based on the input.
			if(validationErrorList == null) {
			// No validation errors returned to validationErrorList, so attempt to retrieve Project 
			// details from the Database.
				// Convert validated String representation of a projectIDNumber to long.
				long projectIDNumber = 
							Long.parseLong(projectSelectViewData.getProjectIDNumber());
				// Ask the ProjectManager to attempt to retrieve a Project from the Database 
				// using the provided projectIDNumber.
				ProjectManager projectManager = ProjectManager.getProjectManagerInstance();
				try {
					viewData = projectManager.getProjectDetails(projectIDNumber);	
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
			// ValidationErrors were detected; return ValidationError messages to FrontEnd as a
			// ProjectSelectErrorViewData.
				viewData = 
					   new ProjectSelectErrorViewData(projectSelectViewData.getProjectIDNumber(),
																														   validationErrorList);
				return viewData;
			}
	}
	
	/**
	 * Allows a User to Create LoanFunds toward a specific Project.  The projectIDNumber for the 
	 * Project in question along with the amount will be extracted from 
	 * frontEndsloanFundsFormViewData's member variables.
	 * 
	 * Requirement met:  Allow User to Loan LoanFunds towards a Project.
	 * 
	 * @param project
	 */
	public ViewData loanFunds(LoanFundsFormViewData frontEndsloanFundsFormViewData) {
		//Validate input.
		Validator validator = Validator.getValidatorInstance();
		// ValidationErrorList.validate(LoanFundsFormViewData) returns null if no ValidationErrors
		// are found.
		ValidationErrorList  validationErrorList 
																 = validator.validate(frontEndsloanFundsFormViewData);
		

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
				viewData = loanFundsManager.addLoanFunds(frontEndsloanFundsFormViewData);
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
															frontEndsloanFundsFormViewData.getProjectIDNumber(),
																			frontEndsloanFundsFormViewData.getAmount(),
																															  validationErrorList);
			return viewData;
		}
		
	}
	
	/**
	 * Allow regular User to Register as a LoanRecipientUser.
	 * 
	 * Requirement met:  Allow User to Register as a LoanRecipientUser.
	 */
	public ViewData registerAsLoanRecipientUser(RegisterAsLoanRecipientFormViewData 
																						  registerAsLoanRecipientFormViewData) {
		// Validate User input.
		Validator validator = Validator.getValidatorInstance();
		ValidationErrorList validationErrorList =
															 validator.validate(registerAsLoanRecipientFormViewData);
		
		ViewData viewData = null;	// ViewData to be returned to the FrontEnd to signal what
														// view needs to be displayed to the user as response.
		
		// Ask the UserManager to attempt to submit the validated input object
		// Edits User in Database to be a LoanRecipientUser.  This may include adding them to a 
		// separate LoanRecipientUser table with details specific to having the status of a 
		// recipient of charitable loans through the application.
		
		GeoLocationVerifier geoLocationVerifier =
																		GeoLocationVerifier.getGeoLocationVerifierInstance();
		if(validationErrorList == null) {
			GeoLocationData geoLocationData =
			   new GeoLocationData(registerAsLoanRecipientFormViewData.getGeoLocationData());
			GeoLocationVerificationErrorList geoLocationVerificationErrorList 
																				= geoLocationVerifier.verify(geoLocationData);
			// If no errors are contained in geoLocationVerificationErrorList, ask the UserManager 
			// to attempt to update the User to a LoanRecipientUser in the database.
			UserManager userManager = UserManager.getUserManagerInstance();
			if(geoLocationVerificationErrorList == null) {
				try {
					viewData = userManager.registerUserAsLoanRecipientUser(
																							registerAsLoanRecipientFormViewData);
				}
				catch (DatabaseException e) {
					e.printStackTrace();
					// Return generic communication with database failed error.
					// More specific exception errors will be created  that are descendants of 
					// DatabaseException.  This try...catch block will represent a fork to determine
					// what output should be displayed as a result of what type of DatabaseException
					// is thrown.
					viewData = new GenericDatabaseErrorViewData();
					return viewData;
				}
				catch(Throwable e) {
					e.printStackTrace();
				}
				
				return viewData;
			}
			else {
				// Return verification error list to FrontEnd with only the geoLocationVerificationErrorList
				// populated to indicate that a LoanRecipientUserVerificationFailureView should be
				// displayed to the User populated with the generic location verification failed 
				// message that is final static member variable of the 
				// LoanRecipientUserVerificationFailureViewData class.
				viewData 
					= new LoanRecipientUserVerificationFailureViewData(
																										geoLocationVerificationErrorList);
				return viewData;
			}
		}
		else {
			// Return LoanRecipientUserValidationFailureViewData with validationErrorList populated
			// to signal to the FrontEnd that the User's attempt to register as a LoanRecipientUser
			// has failed due to error found during input validation. Return any input field values 
			// entered by the user and assistance for the User to refill forms and resubmit.
			viewData = new LoanRecipientUserValidationFailureViewData(validationErrorList);
			return viewData;
		}
	}
	
	/**
	 * User's supporting methods:
	 */
	
	public ViewData goToRegisterAsLoanRecipientUserForm(
																				GoToRegisterAsLoanRecipientUserViewData 
																				goToRegisterAsLoanRecipientUserViewData) {
		// Validate input object.
		Validator validator = Validator.getValidatorInstance();
		ValidationErrorList validationErrorList 
												 = validator.validate(goToRegisterAsLoanRecipientUserViewData);
		
		if(validationErrorList == null) {
		// No validation errors were found, so return RegisterAsLoanRecipientFormViewData 
		// created with no arguments constructor to indicate that a blank 
		// 	RegisterAsLoanRecipientFormView should be displayed to the User.
			return new RegisterAsLoanRecipientFormViewData();
		}
		else {
			return new GoToRegisterAsLoanRecipientFormFailureViewData(validationErrorList);
		}
	}
	
	/**
	 * Sends User to LoanFundsFormView for specified project.  The only way to specify a 
	 * Project currently is to click on a button on an item in a FrontEnd ProjectSearchResultsList.  
	 * The actual ID numbers are not shared with the user or allowed to be input in any place.
	 * 
	 * Supports Requirement: Allow User to Loan Funds towards a Project. 
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
		
	public ViewData goToDefaultUserView(GoToDefaultUserViewData 
																					goToDefaultUserViewData) {
		// Validate input object.
		Validator validator = Validator.getValidatorInstance();
		ValidationErrorList validationErrorList = validator.validate(goToDefaultGuestViewData);
		
		if(validationErrorList == null) {
			return new DefaultUserViewData(goToDefaultUserViewData.getUserName());
		}
		else {
			return new GoToDefaultUserViewFailureViewData(validationErrorList);
		}
	}
}
