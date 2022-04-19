package com.PeterReschJr.CherryLoafs.validation;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.PeterReschJr.CherryLoafs.frontEnd.data.LoanFundsFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.LoginViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSelectViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.RegisterAsLoanRecipientViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserCreationViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GuestViewData;
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
	 * Basic private constructor to ensure that an instance of Validator can only be created 
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
	public ValidationErrorList validate (UserCreationViewData callersUserCreationViewData) {
		// TODO:  Validate fields and return error list if errors are found
		ValidationError firstNameValidationError = validateUserFirstName(callersUserCreationViewData.getFirstName());
		ValidationError lastNameValidationError = validateUserLastName(callersUserCreationViewData.getLastName());
		ValidationError emailValidationError = validateUserLastName(callersUserCreationViewData.getEmail());
		
		if((firstNameValidationError == null) && (lastNameValidationError == null) && (emailValidationError == null)) {
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
		
		String[] individualWords = userViewData.getSearchString().split(oneOrMoreWhitespacesRegex);
		// ValidationErrorList initialized to null to signify that no ValidationErrors have yet been found.
		ValidationErrorList validationErrorList = null;
		
		String htmlTagRegex = "<[^>]*>";
		String sqlRegex = "/[\\t\\r\\n]|(--[^\\r\\n]*)|(\\/\\*[\\w\\W]*?(?=\\*)\\*\\/)/gi";
		Pattern htmlTagPattern = Pattern.compile(htmlTagRegex);
		Pattern sqlPattern = Pattern.compile(sqlRegex);
		Matcher htmlTagMatcher;
		Matcher sqlMatcher;
		for(String word: individualWords) {
			// Test for html tag presence.  This transaction will be aborted with no error message
			// should evidence of potential html insertion in text string for user.
			htmlTagMatcher = htmlTagPattern.matcher(word);
			if(htmlTagMatcher.matches()) {
				ValidationError validationError = new ValidationError("HTML Found Error",
																										  "HTML was found unexpectedly"
																										  + " in search String.",
																										  "HTML detected in search string.");
				validationErrorList.add(validationError);
			}
			//Test for sql injection.  
			sqlMatcher = sqlPattern.matcher(word);
			if(sqlMatcher.matches()) {
				ValidationError validationError = new ValidationError("SQL Found Error",
																											"HTML was found "
																											+ "unexpectedly in search String.  "
																											+ "Threat to application security "
																											+ "may exist in submitted "
																											+ "search String.",
																											"SQL detected in search string.");
				validationErrorList.add(validationError);
			}
		}
		
		return validationErrorList;
	}
	
	/**
	 * Validate data fields in LoanFundsFormViewData object.
	 * 
	 * @param loanFundsFormViewData
	 * @return null if no validation errors are detected; ValidationErrorList if validation errors were detected.
	 */
	public ValidationErrorList validate(LoanFundsFormViewData loanFundsFormViewData) {
		ValidationErrorList validationErrorList = null;
		return validationErrorList;
	}
	
	public ValidationErrorList validate(LoginViewData loginViewData) {
		return null;
	}
	
	public ValidationErrorList validate(RegisterAsLoanRecipientViewData 
																								registerAsLoanRecipientViewData) {
		return null;
	}
	
	
	
	/**
	 * Validator's supporting functions:
	 */
	
	/**
	 * Validates a User firstName.  Currently only checks that the name given is a String of 
	 * alphabetical characters with no spaces.  Need to look up regex.
	 * 
	 * @param callersNewUserFirstName
	 * @return null if no error is found
	 * @return A ValidationError message if an error is found
	 */
	private ValidationError validateUserFirstName(String callersUserFirstName) {
		//TODO: Validate user first name.  String of all alphabetical characters with no spaces.
		callersUserFirstName = callersUserFirstName.toLowerCase();
		
		ValidationError validationError = new ValidationError();
		return validationError;
	}
	
	private ValidationError validateUserLastName(String callersUserLastName) {
		
	}
	
	private ValidationError validateUserEmail(String callersUserEmail) {
		
	}
	
	/**/
	public static void main(String[] args) {
		// Test Driver.

	}
	/**/

}
