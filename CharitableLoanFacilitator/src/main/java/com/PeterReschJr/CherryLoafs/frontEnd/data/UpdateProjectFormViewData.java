package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.search.datastructs.KeywordList;

/**
 * 
 * @author peter
 *
 */
public class UpdateProjectFormViewData extends ViewData {
	
	/**
	 * UpdateProjectFormViewData's member variables:
	 */
	String projectName;
	String projectDescription;
	String projectGoalAmount;
	KeywordList keywordList;
	
	/**
	 * UpdateProjectFormViewData's constructors:
	 */
	public UpdateProjectFormViewData(String projectName, String projectDescription, 
																  String projectGoalAmount, KeywordList keywordList) {
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectGoalAmount = projectGoalAmount;
		this.keywordList = keywordList;
	}
	
	/**
	 * UpdateProjectFormViewData's data access methods:
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
	 * @return projectGoalAmount
	 */
	public String getProjectGoalAmount() {
		return projectGoalAmount;
	}
	
	/**
	 * 
	 * @return keywordList
	 */
	public KeywordList getKeywordList() {
		return keywordList;
	}
}
