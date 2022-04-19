package com.PeterReschJr.CherryLoafs.user.datastructs;

import java.util.ArrayList;

import com.PeterReschJr.CherryLoafs.user.User;

/**
 * A UserList represents a List of Users.  It uses an ArrayList<User> to store Users.
 * @author peter
 *
 */
public class UserList {

	/**
	 * UserList's member variables:
	 */
	ArrayList<User> userArrayList;
	
	/**
	 * UserList's constructors:
	 */
	
	/**
	 * No arument constructor to simply create ArrayList<User> object.
	 */
	UserList() {
		userArrayList = new ArrayList<User>();
	}
	
	UserList(User user) {
		userArrayList = new ArrayList<User>(user);
	}
	
	void addUser(User user) {
		userArrayList.add(user);
	}
	
	
	
	
	
	
	/**/
	public static void main(String[] args) {
		// Test driver

	}
	/**/

}
