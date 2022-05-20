package com.PeterReschJr.CherryLoafs.search.datastructs;

import java.util.ArrayList;

/**
 * A KeywordToProjectListAssociationList represents a list of associations between registered
 * Keywords and lists of ProjectIDNumbers.  
 * 
 * @author peter
 *
 */
private class KeywordToProjectListAssociationList {

	/**
	 * KeywordToProjectListAssociationList's member variables:
	 */
	ArrayList<KeywordToProjectListAssociation> keywordList;
	
	/**
	 * KeywordToProjectListAssociationList's constructors:
	 */
	public KeywordToProjectListAssociationList(ArrayList<KeywordToProjectListAssociation> keywordList) {
		this.keywordList = keywordList;
	}
	
	public getKeywordList() {
		return keywordList;
	}
	
}
