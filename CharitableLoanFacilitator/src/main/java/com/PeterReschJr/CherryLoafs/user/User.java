package com.PeterReschJr.CherryLoafs.user;

import com.PeterReschJr.CherryLoafs.project.ProjectManager;
import com.PeterReschJr.CherryLoafs.db.exception.DatabaseException;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GenericDatabaseErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.LoanRecipientUserValidationFailureViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.LoanRecipientUserVerificationFailureViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSearchResultsViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSearchValidationErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSelectErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSelectViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.RegisterAsLoanRecipientViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ViewData;
import com.PeterReschJr.CherryLoafs.geolocationverification.GeoLocationData;
import com.PeterReschJr.CherryLoafs.geolocationverification.GeoLocationVerifier;
import com.PeterReschJr.CherryLoafs.geolocationverification.datastructs.GeoLocationVerificationErrorList;
import com.PeterReschJr.CherryLoafs.project.datastructs.ProjectList;
import com.PeterReschJr.CherryLoafs.validation.Validator;
import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/* 
 * A User represents a general user of the application.  All Users are able to Loan 
 * money to projects.  RegisteredUsers and GuestUsers are able to lend money which will be 
 * received as Funds towards a Project created by a LoanRecipientUser. User has a child class 
 * LoanRecipientUser.  LoanRecipientUser extends the functionality of User to include creating 
 * Projects and adding Keyword to associate with Projects to aid with ProjectSearch functions.
*/

public class User {
	
	/**
	 * User's member variables:
	 */
	long userID;
	String firstName;
	String lastName;
	String userName;
	String email;
	ProjectList donationsList;	
	
	
	/**
	 * User's constructors:
	 */
	
	/**
	 *
	 */
	User() {
		
	}
	
	/**
	 * User's basic functions (These represent core functionality in requirements):
	 */
	
	/**
	 * Allows User to Search for projects by keywords found in searchFieldText(scrub then parse 
	 * input for keywords that have been associated with a Project by the loanRecipientUser)
	 * 
	 * Requirement met: Allow User to Search for Projects by SearchFieldText
	 * @param userViewData
	 * @return
	 */
	public ViewData searchForProjects(UserViewData frontEndsUserViewData) {	
			// Validate frontEndsUserViewData for proper format and no suspicious activity
			// such as the inclusion of sql code that may be an attempt at sql injection, for instance.
			Validator validator = Validator.getValidatorInstance();
			// Validator.validate returns null if no validation errors occur.
			ValidationErrorList validationErrorList = validator.validate(frontEndsUserViewData);
			
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
																						   frontEndsUserViewData.getSearchString());
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
	 * Allows a User to view the details for a specified Project.
	 * 
	 * Requirement met: Allow User to view ProjectPage showing details for a given Project.
	 * 
	 * @param project
	 */
	public ViewData viewProjectPage(ProjectSelectViewData projectSelectViewData) {	
		// Validate ProjectIDNumber.
				Validator validator = Validator.getValidatorInstance();
				// Validator.validate returns null if no ValidationErrors were logged in ValidationErrorList.
				ValidationErrorList validationErrorList = validator.validate(projectSelectViewData);
				
				// Attempt to ask Database to acquire Project details or return ValidationErrorList if 
				// validation was unsuccessful.
				ProjectViewData projectViewData = null;	// Create reference for later use in the case that
																						// Project search is successful.
				if(validationErrorList == null) {
				// No validation errors returned to validationErrorList, so attempt to retrieve Project Details
				// from Database.
					// Convert validated String representation of a projectIDNumber to long.
					long projectIDNumber = 
								Long.parseLong(projectSelectViewData.getProjectIDNumber());
					// Ask ProjectManager to attempt to retrieve Project from Database using 
					// projectSelectViewData.projectIDNumber.
					ProjectManager projectManager = ProjectManager.getProjectManagerInstance();
					try {
						projectViewData = projectManager.getProjectDetails(projectIDNumber);	
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
					return new ProjectSelectErrorViewData(projectSelectViewData.getProjectIDNumber(),validationErrorList);
				}
	}
	
	/**
	 * Allow regular User to Register as a LoanRecipientUser.
	 * 
	 * Requirement met:  Allow User to Register as a LoanRecipientUser.
	 */
	public ViewData registerAsLoanRecipientUser(RegisterAsLoanRecipientViewData 
																								registerAsLoanRecipientViewData) {
		// Validate User input.
		Validator validator = Validator.getValidatorInstance();
		ValidationErrorList validationErrorList 
																= validator.validate(registerAsLoanRecipientViewData);
		
		// Ask the UserManager to attempt to submit the validated input entered by the User.
		// Edits User in Database to be a LoanRecipientUser.  This may include adding them to a 
		// separate LoanRecipientUser table with details specific to having the status as a 
		// recipient of charitable loans through the application.
		UserManager userManager = UserManager.getUserManagerInstance();
		GeoLocationVerifier geoLocationVerifier = GeoLocationVerifier.getGeoLocationVerifierInstance();
		if(validationErrorList == null) {
			GeoLocationData geoLocationData = new GeoLocationData();
			GeoLocationVerificationErrorList geoLocationVerificationErrorList 
													= geoLocationVerifier.verify(geoLocationData);
			// If no errors are contained in geoLocationVerificationErrorList, ask the UserManager 
			// to attempt to update the User to a LoanRecipientUser in the database.
			if(geoLocationVerificationErrorList == null) {
				try {
					userManager.registerUserAsLoanRecipientUser(registerAsLoanRecipientViewData);
				}
				catch (DatabaseException e) {
					e.printStackTrace();
					// Return generic communication with database failed error.
					// More specific exception errors will be created  that are descendants of 
					// DatabaseException.  This try...catch block will represent a fork to determine
					// what output should be displayed as a result of what type of DatabaseException
					// is thrown.
					return new GenericDatabaseErrorViewData();
				}
				catch(Throwable e) {
					e.printStackTrace();
				}
			}
			else {
				// Return verification error list to FrontEnd with only the geoLocationVerificationErrorList
				// populated to indicate that a LoanRecipientUserVerificationFailureView should be
				// displayed to the User populated with the generic location verification failed 
				// message that is final static member variable of the 
				// LoanRecipientUserVerificationFailureViewData class.
				return new LoanRecipientUserVerificationFailureViewData(geoLocationVerificationErrorList);
			}
		}
		else {
			// Return LoanRecipientUserValidationFailureViewData with validationErrorList populated
			// to signal to the FrontEnd that the User's attempt due user input validation producing
			// errors.  Return any input field values entered by the user and assistance for the User
			// to refill forms and resubmit.
			return new LoanRecipientUserValidationFailureViewData(validationErrorList);	
		}
	
	}
}
