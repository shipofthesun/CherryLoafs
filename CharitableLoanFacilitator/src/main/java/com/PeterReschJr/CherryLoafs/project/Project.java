package com.PeterReschJr.CherryLoafs.project;

import com.PeterReschJr.CherryLoafs.db.ProjectDatabaseObject;
import com.PeterReschJr.CherryLoafs.frontEnd.Session;
import com.PeterReschJr.CherryLoafs.money.LoanFundsList;
import com.PeterReschJr.CherryLoafs.user.LoanRecipientUser;
import com.PeterReschJr.CherryLoafs.project.datastructs.ProjectPostList;
import com.PeterReschJr.CherryLoafs.search.datastructs.KeywordList;

/**
 * A Project represents a project created by a LoanRecipientUser.  LoanFunds can then be made
 * towards this project
 * @return
 */
public class Project {

	/**
	 * Project's member variables:
	 */
	String projectName;									// Name of project.
	String projectDescription;							// Description of project.
	long projectID;											// Project ID of project (kept consistent with database Projects table).
	LoanRecipientUser loanRecipientUser;	// LoanRecipientUser who created the project.
	ProjectPostList projectPostList;					// List of Posts the LoanRecipientUser has created.
	KeywordList keywordList;							// List of Keywords associated with this Project.
																		// These can be created by the LoanRecipientUser
																		// to include as part of the Project Details and as
																		// an aid to the ProjectSearch class.
	LoanFundsList loanFundsList;					// List of LoanFunds associated with this Project.
	double currentCollectedAmount;				// Current total amount of currency collected as LoanFunds.
	double goalAmount;									// Goal total for satisfaction of investment in the Project.
	
	/**This method loads the data of an existing Project
	 * 
	 * @param projectID
	 * @return dbObj on success
	 * @return null on failure
	 */
	ProjectDatabaseObject loadData(long projectID) {
		ProjectDatabaseObj dbObj;
		try {
			dbObj = getProjectByID(projectID);
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		finally {
			return dbObj;
		}
	}
	
	ProjectDatabaseObject getProjectByID(long projectID) {
			ProjectDatabaseObject projectDatabaseObject = new ProjectDatabaseObject(projectID);
	}
	
	void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	String getProjectName() {
		return projectName;
	}
	
	
	
	
	
	/**/
	public static void main(String[] args) {
		// Test Driver

	}
	/**/
}
