package com.PeterReschJr.CherryLoafs.frontEnd.data;

/**
 * A GoToDefaultUserViewData represents a signal from the FrontEnd that the User or Guest
 * has
 * @author peter
 *
 */
public class GoToDefaultUserViewData {
	
	/**
	 * GoToDefaultUserViewData's member variables:
	 */
	String userName;
	
	/**
	 * GoToDefaultUserViewData's constructors:
	 */
	
	public GoToDefaultUserViewData(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
}
