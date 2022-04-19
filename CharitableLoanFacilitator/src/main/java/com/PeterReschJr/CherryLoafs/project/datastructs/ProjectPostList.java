package com.PeterReschJr.CherryLoafs.project;

import com.PeterReschJr.CherryLoafs.project.ProjectPost;

import java.util.ArrayList;

/*
 * A ProjectPostList represents a List of ProjectPosts associated with a Project.  Posts can only
 * be created by the LoanRecipientUser who created the associated Project.  Only valid projects
 * can be added to a list (exist in database PROJECT table or in local ProjectTree);
 */
public class ProjectPostList {
	
	/*
	 * ProjectPostList member variables
	 */
	ArrayList<ProjectPost> projectPostList;			//  ArrayList of ProjectPosts
	
	/**
	 * Basic constructor
	 */
	ProjectPostList() {
		projectPostList = new ArrayList<ProjectPost>();
	}
	
	/*
	 * Constructor with one initialization ProjectPost.
	 */
	ProjectPostList(ProjectPost projectPost) {
		projectPostList.add(projectPost);
	}
	
	/*
	 * Constructor with initialization ProjectList.
	 */
	ProjectPostList(ProjectPostList projectPostList) {
		addAll(projectPostList);
	}
	
	boolean addAll(ProjectPostList projectPostList) {
		
	}
	
	
	
	
	
	
	/**/
	public static void main(String[] args) {
		// Test Driver

	}
	/**/

}
