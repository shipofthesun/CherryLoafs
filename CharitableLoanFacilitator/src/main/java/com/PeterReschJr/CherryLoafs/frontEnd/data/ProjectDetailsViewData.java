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
public class ProjectDetailsViewData extends ViewData {
	
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
	 * Constructor requiring values for all data fields be provided.  This will likely be the only
	 * constructor for this data object only the Database can create objects of this type to return 
	 * to callers of its functions.
	 * 
	 * @param projectName
	 * @param projectPostList
	 */
	public ProjectDetailsViewData(String projectName, String projectDescription, 
										 				String projectFundsGoalAmount, 
										 				String projectFundsCurrentTotal, 
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
