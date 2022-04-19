package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.project.datastructs.ProjectPostList;

/**
 * A ProjectViewData represents the data needed to populate a FrontEnd ProjectView.  This 
 * class also serves as a message to FrontEnd that when received a ProjectView or some error 
 * message should be displayed to the Guest or User depending on the results of an attempt
 * to get the project details from .
 * 
 * @author peter
 *
 */
public class ProjectViewData extends ViewData {
	
	/**
	 * ProjectViewData's member variables:
	 */
	String projectName;
	String projectDescription;
	String projectFundsGoalAmount;
	String projectFundsCurrentTotal;
	ProjectPostList projectPostList;
	
	/**
	 * ProjectViewData's constructors:
	 */
	
	/**
	 * Constructor with initializing values for member variables provided by Creator.
	 * @param projectName
	 * @param projectPostList
	 */
	ProjectViewData(String projectName, String projectDescription, 
								 String projectFundsGoalAmount, String projectFundsCurrentTotal, 
								 ProjectPostList projectPostList) {
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectFundsGoalAmount = projectFundsGoalAmount;
		this.projectFundsCurrentTotal = projectFundsCurrentTotal;
		this.projectPostList = projectPostList;
	}
	
	/**
	 * ProjectViewData's data access methods:
	 */
	

}
