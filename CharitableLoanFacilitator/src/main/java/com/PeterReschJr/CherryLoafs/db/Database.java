package com.PeterReschJr.CherryLoafs.db;

import com.PeterReschJr.CherryLoafs.db.data.DatabaseData;
import com.PeterReschJr.CherryLoafs.db.data.LoanFundsPersistanceSuccessDatabaseData;
import com.PeterReschJr.CherryLoafs.db.data.ProjectDeletionFailureDatabaseData;
import com.PeterReschJr.CherryLoafs.db.data.ProjectSuccessfullyDeletedDatabaseData;
import com.PeterReschJr.CherryLoafs.db.exception.DatabaseException;
/**
 * A Database represents the persistent storage of data for this application.  Any time data
 * needs to be persisted, this class will be used.  This is an abstraction layer for the database,
 * which I believe I will implement as an RDBMS.  
 * 
 * @author peter
 *
 */
public class Database {

	
	/**
	 * Public static method to get an instance of the Database.
	 * 
	 * @return
	 */
	public static Database getDatabaseInstance() {
		return new Database();
	}
	
	
	/**
	 * Database's constructors:
	 */
	
	/**
	 * Single private constructor to enforce use of getDatabaseInstance() to acquire an instance.
	 */
	private Database() {
		
	}
	
	/**
	 * Persist User to database given a User object to persist.
	 * 
	 * @param user
	 */
	public DatabaseData persist(UserDatabaseObject userDatabaseObject) 
																												throws DatabaseException {
		return null;
	}
	
	public DatabaseData persist(ProjectDatabaseObject projectDatabaseObject) 
																												throws DatabaseException {
		return null;
	}
	
	/**
	 * 
	 * 
	 * @param loanFundsDatabaseObject
	 * @return
	 * @throws DatabaseException
	 */
	public LoanFundsPersistanceSuccessDatabaseData persist(
																  LoanFundsDatabaseObject loanFundsDatabaseObject) 
																		  										throws DatabaseException {
		return null;
	}
	
	/**
	 * 
	 * @param loanRecipientUserDatabaseObject
	 * @return a child of DatabaseData
	 */
	public DatabaseData persist(LoanRecipientUserDatabaseObject 
													 loanRecipientUserDatabaseObject) 
															 													throws DatabaseException {
		return null;
	}
	
	/**
	 * Returns null if matching User not found.  Return 
	 * 
	 * @param userName
	 * @param password
	 * @return a subclass of DatabaseData, indicating the outcome of operation and containing
	 * 					any data from the database needed to populate the resulting FrontEnd response
	 * 					View.
	 */
	public DatabaseData fetchUser(String userName, String password)  
																												throws DatabaseException {
		// TODO: Confirm that a User exists in the database; return UserDatabaseObject 
		// containing information from the database about the User to be displayed in
		// their logged in FrontEnd defaultUserView if the user exists, otherwise return null.
		return null;
		
	}
	
	public DatabaseData fetchProjectDetails(long projectIDNumber) 
																												throws DatabaseException {
		DatabaseData databaseData = null;
		// TODO: Attempt to retrieve the details of the Project using the specified projectIDNumber;
		return null;
	}
	
	public DatabaseData fetchProjectUpdateDetails(long projectIDNumber) 
																												throws DatabaseException {
		return null;
	}
	
	public DatabaseData fetchLoanRecipientUserProjectList(long userIDNumber) 
																											    throws DatabaseException {
		return null;
	}
	
	public DatabaseData deleteProject(long projectIDNumber, long loanRecipientUserCreatorIDNumber) {
		DatabaseData databaseData = null;
		boolean success = false;		// boolean flag to signify whether the transaction was successful
		// TODO: Attempt to perform the delete operation on the actual database.  Create a 
		// subclass of DatabaseData to indicate the outcome of the transaction.
		
		if(success) {
			return new ProjectSuccessfullyDeletedDatabaseData();
		}
		else {
			return new ProjectDeletionFailureDatabaseData();
		}
	}

}
