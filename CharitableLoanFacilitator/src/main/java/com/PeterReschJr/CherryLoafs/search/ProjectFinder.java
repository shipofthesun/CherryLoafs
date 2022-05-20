package com.PeterReschJr.CherryLoafs.search;

import java.util.ArrayList;

import com.PeterReschJr.CherryLoafs.project.datastructs.ProjectList;

/**
 * A ProjectFinder is a helper class used find to find Projects that exist in the Database.
 * 
 * @author peter
 *
 */
public class ProjectFinder {

	/**
	 * Public static method that represents only way to get a ProjectFinder instance.
	 * 
	 * @return new ProjectFinder
	 */
	public static ProjectFinder getProjectFinderInstance() {
		return new ProjectFinder();
	}
	
	/**
	 * ProjectFinder's constructors:
	 */
	
	/**
	 * Single private constructor.
	 */
	private ProjectFinder() {
	}
	
	/**
	 * ProjectFinder's main functionality:
	 */

	public ProjectList findProjectsByTextString(String searchString) {
		//TODO:  Parse text String into individual words and compare each word against keywords
		// list returning any Projects associated with any matching keyword.
		ArrayList<String> wordsList = parseSearchStringToWords(searchString);
		return findProjectsByKeywordList(wordsList);
	}
	
	/**
	 * ProjectFinder's supporting functions:
	 */
	public ArrayList<String> parseSearchStringToWords(String searchString) {
		// End method immediately by returning null to indicate that no String object was found.
		if(searchString == null) {
			return null;
		}
		else {
			return null;
		}
		// TODO: Find words in searchString and add them to returnWordList
		
	}
	
	public ArrayList<Long> findProjectsByKeywordList(ArrayList<String> keywordArrayList) {
		// TODO: Create ArrayList of Long and insert any 
	}

}
