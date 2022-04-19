package com.PeterReschJr.CherryLoafs.money;

/**
 * A LoanFunds represents a singular amount of real world money Loaned by a Guest or a 
 * some type of User to a Project created by a LoanRecipientUser.  They represent singular
 * CharitableLoans of a specific amount of money towards a specific Project.
 * 
 * @author peter
 *
 */
public class LoanFunds {

	/**
	 * LoanFunds member variables:
	 */
	double amount;							// Amount in US dollars.
	long loanerUserIDNumber;		// user ID of the loaner; null if loaner was a guest.
	long projectIDNumber;				// projectIDNumber of the Project that this LoanFunds is 
														// toward.
	
	/**
	 * LoanFunds' constructors:
	 */
	
	/**
	 * Basic constructor to initialize LoanFunds with dollar amount
	 * @param dollars
	 */
	LoanFunds(double amount, long loanerUserIDNumber, long projectIDNumber ) {
		this.dollars = dollars;
		this.loanerUserIDNumber = loanerUserIDNumber;
		this.projectIDNumber = projectIDNumber;
	}
	
	/**
	 * LoanFunds basic access methods
	 * @return
	 */
	double getAmount() {
		return dollars;
	}
	
	/**
	 * LoanFunds methods
	 */
	
	
	/**
	public static void main(String[] args) {
		// Test Driver

	}
	/**/

}
