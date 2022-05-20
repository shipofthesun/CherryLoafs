
package com.PeterReschJr.CherryLoafs.project;

import com.PeterReschJr.CherryLoafs.db.Database;
import com.PeterReschJr.CherryLoafs.db.ProjectDatabaseObject;
import com.PeterReschJr.CherryLoafs.db.data.DatabaseData;
import com.PeterReschJr.CherryLoafs.db.data.ProjectDetailsFoundDatabaseData;
import com.PeterReschJr.CherryLoafs.db.exception.DatabaseException;
import com.PeterReschJr.CherryLoafs.frontEnd.data.CreateProjectFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.DeleteProjectViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GoToUpdateProjectFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSearchResultsViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSelectViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectDetailsViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.RequestLoanRecipientProjectListViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UpdateProjectFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ViewData;
import com.PeterReschJr.CherryLoafs.project.datastructs.ProjectList;
import com.PeterReschJr.CherryLoafs.search.ProjectFinder;
import com.PeterReschJr.CherryLoafs.search.datastructs.KeywordList;

/**
 * A ProjectManager represents an interface to performing actions related to Projects.
 * It invokes the Database to persist Projects to the database and updating or deleting Projects.
 * 
 * @author peter
 *
 */
public class ProjectManager {
	
	/**
	 * ProjectManager's member variables:
	 */
	private int nextProjectIDNumber;	// The Project Identification Number to assign to the 
																// next Project to be created.  Also it is implied that 
																// nextProjectIDNumber - 1 is equivalent to the 
																// ProjectIDNumber assigned to the last Project created.
	
	/**
	 * Public static method to request an instance of ProjectManager.
	 * ProjectManager objects cannot be created directly.  Only by being called by a Guest, User
	 * or LoanRecipientUser object instantiated by a FrontEnd Controller can ProjectManager's
	 * functionality be invoked.  ProjectManager controls all direct access to Projects existing 
	 * in the application.  This includes maintaining their long term persistence as well
	 * as updating any lookup hash tables kept in local application memory.
	 * 
	 * @return
	 */
	public static ProjectManager getProjectManagerInstance() {
		return new ProjectManager();
	}
	
	/**
	 * ProjectManager's constructors.
	 */
	
	/**
	 * Private constructor.
	 */
	private ProjectManager() {
		
	}
	
	
	/**
	 * ProjectManager's primary actions:
	 */
	public ProjectSearchResultsViewData findProjectsByTextString(String callersTextString) 
																												throws DatabaseException {
		//TODO: Add projects to projectList by parsing callersTextString to single words then
		//checking them against an internal list of keywords that have been associated with 
		//with projects.  This will take the form of a hash table that associates keywords with
		//Lists of ProjectIDs.
		//
		KeywordList keywordList = new KeywordList();
		// TODO: Fill kewordList with key 
		
		
		ProjectFinder projectFinder = ProjectFinder.getProjectFinderInstance();
		ProjectList projectList = projectFinder.findProjectsByTextString(callersTextString);
		if(projectList != null) {
		// Projects were found, so return ProjectSearchResultsViewData with searchTerm and 
		// projectList populated to indicate to Guest that a ProjectSearchResultsView with results 
		//	list should be displayed to the guest.
			return new ProjectSearchResultsViewData(callersTextString, projectList);
		}
		else {
		// Projects were not found, so return ProjectSearchResultsViewData with only the 
		//	searchTerm populated to indicate that a ProjectSearchResultsView with results 
		//	list should be displayed to the guest.
			return new ProjectSearchResultsViewData(callersTextString);
		}
	}
	
	/**
	 * Get Project details (this includes projectName, projectDescription, ProjectPostList, etc) to
	 * return back to the user to populate a ProjectViewData view.
	 * @param projectIDNumber
	 */
	public ViewData getProjectDetails(ProjectSelectViewData projectSelectViewData) 
																												throws DatabaseException {
		// Ask the DatabaseManager to attempt to fetch the details for the Project specified
		// in projectSelectViewData.projectIDNumber;
		Database database = Database.getDatabaseInstance();
		DatabaseData databaseData = null;
		long projectIDNumber = Long.parseLong(projectSelectViewData.getProjectIDNumber());

		try {
			databaseData = database.fetchProjectDetails(projectIDNumber);
		}
		catch (DatabaseException e){
			e.printStackTrace();
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		
		if (databaseData != null) {
		// The requested data was found, so return a ProjectViewData containing data fields
		// fetched from the Database.
			databaseData = (ProjectDetailsFoundDatabaseData)databaseData;
			
			return new ProjectDetailsViewData(databaseData.getProjectName(),
					databaseData.getProjectDescription(), databaseData.getLoanRecipientUserName(), databaseData.getGoalAmount(),
					databaseData.getCurrentAmount(), databaseData.getProjectPostList());
		}
		else {
			return null;
		}
	}
	
	public ViewData getProjectUpdateDetails(GoToUpdateProjectFormViewData 
													goToUpdateProjectFormViewData) throws DatabaseException {
		
		return null;
	}
	
	public ViewData getLoanRecipientProjectList(RequestLoanRecipientProjectListViewData 
									requestLoanRecipientProjectListViewData) throws DatabaseException {
		// Attempt fetch ProjectList .
		Database database = Database.getDatabaseInstance();
		DatabaseData databaseData = null;
		long userIDNumber = 
				Long.parseLong(requestLoanRecipientProjectListViewData.getUserIDNumber());
		try {
			databaseData = database.fetchLoanRecipientUserProjectList(userIDNumber);
		}
		
		return null;
	}
	
	public ViewData addProject(CreateProjectFormViewData createProjectFormViewData) 
																												throws DatabaseException {
		// Attempt to persist a new ProjectDatabaseObject to the Database with validated fields
		// entered by LoanRecipientUser attempting to create a Project.
		Database database = Database.getDatabaseInstance();
		ProjectDatabaseObject projectDatabaseObject = 
								new ProjectDatabaseObject(
													createProjectFormViewData.getProjectName(),
													createProjectFormViewData.getProjectDescription(),
													Long.toString(nextProjectIDNumber),
													createProjectFormViewData.getProjectGoalAmount(),
													createProjectFormViewData.getLoanRecipientUserIDNumber(),
													createProjectFormViewData.getKeywordList(), 
													null);
		
		DatabaseData databaseData = null;
		try {
			databaseData = database.persist(projectDatabaseObject);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		
		// TODO: Update the KeywordHashTable with new Project.
		
		
		
	}
	
	public ViewData updateProject(UpdateProjectFormViewData updateProjectFormViewData)
																												throws DatabaseException {
		Database database = Database.getDatabaseInstance();
		
		return null;
	}
	
	public ViewData deleteProject(DeleteProjectViewData deleteProjectViewData) {
		ViewData viewData = null;
		Database database = Database.getDatabaseInstance();
		DatabaseData databaseData = null;
		try {
			databaseData = database.deleteProject(deleteProjectViewData.getProjectIDNumber(),
					deleteProjectViewData.getLoanRecipientUserCreatorIDNumber());
		}
		catch (DatabaseException e) {
			e.printStackTrace();
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ProjectManager's supporting methods:
	 */
	private void incrementNextProjectIDNumber() {
		nextProjectIDNumber = nextProjectIDNumber + 1;
	}
	
	private void decrementNextProjectIDNumber() {
		nextProjectIDNumber = nextProjectIDNumber - 1;
	}
	
	
}
