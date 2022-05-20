package com.PeterReschJr.CherryLoafs.db.data;

import com.PeterReschJr.CherryLoafs.search.datastructs.KeywordList;

/**
 * A ProjectToUpdateFoundDatabaseData represents data fetched from the database by the 
 * Database class.  It also serves as a signal that when recieved from caller, the attempt to 
 * find a Project with matching ProjectIDNumber was successful and the data needed to 
 * pre-populate the ProjectUpdateView with existing values from the database.
 * 
 * @author peter
 *
 */
public class ProjectToUpdateFoundDatabaseData {
	
	/**
	 * ProjectToUpdateFoundDatabaseData's member variables:
	 */
	String projectName;
	String projectDescription;
	String projectGoalAmount;
	KeywordList keywordList;
	
	/**
	 * ProjectToUpdateFoundDatabaseData's constructors:
	 */
	public ProjectToUpdateFoundDatabaseData(String projectName, String projectDescription, 
			  String projectGoalAmount, KeywordList keywordList) {
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectGoalAmount = projectGoalAmount;
		this.keywordList = keywordList;
	}
	
	/**
	 * ProjectToUpdateFoundDatabaseData's data access methods:
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
