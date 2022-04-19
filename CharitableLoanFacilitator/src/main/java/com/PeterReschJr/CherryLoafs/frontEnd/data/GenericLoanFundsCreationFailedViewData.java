package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 * A GenericLoanFundsCreationFailedViewData represents the data needed to populate a 
 * FrontEnd GenericLoanFundsCreationFailedView.  This class also serves as a signal to the FrontEnd
 * that when returned the GenericLoanFundsCreationFailedView should be shown populated
 * with data contained in this object.
 * 
 * @author peter
 *
 */
public class GenericLoanFundsCreationFailedViewData extends ViewData {
	
	/**
	 * GenericLoanFundsCreationFailedViewData's messages:
	 */
	final String GENERIC_LOANFUNDS_CREATION_FAILURE_MESSAGE 
															= "Unable to complete transaction. Please try again later.";
	
	/**
	 * GenericLoanFundsCreationFailedViewData's constructors:
	 */
	public GenericLoanFundsCreationFailedViewData() {
		
	}
	
	/**
	 * GenericLoanFundsCreationFailedViewData's data access methods:
	 */
	
	public String getGenericFailureMessage() {
		return GENERIC_LOANFUNDS_CREATION_FAILURE_MESSAGE;
	}
}
