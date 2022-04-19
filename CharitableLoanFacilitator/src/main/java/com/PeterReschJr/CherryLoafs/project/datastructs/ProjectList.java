package com.PeterReschJr.CherryLoafs.project.datastructs;

import java.util.ArrayList;

import com.PeterReschJr.CherryLoafs.project.Project;

/** 
 * A ProjectList is a list of ProjectIDs to be used to search for projects either in a local 
 * ProjectTree or in a call to the LOANRECIPIENTUSER -> PROJECTS
 * 
 * @author peter
 *
 */
public class ProjectList {

	/**
	 * ProjectList's member variables:
	 */
	ArrayList<Project> projectList;
	
	/**
	 * ProjectList's constructors:
	 */
	
	/**
	 * Basic constructor to instantiate member objects.
	 */
	public ProjectList() {
		projectList = new ArrayList<Project>();
	}
	
	/**
	 * Basic constructor with one initialization Project.
	 */
	ProjectList(Project project){
		projectList = new ArrayList<Project>();
		addProject(project);
	}
	
	
	/*
	 * ProjectList's basic functions:
	 */
	
	/**
	 * Add a Project to project
	 * @param project
	 */
	void addProject(Project project) {
		projectList.add(project.getProjectByID());
	}
	
	
	
	
	/**/
	public static void main(String[] args) {
		// Test Driver

	}
	/**/

}
