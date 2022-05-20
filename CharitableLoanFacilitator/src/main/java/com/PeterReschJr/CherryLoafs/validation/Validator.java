package com.PeterReschJr.CherryLoafs.validation;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.PeterReschJr.CherryLoafs.frontEnd.data.LoanFundsFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSelectViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.RegisterAsLoanRecipientFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserLoginFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.RequestLoanRecipientProjectListViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserCreationFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.CreateProjectFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToDefaultGuestViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToDefaultUserViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToLoanFundsFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToRegisterAsLoanRecipientUserViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToUpdateProjectFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToUserCreationFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToUserLoginFormViewData;
import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

public class Validator {

	/**
	 * Public static method to get an instance of Validator.  This will only ever be called by a 
	 * Guest or User of some type.
	 * 
	 * @return validator
	 */
	public static Validator getValidatorInstance() {
		Validator validator = new Validator();
		return validator;
	}
	
	/**
	 * Single private constructor to ensure that an instance of Validator can only be created 
	 * by calling above getValidatorInstance method.  
	 */
	private Validator() {
		
	}
	
	/**
	 * Validator's primary functions:
	 */
	
	/**
	 * Validates data needed for new User creation before it is able to be persisted to Database.
	 * This method is overloaded perform different actions based on the type of Data passed.
	 * 
	 * @param callersUserCreationViewData
	 * 
	 * @return null if no errors were found
	 * @return ValidationErrorList populated with errors if errors were found
	 */
	public ValidationErrorList validate (UserCreationFormViewData userCreationFormViewData){
		// TODO:  Validate fields and return error list if errors are found
		ValidationError firstNameValidationError =
											  validateUserFirstName(userCreationFormViewData.getFirstName());
		ValidationError lastNameValidationError = 
											  validateUserLastName(userCreationFormViewData.getLastName());
		ValidationError emailValidationError = 
															  validateUserEmail(userCreationFormViewData.getEmail());
		
		if((firstNameValidationError == null) && (lastNameValidationError == null) && 
																										 (emailValidationError == null)) {
		//No errors were found.
			return null;
		}
		else {
			ValidationErrorList validationErrorList = new ValidationErrorList();
			if(firstNameValidationError != null) {
				validationErrorList.add(firstNameValidationError);
			}
			if(lastNameValidationError != null) {
				validationErrorList.add(lastNameValidationError);
			}
			if(emailValidationError != null) {
				validationErrorList.add(emailValidationError);
			}
			return validationErrorList;
		}
	}
	
	/**
	 * Validates a projectIDNumber.  Returns a ValidationErrorList if errors are found or null
	 * if no errors are found.
	 *  This method is overloaded perform different actions based on the type of Data passed.
	 * @param projectIDNumber
	 * @return
	 */
	public ValidationErrorList validate(ProjectSelectViewData ProjectSelectViewData) {
		// TODO Validate projectIDNumber by comparing to regex.
		return null;
	}
	
	/**
	 * Validate GuestViewData.  Currently this only has a searchString member variable.
	 * 
	 * @param GuestViewData
	 * @return validationErrorList
	 */
	public ValidationErrorList validate(UserViewData userViewData) {
		// Fill wordsList with words parsed from GuestViewData.searchString.
		String oneOrMoreWhitespacesRegex = "\\s+";
		
		String[] individualWords =
									    	userViewData.getSearchString().split(oneOrMoreWhitespacesRegex);
		// ValidationErrorList initialized to null to signify that no ValidationErrors have yet been found.
		ValidationErrorList validationErrorList = null;
		
		String htmlTagRegex = "<[^>]*>";
		String sqlRegex = "/[\\t\\r\\n]|(--[^\\r\\n]*)|(\\/\\*[\\w\\W]*?(?=\\*)\\*\\/)/gi";
		Pattern htmlTagPattern = Pattern.compile(htmlTagRegex);
		Pattern sqlPattern = Pattern.compile(sqlRegex);
		Matcher htmlTagMatcher;
		Matcher sqlMatcher;
		
		ValidationError validationError;
		for(String word: individualWords) {
			// Test for html tag presence.  This transaction will be aborted with no error message
			// should evidence of potential html insertion in text string for user.
			htmlTagMatcher = htmlTagPattern.matcher(word);
			if(htmlTagMatcher.matches()) {
				validationError = new ValidationError("HTML Found Error.",
																			    "HTML was found unexpectedly"
																			    + " in search String.",
																			    "HTML detected in search string.");
				validationErrorList.add(validationError);
			}
			//Test for sql injection.  
			sqlMatcher = sqlPattern.matcher(word);
			if(sqlMatcher.matches()) {
				validationError = new ValidationError("SQL Found Error",
																				"SQL scrpt was found ",
																				"SQL detected in search string.",
																				+ "unexpectedly in search String.  "
																				+ "Threat to application security "
																				+ "may exist in submitted "
																				+ "search String."
																				);
				
				validationErrorList.add(validationError);
			}
		}
		
		return validationErrorList;
	}
	
	/**
	 * Validate data fields in LoanFundsFormViewData input object.
	 * 
	 * @param loanFundsFormViewData
	 * @return null if no validation errors are detected; a populated ValidationErrorList if 
	 * validation errors were detected.
	 */
	public ValidationErrorList validate(LoanFundsFormViewData loanFundsFormViewData) {
		ValidationErrorList validationErrorList = null;
		return validationErrorList;
	}
	
	/**
	 * 
	 * @param loginViewData
	 * @return
	 */
	public ValidationErrorList validate(UserLoginFormViewData userLoginFormViewData) {
		ValidationErrorList validationErrorList = null;
		return validationErrorList;
	}
	
	/**
	 * 
	 * @param registerAsLoanRecipientViewData
	 * @return
	 */
	public ValidationErrorList validate(RegisterAsLoanRecipientFormViewData 
																						  registerAsLoanRecipientFormViewData) {
		ValidationErrorList validationErrorList = null;
		// TODO: Validate input data, adding any errors to list
		return validationErrorList;
	}
	
	/**
	 * 
	 * @param createProjectFormViewData
	 * @return
	 */
	public ValidationErrorList validate(CreateProjectFormViewData 
																											createProjectFormViewData) {
		ValidationErrorList validationErrorList = null;
		// TODO: Validate input data, adding any errors to list
		return validationErrorList;
	}
	
	/**
	 * 
	 * @param requestLoanRecipientProjectListViewData
	 * @return
	 */
	public ValidationErrorList validate(RequestLoanRecipientProjectListViewData 
																					requestLoanRecipientProjectListViewData) {
		ValidationErrorList validationErrorList = null;
		// TODO: Validate input data, adding any errors to list
		return validationErrorList;
	}
	
	/**
	 * 
	 * @param goToLoanFundsFormViewData
	 * @return
	 */
	public ValidationErrorList validate(GoToLoanFundsFormViewData 
																										goToLoanFundsFormViewData) {
		ValidationErrorList validationErrorList = null;
		// TODO: Validate input data, adding any errors to list
		return validationErrorList;
	}
	
	/**
	 * 
	 * @param GoToUpdateProjectFormViewData
	 * @return
	 */
	public ValidationErrorList validate(GoToUpdateProjectFormViewData 
																								  GoToUpdateProjectFormViewData) {
		ValidationErrorList validationErrorList = null;
		// TODO: Validate input data, adding any errors to list
		return validationErrorList;
	}
	
	/**
	 * 
	 * @param goToUserCreationFormViewData
	 * @return
	 */
	public ValidationErrorList validate(GoToUserCreationFormViewData 
																									 goToUserCreationFormViewData) {
		// GoToUserCreationFormViewData currently has no data fields to validate, so always 
		// return null to indicate that there were no validationErrors detected.
		return null;
	}
	
	/**
	 * 
	 * @param goToUserLoginFormViewData
	 * @return
	 */
	public ValidationErrorList validate(GoToUserLoginFormViewData 
																										  goToUserLoginFormViewData) {
		// GoToUserLoginFormViewData currently has no data fields to validate, so always 
		// return null to indicate that there were no validationErrors detected.
		return null;
	}
	
	/**
	 * 
	 * @param goToRegisterAsLoanRecipientUserViewData
	 * @return
	 */
	public ValidationErrorList validate(GoToRegisterAsLoanRecipientUserViewData 
																				goToRegisterAsLoanRecipientUserViewData) {
		return null;
	}
	
	/**
	 * 
	 * @param goToDefaultUserViewData
	 * @return
	 */
	public ValidationErrorList validate(GoToDefaultUserViewData goToDefaultUserViewData) {
		ValidationErrorList validationErrorList = null;
		ValidationError validationError 
												   = validateUserName(goToDefaultUserViewData.getUserName());
		if(validationError != null) {
			validationErrorList = new ValidationErrorList(validationError);
		}
		
		return validationErrorList;
	}
	
	/**
	 * 
	 * @param goToDefaultGuestViewData
	 * @return
	 */
	public ValidationErrorList validate(GoToDefaultGuestViewData goToDefaultGuestViewData) {
		ValidationErrorList validationErrorList = null;
		// GoToDefaultGuestViewData currently has no actual data fields to validate, so null
		// will always be returned from this validate method.
		return validationErrorList;
	}
	
	
	/**
	 * Validator's supporting functions:
	 */
	
	/**
	 * Validates a User firstName.  Currently only checks that the name given is a String of 
	 * alphabetical characters with no spaces.
	 * 
	 * @param callersNewUserFirstName
	 * @return null if no error is found
	 * @return A ValidationError message if an error is found
	 */
	private ValidationError validateUserFirstName(String callersUserFirstName) {
		// Validate user first name.  String of all alphabetical characters with no spaces.
		String alphaOnlyStringWithNoSpacesRegex = "^a-zA-Z";
		Pattern stringWithNoSpacesPattern 
																= Pattern.compile(alphaOnlyStringWithNoSpacesRegex); 
		Matcher stringMatcher;
		stringMatcher = stringWithNoSpacesPattern.matcher(callersUserFirstName);
		if(stringMatcher.matches()) {
			return null;
		}
		else {
			return new ValidationError("Invalid User First Name Found Error",
															"A non-single-String value was input as User first name.",
															"Either a non-name or spaces were found in first name.");
		}
	}
	
	/**
	 * 
	 * @param callersUserLastName
	 * @return null if no error found; a ValidationError if an error is found.
	 */
	private ValidationError validateUserLastName(String callersUserLastName) {
		// Validate user last name.  String of all alphabetical characters with no spaces.
		String alphaOnlyStringWithNoSpacesRegex = "^a-zA-Z";
		Pattern stringWithNoSpacesPattern = 
																	Pattern.compile(alphaOnlyStringWithNoSpacesRegex); 
		Matcher stringMatcher;
		stringMatcher = stringWithNoSpacesPattern.matcher(callersUserLastName);
		if(stringMatcher.matches()) {
			return null;
		}
		else {
			return new ValidationError("Non-String Found Error",
															"A non-single-String value was input as User last name.",
															"Either a non-name or spaces were found in last name.");
		}
	}
	
	/**
	 * 
	 * @param callersUserEmail
	 * @return
	 */
	private ValidationError validateUserEmail(String callersUserEmail) {
		// Validate user email address.
		String emailRegex = "^(.+)@(.+)$";
		Pattern emailPattern = Pattern.compile(emailRegex); 
		Matcher emailMatcher;
		emailMatcher = emailPattern.matcher(callersUserEmail);
		if(emailMatcher.matches()) {
			return null;
		}
		else {
			return new ValidationError("Invalid Email Entered Error",
															"A non-email value was input in User email field.",
															"Email address format invalid.");
		}
	}
	
	/**
	 * 
	 * @param userName
	 * @return null if no Error; a ValidationError if an error was encountered.
	 */
	private ValidationError validateUserName(String userName) {
		// Validate user first name.  String of all alphabetical characters with no spaces.
		String alphaNumericStringWithNoSpacesRegex = "^a-zA-Z0-9";
		Pattern  alphaNumericStringWithNoSpacesPattern = 
															  Pattern.compile(alphaNumericStringWithNoSpacesRegex); 
		Matcher stringMatcher;
		stringMatcher = alphaNumericStringWithNoSpacesPattern.matcher(userName);
		if(stringMatcher.matches()) {
			return null;
		}
		else {
			return new ValidationError("Invalid Username Found Error",
													   "A non-single-String value was input as Username.",
													   "Either a non-name or spaces were found in Username field.");
		}
	}
}
