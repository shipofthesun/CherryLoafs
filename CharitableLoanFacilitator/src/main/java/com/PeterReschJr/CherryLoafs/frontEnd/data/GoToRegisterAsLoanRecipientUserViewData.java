package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 * A GoToRegisterAsLoanRecipientUserViewData represents a signal from the FrontEnd 
 * indicating that the User wishes to view the RegisterAsLoanRecipientFormView.
 * 
 * @author peter
 *
 */
public class GoToRegisterAsLoanRecipientUserViewData extends ViewData {
	
	/**
	 * GoToRegisterAsLoanRecipientUserViewData's member variables:
	 */
	 String userIDNumber;
	 
	 /**
	  * GoToRegisterAsLoanRecipientUserViewData's constructors:
	  */
	 public GoToRegisterAsLoanRecipientUserViewData(String userIDNumber) {
		 this.userIDNumber = userIDNumber;
	 }
	 
	 /**
	  * GoToRegisterAsLoanRecipientUserViewData's data access methods:
	  */
	 public String getUserIDNumber() {
		 return userIDNumber;
	 }
}
