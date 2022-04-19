package com.PeterReschJr.CherryLoafs.db.datastructs;

import java.util.ArrayList;

import com.PeterReschJr.CherryLoafs.db.DatabaseObject;

/**
 * A DatabaseObjectList represents a list of database objects.  It will be stored internally as an
 * ArrayList of DatabaseObject.
 * @author peter
 *
 */
public class DatabaseObjectList {
	
	/*
	 * DatabaseObjectList's member variables:
	 */
	ArrayList<DatabaseObject> databaseObjectList;	// List of database objects.
	
	/*
	 * DatabaseObjectList's constructors:
	 */
	
	/**
	 * Basic constructor.
	 */
	DatabaseObjectList() {
		databaseObjectList = new ArrayList<DatabaseObject>();
	}
	
	/**
	 * Constructor to initialize DatabaseObjectList with a single DatabaseObject.
	 */
	DatabaseObjectList(DatabaseObject callersDatabaseObject) {
		databaseObjectList.add(callersDatabaseObject);
	}
	
	}
	
	
	
	
	
}
