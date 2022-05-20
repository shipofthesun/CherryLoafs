package com.PeterReschJr.CherryLoafs.db.data;

/**
 * A ProjectDeletionFailureDatabaseData represents a response data object resulting from a 
 * call to the Database class instance method deleteProject().
 * 
 * @author peter
 *
 */
public class ProjectDeletionFailureDatabaseData extends DatabaseData {
	
	final String GENERIC_PROJECT_DELETION_FAILED_MESSAGE 
						= "The requested Project cannot be deleted at this time.  Please try again later.";
	
	public String getGenericFailureMessage() {
		return GENERIC_PROJECT_DELETION_FAILED_MESSAGE;
	}
}
