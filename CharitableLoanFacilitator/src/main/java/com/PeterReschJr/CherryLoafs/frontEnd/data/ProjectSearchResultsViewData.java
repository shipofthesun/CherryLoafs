package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.project.datastructs.ProjectList;

/**
 * A ProjectSearchResultsViewData represents data needed to populate a 
 * ProjectSearchResultsView.  This includes the original search term and zero or more 
 * ProjectList items.  This class also servers as a signal to the FrontEnd that
 * 
 * @author peter
 *
 */
public class ProjectSearchResultsViewData extends ViewData {
	
	/**
	 * ProjectSearchResultsViewData error messages:
	 */
	final String GENERIC_NO_SEARCH_RESULTS_FOUND_MESSAGE = "No results found.";
	
	/**
	 * ProjectSearchResultsViewData's member variables:
	 */
	ProjectList projectList;
	String searchString;
	
	
	/**
	 * ProjectSearchResultsViewData's constructors:
	 */
	
	/**
	 * Constructor to create a results view along with results.  This will indicate that to the 
	 * FrontEnd controller that a ProjectSearchResultsView should be displayed to the Guest
	 * with the SearchBarUIElement populated by searchString and the 
	 * ProjectResultsListUIElement populated by projectList
	 * 
	 * @param searchString
	 * @param projectList
	 */
	public ProjectSearchResultsViewData(String searchString, ProjectList projectList) {
		this.searchString = searchString;
		this.projectList = projectList;
	}
	
	/**
	 * Constructor to create a results view with no results.  This will indicate to the FrontEnd 
	 * controller that no results were found and that the SearchBarUIElement should be 
	 * populated by searchString and ProjectResultsListUIElement populated with the 
	 * GENERIC_NO_SEARCH_RESULTS_FOUND_MESSAGE .
	 * 
	 * @param searchString
	 */
	public ProjectSearchResultsViewData(String searchString) {
		this.searchString = searchString;
		projectList = null;
	}
	
	/**
	 * ProjectSearchResultsViewData's basic data access functions:
	 */
	
	public String getSearchString() {
		return searchString;
	}
	
	public ProjectList getProjectList() {
		return projectList;
	}
	
	public String getGenericNoResultsMessage() {
		return GENERIC_NO_SEARCH_RESULTS_FOUND_MESSAGE;
	}
	
	/**
	 * Called by FrontEnd controller for Guest ProjectSearch function to determine if Projects 
	 * were found as a result of search.
	 * 
	 * @return true if projectList exists (is not null); false if not.
	 */
	public boolean resultsFound() {
		if(projectList != null) {
			return true;
		}
		else {
			return false;
		}
	}

}
