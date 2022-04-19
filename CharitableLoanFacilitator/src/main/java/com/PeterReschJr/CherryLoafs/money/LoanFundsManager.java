package com.PeterReschJr.CherryLoafs.money;

import com.PeterReschJr.CherryLoafs.db.Database;
import com.PeterReschJr.CherryLoafs.db.LoanFundsDatabaseObject;
import com.PeterReschJr.CherryLoafs.db.data.LoanFundsPersistanceSuccessDatabaseData;
import com.PeterReschJr.CherryLoafs.db.exception.DatabaseException;
import com.PeterReschJr.CherryLoafs.frontEnd.data.GenericLoanFundsCreationFailedViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.LoanFundsFormSuccessViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.LoanFundsFormViewData;
import com.PeterReschJr.CherryLoafs.frontEnd.data.ViewData;

/**
 * A LoanFundsManager manages LoanFunds.  LoanFunds can only be delivered to the specified
 * Project by way of the LoanManager.  It will update Project through Database to reflect the 
 * added funds and persist LoanFunds information to database as well.
 * @author peter
 *
 */
public class LoanFundsManager {
	
	/**
	 * Public static method to get an instance of LoanFundsManager.
	 */
	public static LoanFundsManager getLoanFundsManagerInstance() {
		return new LoanFundsManager();
	}
	
	/**
	 * LoanFundsManager's constructors:
	 */
	
	/**
	 * Single private constructor.
	 */
	private LoanFundsManager() {
		
	}
	
	/**
	 * Add LoanFund to application.
	 * @param loanFundsFormViewData
	 */
	public ViewData addLoanFunds(LoanFundsFormViewData 
																	loanFundsFormViewData) throws DatabaseException {
		
		LoanFundsDatabaseObject loanFundsDatabaseObject 
					= new LoanFundsDatabaseObject(loanFundsFormViewData.getProjectIDNumber(),
																							loanFundsFormViewData.getAmount());
		Database database = Database.getDatabaseInstance();
		LoanFundsPersistanceSuccessDatabaseData loanFundsPersistanceSuccessDatabaseData = null;
		try {
			loanFundsPersistanceSuccessDatabaseData = database.persist(loanFundsDatabaseObject);
		}
		catch(DatabaseException e) {
			e.printStackTrace();
			throw e;
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		
		if(loanFundsPersistanceSuccessDatabaseData != null) {
			LoanFundsFormSuccessViewData loanFundsFormSuccessViewData 
				= new LoanFundsFormSuccessViewData(loanFundsPersistanceSuccessDatabaseData);
			return loanFundsFormSuccessViewData;		
		}
		else {
			return new GenericLoanFundsCreationFailedViewData();
		}

	}
	
	
}
