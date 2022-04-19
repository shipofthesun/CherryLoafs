
package com.PeterReschJr.CherryLoafs.CherryLoafs.project;

import com.PeterReschJr.CherryLoafs.db.Database;
import com.PeterReschJr.CherryLoafs.db.ProjectDatabaseObject;
import com.PeterReschJr.CherryLoafs.db.exception.DatabaseException;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectSearchResultsViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ProjectViewData;
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
	 * return back to the user as
	 * @param projectIDNumber
	 */
	public ProjectViewData getProjectDetails(long projectIDNumber) 
																												throws DatabaseException {
		// TODO: Search for project in Database using projectIDNumber.  Return project details
		// as ProjectViewData if Project is found; return null if no ProjectViewData was found.
		// Will throw DatabaseException if database operation results in failure.
		Database database = Database.getDatabaseInstance();
		ProjectDatabaseObject projectDatabaseObject;
		try {
			projectDatabaseObject = database.getProjectDetails(projectIDNumber);
		}
		catch (DatabaseException e){
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		
		if (projectDatabaseObject != null) {
			return new ProjectViewData(projectDatabaseObject.get)
		}
	}

}
