package com.PeterReschJr.CherryLoafs.db;

import com.PeterReschJr.CherryLoafs.project.datastructs.ProjectPostList;
import com.PeterReschJr.CherryLoafs.search.datastructs.KeywordList;
/**
 * A ProjectDatabaseObject represents a single Project from Database.
 * 
 * @author peter
 *
 */
public class ProjectDatabaseObject extends DatabaseObject {
	
	/**
	 * ProjectDatabaseObject's member variables:
	 */
	String projectName;									// Name of project.
	String projectDescription;							// Description of project.
	String projectIDNumber;							// Project ID number of Project.
	String goalLoanFundsAmount;					// The target amount of funds being raised for the 
																		// Project.
	String loanRecipientIDNumber;				// LoanRecipientUser who created the project.
	KeywordList keywordList;							// List of keywords that the LoanRecipientUser has 
																		// associated with the Project.
	ProjectPostList projectPostList;					// List of Posts the LoanRecipientUser has created.
	
	/**
	 * ProjectDatabaseObject's constructors:
	 */
	public ProjectDatabaseObject(String projectName, String projectDescription, 
			String projectIDNumber, String goalLoanFundsAmount, String loanRecipientIDNumber,
			KeywordList keywordList, ProjectPostList projectPostList) {
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectIDNumber = projectIDNumber;
		this.goalLoanFundsAmount = goalLoanFundsAmount;
		this.loanRecipientIDNumber = loanRecipientIDNumber;
		this.projectPostList = projectPostList;
	}
	
	/**
	 * ProjectDatabaseObject's data access methods:
	 */
	
	public String getProjectName() {
		return projectName;
	}
	
	public String getProjectDescription() {
		return projectDescription;
	}
	
	public String getProjectIDNumber() {
		return projectIDNumber;
	}
	
	public String getLoanRecipientUserIDNumber() {
		return loanRecipientIDNumber;
	}
	
	public KeywordList getKeywordList() {
		return keywordList;
	}
	
	public ProjectPostList getProjectPostList() {
		return projectPostList;
	}
	
	
	
}
