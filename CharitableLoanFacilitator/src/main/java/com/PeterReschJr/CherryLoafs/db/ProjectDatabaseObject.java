package com.PeterReschJr.CherryLoafs.db;

import com.PeterReschJr.CherryLoafs.project.datastructs.ProjectPostList;
import com.PeterReschJr.CherryLoafs.user.LoanRecipientUser;

/**
 * A ProjectDatabaseObject represents a single Project from Database.
 * 
 * @author peter
 *
 */
public class ProjectDatabaseObject extends DatabaseObject{
	
	/**
	 * ProjectDatabaseObject's member variables:
	 */
	String projectName;									// Name of project.
	String projectDescription;							// Description of project.
	long projectID;											// Project ID of project (kept consistent with database Projects table).
	LoanRecipientUser loanRecipientUser;	// LoanRecipientUser who created the project.
	ProjectPostList projectPostList;					// List of Posts the LoanRecipientUser has created.
	
	/**
	 * ProjectDatabaseObject's constructors:
	 */
	ProjectDatabaseObject() {
		
	}
	
	
	
	/**/
	public static void main(String[] args) {
		// Test Driver

	}
	/**/
}
