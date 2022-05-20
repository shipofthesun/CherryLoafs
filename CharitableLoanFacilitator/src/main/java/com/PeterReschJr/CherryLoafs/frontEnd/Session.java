package com.PeterReschJr.CherryLoafs.frontEnd;

import jakarta.servlet.http.HttpSession;

/**
 * A Session represents some connection to an active User or Guest through front end.  Most 
 * likely JSP's with Spring MVC.
 * 
 * @author peter
 *
 */
public class Session {
	
	HttpSession httpSession;
	
	public Session(HttpSession httpSession) {
		this.httpSession = httpSession;
	}
	
	public void addElement(Object object) {
		httpSession.setAttribute
	}
	
}
