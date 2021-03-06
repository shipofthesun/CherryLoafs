package com.PeterReschJr.CherryLoafs.user;

import com.PeterReschJr.CherryLoafs.db.Database;
import com.PeterReschJr.CherryLoafs.db.LoanRecipientUserDatabaseObject;
import com.PeterReschJr.CherryLoafs.db.UserDatabaseObject;
import com.PeterReschJr.CherryLoafs.db.data.DatabaseData;
import com.PeterReschJr.CherryLoafs.db.exception.DatabaseException;
import com.PeterReschJr.CherryLoafs.frontEnd.data.DefaultUserViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.LoginFailureViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.RegisterAsLoanRecipientFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserCreationFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.UserLoginFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ViewData;

/**
 * A UserManager represents a collection of users while exposing some functions related to 
 * Users, such as new user creation.
 * @author peter
 *
 */
public class UserManager {

	/**
	 * UserManager's member variables:
	 */
	long nextUserIDNumber;

	/**
	 * Public static method to get an instance of UserManager.
	 */
	public static UserManager getUserManagerInstance() {
		UserManager userManager = new UserManager();
		return  userManager;
	}
	
	/**
	 * UserManager's constructors:
	 */
	
	/**
	 * Single private constructor.
	 */
	private UserManager() {
		// TODO: Restore nextUserIDNumber from local memory
		nextUserIDNumber = recallNextUserIDNumberFromStorage();
	}
	
	/**
	 * Create new User by attempting to persist them to the Database.
	 * 
	 * @param userCreationViewData
	 * @return
	 */
	public DefaultUserViewData addNewUser(UserCreationFormViewData 
																			userCreationFormViewData) 
																												throws DatabaseException {
		
			// Create a User DatabaseObject populated with fields from the UserCreationViewData
			// input and attempt to persist it to the Database as a new User.
			UserDatabaseObject userDatabaseObject = new UserDatabaseObject(
																					userCreationFormViewData.getFirstName(), 
																					userCreationFormViewData.getLastName(), 
																					userCreationFormViewData.getUserName(),
																					userCreationFormViewData.getPassword(),
															  						getNextUserIDNumber(),
															  						userCreationFormViewData.getEmail());
			Database database = Database.getDatabaseInstance();
			try {
				database.persist(userDatabaseObject);
			}
			catch (DatabaseException e) {
				throw e;
			}
			catch(Throwable e) {
				e.printStackTrace();
			}
			
			return new DefaultUserViewData(userCreationFormViewData.getUserName());
	}
	
	public ViewData loginUser(UserLoginFormViewData userLoginFormViewData) throws DatabaseException {
		//TODO: Confirm that User with matching name and password exists in the database.
		// Return UserDefaultLoginViewData
		Database database = Database.getDatabaseInstance();
		UserDatabaseObject userDatabaseObject = null;
		try {
			userDatabaseObject = database.fetchUser(userLoginFormViewData.getUserName(), 
																						userLoginFormViewData.getPassword());
		}
		catch (DatabaseException e){
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		
		if(userDatabaseObject != null) {
		// The user was found in the Database, so return DefaultUserViewData with the userName
		// parameter populated from the userDatabaseObject to signal to the FrontEnd that
		// the Guest's Login attempt was successful and to load DefaultUserView with data
		// in DefaultUserViewData.
			return new DefaultUserViewData(userDatabaseObject.getUserName());
		}
		else {
			// Some error with no specific handling has occured.  Return this ViewData to 
			// FrontEnd to signal that the Guest's login attempt has failed with a generic
			// "Operation Unsuccessful" message.
			return new LoginFailureViewData();
		}
	}
	
	/**
	 * 
	 * @param registerAsLoanRecipientFormViewData
	 * @return ViewData
	 * @throws DatabaseException
	 */
	public ViewData registerUserAsLoanRecipientUser(RegisterAsLoanRecipientFormViewData 
											registerAsLoanRecipientFormViewData) throws DatabaseException {
		
		Database database = Database.getDatabaseInstance();
		LoanRecipientUserDatabaseObject loanRecipientUserDatabaseObject = 
																	new LoanRecipientUserDatabaseObject(
																	registerAsLoanRecipientFormViewData.getLocation());
		DatabaseData databaseData = null;
		try {
			databaseData = database.persist(loanRecipientUserDatabaseObject);
		}
		catch (DatabaseException e) {
			throw e;
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * UserManager's supporting methods:
	 */
	private String getNextUserIDNumber() {
		String newUserIDNumber = Long.toString(nextUserIDNumber);
		nextUserIDNumber = nextUserIDNumber + 1;
		return newUserIDNumber;
	}
	
	private long recallNextUserIDNumberFromStorage() {
		//TODO:  Check a file where the nextUserIDNumber is persisted;  if it exists in file, then
		//	save to local variable.  If it does not exist, return negative one to indicate that no Users
		// have been created for the application yet.
		long userIDNumber = File.parseFileForUserIDNumber();
		return userIDNumber;
	}
	
}
