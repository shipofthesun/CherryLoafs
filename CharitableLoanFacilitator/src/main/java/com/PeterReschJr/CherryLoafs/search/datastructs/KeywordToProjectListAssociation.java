package com.PeterReschJr.CherryLoafs.search.datastructs;

import java.util.ArrayList;

import com.PeterReschJr.CherryLoafs.search.Keyword;

/**
 * A KeywordToProjectListAssociation represents a pair of associated values, namely a Keyword
 * associated with an ArrayList<Long> of ProjectIDNumbers.
 * @author peter
 *
 */
private class KeywordToProjectListAssociation {
	
	String keyword;											// The registered Keyword value.  This must be 
																		// among all Keywords in the 
																		// PersistantKeywordToProjectListAssociationList
	ArrayList<Long> projectIDNumbers;		// List of Project identification numbers of Projects
																		// that have the keyword associated with them. 
	
	public KeywordToProjectListAssociation(String keyword,
																		ArrayList<Long> projectIDNumbers) {
		this.keyword = keyword;
		this.projectIDNumbers = projectIDNumbers;
	}
	
	/**
	 * KeywordToProjectListAssociation's data access methods:
	 */
	public String getKeyword() {
		return keyword;
	}
	
	public ArrayList<Long> getProjects() {
		return projectIDNumbers;
	}
	
}
