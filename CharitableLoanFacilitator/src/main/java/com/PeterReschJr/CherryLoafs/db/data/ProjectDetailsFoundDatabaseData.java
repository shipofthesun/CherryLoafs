package com.PeterReschJr.CherryLoafs.db.data;

import com.PeterReschJr.CherryLoafs.project.datastructs.ProjectPostList;

/**
 * A ProjectDetailsFoundDatabaseData represents data specifying a Projects details that has
 * been successfully fetched from the Database.  This also serves as a return signal to the caller
 * that the attempt to fetch details about the Project based on a given Project identification
 * number was successful.
 * 
 * @author peter
 *
 */
public class ProjectDetailsFoundDatabaseData extends DatabaseData {
	
	/**
	 * ProjectDetailsFoundDatabaseData's member variables:
	 */
	String projectName;							// Name of Project.
	String projectDescription;					// Description of Project.		
	String loanRecipientUserName;		// Username of LoanRecipient
	String goalAmount;							// Fund raising goal amount of Project.
	String currentAmount;						// Total amount of funds currently collected from all loaners.
	ProjectPostList projectPostList;			// List of ProjectPosts created by the LoanRecipientUser
																// who created the Project.
	
	/**
	 * ProjectDetailsFoundDatabaseData's constructors:
	 */
	public ProjectDetailsFoundDatabaseData(String projectName, String projectDescription,
																		   String loanRecipientUserName,
																		   String goalAmount, String currentAmount, 
																		   ProjectPostList projectPostList) {
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.loanRecipientUserName = loanRecipientUserName;
		this.goalAmount = goalAmount;
		this.currentAmount = currentAmount;
		this.projectPostList = projectPostList;
	}
	
	/**
	 * ProjectDetailsFoundDatabaseData's data access methods:
	 */
	
	/**
	 * 
	 * @return projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	
	/**
	 * 
	 * @return projectDescription
	 */
	public String getProjectDescription() {
		return projectDescription;
	}
	
	/**
	 * 
	 * @return loanRecipientUserName
	 */
	public String getLoanRecipientUserName() {
		return loanRecipientUserName;
	}
	
	/**
	 * 
	 * @return goalAmount
	 */
	public String getGoalAmount() {
		return goalAmount;
	}
	
	/**
	 * 
	 * @return currentAmount
	 */
	public String getCurrentAmount() {
		return currentAmount;
	}
	
	/**
	 * 
	 * @return projectPostList
	 */
	public ProjectPostList getProjectPostList() {
		return projectPostList;
	}
}
