package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.project.datastructs.ProjectList;

/**
 * A LoanRecipientUserProjectListViewData represents data needed to populate a FrontEnd
 * LoanRecipientUserProjectListView.  It also serves as a signal to the FrontEnd that a
 * LoanRecipientUserProjectListView should be displayed to the LoanRecipientUser.
 * 
 * @author peter
 *
 */
public class LoanRecipientUserProjectListViewData extends ViewData {
	
	/**
	 * LoanRecipientUserProjectListViewData's member variables:
	 */
	ProjectList projectList;
	
	/**
	 * LoanRecipientUserProjectListViewData's constructors:
	 */
	public LoanRecipientUserProjectListViewData(ProjectList projectList) {
		this.projectList = projectList;
	}
	
	/**
	 * LoanRecipientUserProjectListViewData's data access methods:
	 */
	public ProjectList getProjectList() {
		return projectList;
	}
	
	
}
