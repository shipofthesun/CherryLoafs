package com.PeterReschJr.CherryLoafs.user;

import com.PeterReschJr.CherryLoafs.CherryLoafs.project.ProjectManager;
import com.PeterReschJr.CherryLoafs.project.datastructs.ProjectList;

/** 
 * A LoanReipient represents a special user of this application.  A LoanRecipient is allowed 
 * create projects and receive funds towards projects that they have created.

 * 
 * @author peter
 *
 */
//  funds for projects.  They have been verified as a person in living a country contained in the CountryOfOriginList.
public class LoanRecipientUser extends User {
	
	/**
	 * LoanRecipientUser's member variables:
	 */
	ProjectManager projectManager;	//List of Projects created by LoanRecipientUser
	
	/**
	 * LoanRecipientUser's constructors:
	 */
	
	/**
	 * Basic constructor
	 */
	protected LoanRecipientUser(String userFirstName, String userLastName, String userEmail, long userID) {
		super.firstName = userFirstName;
		super.lastName = userLastName;
		super.email = userEmail;
		super.userID = userID;
	}


	/**
	 * Guest's basic functions (These represent core functionality in requirements):
	 */
	
	/**
	 * Requirement met:  Allow LoanRecipientUser to Create a Project.
	 */
	void createProject(ProjectData projectData) {
		// TODO: Persist new project details to database.
	}
	
	/**
	 * Requirement met:  Allow LoanRecipientUser to view projects that they have created.
	 */
	void viewCreatedProjectsList() {
		// TODO send projectList to front end.
		ProjectManager projectManager = new ProjectManager(Project project)
		projectManager.viewProjectList(projectList);
	}
	
	/**
	 * Requirement met:  Allow LoanRecipientUser to update basic Project information.
	 */
	void updateProject() {
		// TODO UpdateProject in Database..
	}
	
	/**
	 * Requirement satisfied:  
	 */
	void deleteProject(long projectID) {
		// Remove project from database.
		// Remove from ProjectList in ProjectManager.
	}
	
	/**/
	public static void main(String[] args) {
		// Test Driver
	}
	/**/
}
