package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 * A ProjectSelectViewData includes data from a FrontEnd displayed ProjectList.
 * 
 * @author peter
 *
 */
public class ProjectSelectViewData {

	/**
	 * ProjectSelectViewData's member variables:
	 */
	String projectIDNumber;
	
	/**
	 * ProjectSelectViewData's constructors:
	 */
	public ProjectSelectViewData(String projectIDNumber) {
		this.projectIDNumber = projectIDNumber;
	}
	
	/**
	 * ProjectSelectViewData's data access methods:
	 */
	public String getProjectIDNumber() {
		return projectIDNumber;
	}
	
	
}
