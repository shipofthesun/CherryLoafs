package com.PeterReschJr.CherryLoafs.search;

/**
 * A Keyword represents a word that has been registered as a Keyword in the application.  
 * At this point, these are only to be added by LoanRecipientUsers to their own Project(s) that
 * they have created.  Need to come up with a way to harvest keywords from either Project
 * titles or descriptions perhaps.  Keywords are used as an aid to the ProjectSearch function.
 * A PersistantKeywordToProjectListAssociationList exists which maintains all currently existing
 * Keywords and associates them with lists of Project identification numbers.  This data 
 * structure is static and exists in application memory, probably loaded at application start up
 * from either a database or file system.  I would like to keep it stored in the file system more,
 * since it contains Project identification numbers.  This needs to be updated each time a
 * successful transaction with the Database that is related to Projects or Keywords occurs and
 * persisted to the Database or FileSystem.
 * 
 * @author peter
 *
 */
public class Keyword {
	
	/**
	 * Keyword's member variables:
	 */
	String keyword;	// The value of the Keyword.
	
	/**
	 * Keyword's constructors:
	 */
	
	/**
	 * Likely single constructor to create Keyword by supplying
	 * @param keyword
	 */
	public Keyword(String keyword) {
		this.keyword = keyword;
	}
	
	/**
	 * Keyword's data access methods:
	 */
	
	/**
	 * 
	 * @return
	 */
	public String getKeyword() {
		return keyword;
	}
}
