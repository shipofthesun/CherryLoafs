package com.PeterReschJr.CherryLoafs.search.datastructs;

import java.util.ArrayList;

import com.PeterReschJr.CherryLoafs.project.datastructs.ProjectList;

/**
 * A PersistantKeywordToProjectListHashTable represents an association list that associates
 * registered Keywords with ProjectIDNumber lists.  The contents of this list is loaded into 
 * application memory when this class is loaded from either the Database or local file system
 * using the getMasterKeywordToProjectAssociationList() method.
 * 
 * @author peter
 *
 */
public class PersistantKeywordToProjectListAssociationList {
	
	private static final KeywordToProjectListAssociationList 
									masterKeywordToProjectAssociationList 
									= getMasterKeywordToProjectAssociationList();
	
	private static KeywordToProjectListAssociationList getMasterKeywordToProjectAssociationList() {
		return null;
	}
	
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
		KeywordList keywordList;
		
		/**
		 * KeywordToProjectListAssociationList's constructors:
		 */
		public KeywordToProjectListAssociationList(ArrayList<KeywordToProjectListAssociation> keywordList) {
			this.keywordList = keywordList;
		}
		
		public ArrayList<KeywordToProjectListAssociation> getKeywordList() {
			return keywordList;
		}
		
		private ProjectList getMasterKeywordToProjectAssociationList() {
			//  TODO:  Retrieve the file or other resource containing the 
		}
		
		/**
		 * A KeywordToProjectListAssociation represents a pair of associated values, namely a 
		 * String Keyword associated with an ArrayList<Long> of ProjectIDNumbers.
		 * @author peter
		 *
		 */
		private class KeywordToProjectListAssociation {
			
			String keyword;											// The registered Keyword value.  This must be 
																				// among all Keywords in the 
																				// PersistantKeywordToProjectListAssociationList
			ArrayList<Long> projectIDNumbers;		// List of Project identification numbers of Projects
																				// that have the keyword associated with them. 
			
			private KeywordToProjectListAssociation(String keyword,
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
		
		
	}
	
}
