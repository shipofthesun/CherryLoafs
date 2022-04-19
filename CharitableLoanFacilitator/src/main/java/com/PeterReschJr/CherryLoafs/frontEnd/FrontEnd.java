package com.PeterReschJr.CherryLoafs.frontEnd;

import com.PeterReschJr.CherryLoafs.frontEnd.data.DefaultGuestViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.LoanFundsFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSearchResultsViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserCreationErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.views.ProjectSearchResultsView;

/**
 * A FrontEnd represents a source of input and a destination for output to the application.  
 * The inputs will be messages from users of the application to trigger actions defined for that 
 * user type.  The outputs will be data to populate views that the FrontEnd is asked to show to 
 * the user in response.
 * 
 * @author peter
 *
 */
public class FrontEnd {

	/**
	 * FrontEnd's member variables:
	 */
	
	/**
	 * Public static method to get an instance of FrontEnd.
	 */
	public static FrontEnd getFrontEndInstance() {
		FrontEnd frontEnd = new FrontEnd();
		return frontEnd;
	}
	
	/**
	 * FrontEnd's constructors.
	 */
	
	/**
	 * Simple private constructor.  Can only get an instance through getFrontEndInstance() 
	 * method.
	 */
	private FrontEnd() {
		
	}
	
	public void showUserCreationErrorsView(UserCreationErrorViewData userCreationErrorViewData) {
		// TODO Show User Creation Errors view with data populated by userCreationErrorViewData
		// and validationErrorList.
	}
	
	/**
	 * Show user message indicating that the user creation was unsuccessfully and prompting 
	 * them to retry later perhaps.  This will usually be the result of a generic DatabaseException,
	 * or one for which their is no specific handler in place.
	 */
	public void showGenericUserCreationFailedView() {
		// TODO: Display text to the effect of "User creation has failed unexpectedly.  
		// Please try again."
	}
	
	public void showView(DefaultGuestViewData defaultGuestViewData) {
		// TODO: Show landing page for registered user.  This includes ProjectSearchBar, 
		// ProjectSearchResultsList, and account drop down or simple text fields in top right corner
		// displaying the name of the User to confirm that they are logged in.  This will persist
		// throughout all views for a logged in user.
	}
	
	public void showView(ProjectViewData projectViewData) {
		// TODO: Show Project Page
	}
	
	public void showView(LoanFundsFormViewData loanFundsFormViewData) {
		
	}
	
	/**
	 * Show results list of Projects found during a Project Search.
	 * 
	 * @param projectSearchResultsViewData
	 */
	public void showView(ProjectSearchResultsViewData projectSearchResultsViewData) {
		
	}

}
