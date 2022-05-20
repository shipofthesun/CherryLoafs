package com.PeterReschJr.CherryLoafs.user;

import com.PeterReschJr.CherryLoafs.project.ProjectManager;
import com.PeterReschJr.CherryLoafs.db.exception.DatabaseException;
import com.PeterReschJr.CherryLoafs.frontEnd.data.CreateProjectFormErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.CreateProjectFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.DeleteProjectViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GenericDatabaseErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToLoanFundsFormErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToUpdateProjectFormErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToUpdateProjectFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.LoanFundsFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.RequestForLoanRecipientProjectListFailedViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.RequestLoanRecipientProjectListViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UpdateProjectFormErrorViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UpdateProjectFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ViewData;
import com.PeterReschJr.CherryLoafs.project.datastructs.ProjectList;
import com.PeterReschJr.CherryLoafs.validation.Validator;
import com.PeterReschJr.CherryLoafs.validation.datastructs.ValidationErrorList;

/** 
 * A LoanRecipientUser represents a special user of the application.  A LoanRecipientUser is 
 * allowed to create Projects and receive funds towards Projects that they have created.  They
 * must live in a country or region of a country where LoanFunds can be received through the
 * application.  The master list of eligible countries or regions is kept and maintained in the 
 * Database.  The means by which this will be updated I am at this point unsure of, but I think
 * manually will be just fine to start out.
 * 
 * @author peter
 *
 */
public class LoanRecipientUser extends User {

	/**
	 * Guest's basic functions (These represent core functionality in requirements):
	 */
	
	/**
	 * Validates the input object and then asks the ProjectManager to attempt to create a
	 * new Project in the application by adding it to the Database.
	 * 
	 * Requirement met:  Allow LoanRecipientUser to Create a Project.
	 */
	public ViewData createProject(CreateProjectFormViewData frontEndsCreateProjectFormViewData) {
		// Validate input from FrontEnd.
		Validator validator = Validator.getValidatorInstance();
		ValidationErrorList validationErrorList =
															validator.validate(frontEndsCreateProjectFormViewData);
		
		ViewData viewData = null;			// Create variable to hold viewData that will be returned
																// to the FrontEnd to signal what view should be displayed
																// displayed to the User in response to the input.
		if(validationErrorList == null) {
		// No errors were detected during validation, so ask ProjectManager to attempt add
		// the Project to the application in the Database.
			ProjectManager projectManager = ProjectManager.getProjectManagerInstance();
			try {
				viewData = projectManager.addProject(frontEndsCreateProjectFormViewData);
			}
			catch (DatabaseException e) {
				e.printStackTrace();
				return new GenericDatabaseErrorViewData();
			}
			catch (Throwable e) {
				e.printStackTrace();
			}
			return viewData;
		}
		else {
			viewData = new CreateProjectFormErrorViewData(validationErrorList);
			return viewData;
		}
	}
	
	/**
	 * Requirement met:  Allow LoanRecipientUser to view projects that they have created.
	 */
	public ViewData viewCreatedProjectsList(RequestLoanRecipientProjectListViewData 
																					requestLoanRecipientProjectListViewData) {
		// Validate input.
		Validator validator = Validator.getValidatorInstance();
		ValidationErrorList validationErrorList =
													validator.validate(requestLoanRecipientProjectListViewData);
		// TODO send projectList to front end.
		ProjectManager projectManager = ProjectManager.getProjectManagerInstance();
		ViewData viewData = null; 	// Data returned to FrontEnd to indicate what should be 
														// displayed to the user in response to input.
		if(validationErrorList == null) {
		// No validation errors were detected; attempt to add the Project using the data 
		// contained in the input data object received from FrontEnd.
			try {
				viewData 
								= projectManager.getLoanRecipientProjectList(
																					   requestLoanRecipientProjectListViewData);
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
			return new RequestForLoanRecipientProjectListFailedViewData(validationErrorList);
		}
		
	}
	
	/**
	 * Requirement met:  Allow LoanRecipientUser to update basic Project information.
	 */
	public ViewData updateProject(UpdateProjectFormViewData updateProjectFormViewData) {
		// Validate input data set.
		Validator validator = Validator.getValidatorInstance();
		ValidationErrorList validationErrorList = validator.validate(updateProjectFormViewData);
		
		// Ask the ProjectManager to attempt to update the specified Project with the information
		// from ProjectFormViewData.
		ProjectManager projectManager = ProjectManager.getProjectManagerInstance();
		ViewData viewData = null;		//  ViewData to be sent back to FrontEnd to indicate response.
		if(validationErrorList == null) {
			try {
				viewData = projectManager.updateProject(updateProjectFormViewData);
			}
			catch (DatabaseException e) {
				e.printStackTrace();
				return new GenericDatabaseErrorViewData();
			}
			catch (Throwable e) {
				e.printStackTrace();
			}
		}
		else {
			viewData = new UpdateProjectFormErrorViewData(
																   updateProjectFormViewData.getProjectName(), 
																   updateProjectFormViewData.getProjectDescription(), 
																   updateProjectFormViewData.getProjectGoalAmount(),
																   updateProjectFormViewData.getKeywordList(), 
																   validationErrorList);
			return viewData;
		}
	
	}
	
	/**
	 * Requirement met:  Allow a LoanRecipientUser to delete a Project that they have created.
	 */
	public ViewData deleteProject(DeleteProjectViewData deleteProjectViewData) {
		ProjectManager projectManager = ProjectManager.getProjectManagerInstance();
		ViewData viewData = null;		// The ViewData to be returned to the FrontEnd to 
															// indicate response.
		
		try {
			viewData 
						= projectManager.deleteProject(deleteProjectViewData);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
			return new GenericDatabaseErrorViewData();
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		
		return viewData;
	}
	
	/**
	 * LoanRecipientUser's supporting methods:
	 */
	
	public ViewData goToUpdateProjectFormViewData(GoToUpdateProjectFormViewData 
																								 goToUpdateProjectFormViewData) {
		// Validate input (though it comes from FrontEnd without the input of a user, so this may
		// not be unnecessary.  It is probably better to validate even this for saftey's sake.)
		Validator validator = Validator.getValidatorInstance();
		ValidationErrorList validationErrorList =
																 validator.validate(goToUpdateProjectFormViewData);
		
		// Ask ProjectManager to attempt to get the existing values of associated with the
		// Project's projectIDNumber.
		ProjectManager projectManager = ProjectManager.getProjectManagerInstance();
		ViewData viewData = null;	   // Data set to be returned to FrontEnd to indicate response.
		if(validationErrorList == null) {
			
			try {
				viewData = projectManager.getProjectUpdateDetails(
																									goToUpdateProjectFormViewData);
			}
			catch (DatabaseException e) {
				e.printStackTrace();
				return new GenericDatabaseErrorViewData();
			}
			catch (Throwable e) {
				e.printStackTrace();
			}
			
			return viewData;
		}
		else {
			GoToUpdateProjectFormErrorViewData goToUpdateProjectFormErrorViewData = 
																					new GoToUpdateProjectFormErrorViewData(
															   goToUpdateProjectFormViewData.getProjectIDNumber(), 
								   																							   validationErrorList);
				
			return goToUpdateProjectFormErrorViewData;
		}
	}
}
