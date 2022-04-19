package com.PeterReschJr.CherryLoafs.db;

import com.PeterReschJr.CherryLoafs.db.data.LoanFundsPersistanceSuccessDatabaseData;
import com.PeterReschJr.CherryLoafs.db.exception.DatabaseException;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserCreationViewData;
import com.PeterReschJr.CherryLoafs.project.datastructs.ProjectTree;
import com.PeterReschJr.CherryLoafs.user.User;
import com.PeterReschJr.CherryLoafs.user.datastructs.UserHashMap;
import com.PeterReschJr.CherryLoafs.user.datastructs.UserTree;

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
	 * Single private constructor.
	 */
	private Database() {
		
	}
	
	/**
	 * Persist User to database given a User object to persist.
	 * 
	 * @param user
	 */
	public void persist(UserDatabaseObject userDatabaseObject) throws DatabaseException {
		
	}
	
	
	public LoanFundsPersistanceSuccessDatabaseData persist(
				LoanFundsDatabaseObject loanFundsDatabaseObject) 
															throws DatabaseException {
		return new LoanFundsPersistanceSuccessDatabaseData();
	}
	
	/**
	 * Returns null if matching User not found.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public UserDatabaseObject findUser(String userName, String password) 
																												throws DatabaseException {
		return null;
		
	}

}
