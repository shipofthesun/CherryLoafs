package com.PeterReschJr.CherryLoafs.geolocationverification;

import com.PeterReschJr.CherryLoafs.geolocationverification.datastructs.GeoLocationVerificationErrorList;

/**
 * A GeoLocationVerifier is a class used as a tool to verify that a User attempting to register
 * as a LoanRecipientUser is geographically located in a country contained in the 
 * EligibleCountryList in local memory.   The exact
 * nature of this list is at this point undetermined, but would ideally include the most impoverished
 * countries on Earth to the exclusion of the wealthier.  I as yet haven't had any good 
 * thoughts about how to actually verify the User's geographic location.  The locale tool sounds 
 * like a good place to start, but this may be easy for a client to manipulate to make them appear to anywhere they wish.
 * I need to research how this can be implemented in as secure a way as possible.  I also am not aware of what 
 * data I can possibly collect from third party sources as part of the process.  I also do not 
 * know how easy it would be to trick such a system into saying one was somewhere different 
 * than they actually are.  Scammers would be a potential problem with this type of application.
 * Even though it will be made very clear to all would-be loaners that there is absolutely no 
 * guarantee that the loan will ever be repaid, partially or in full, it is very important for the
 * application to do everything possible to prevent LoanRecipientUsers from committing 
 * fraud by, for instance, communicating misleading information about the nature of their Projects 
 * and the use of the LoanFunds WITHOUT inconveniencing non-malicious users of the 
 * application, or doing so as little as possible.  There will also be a hidden credit score on 
 * LoanRecipientUsers that will be used to determine the credibility of Projects created by this 
 * LoanRecipientUser.  The implementation of that system is intended to attempt to detect
 * by any means available any signs of potential fraud in the behavior of a LoanRecipientUser
 * engaging with the application.
 * 
 * @author peter
 *
 */
public class GeoLocationVerifier {
	
	/**
	 * Method to the get an instance of GeoLocationVerfier.
	 * @return new GeoLocationVerifier
	 */
	public static GeoLocationVerifier getGeoLocationVerifierInstance() {
		return new GeoLocationVerifier();
	}
	
	/**
	 * Single private constructor.  An instance of this class can only be made by a call to the 
	 * public static method getGeoLocationVerifierInstance above.
	 */
	private GeoLocationVerifier() {
		
	}
	
	/**
	 * GeoLocationVerificationErrorList core functionality methods:
	 */
	
	/**
	 * Verify that the Data contained in GeoLocationData represents a legitimate country or 
	 * region of a country where LoanFunds can be collected towards a Project.
	 *
	 * @param registerAsLoanRecipientViewData
	 * @return null on success; populated GeoLocationVerificationErrorList on failure
	 */
	public GeoLocationVerificationErrorList verify(GeoLocationData geoLocationData) {
		GeoLocationVerificationErrorList geoLocationVerificationErrorList = null;
		// TODO:  add to geoLocationVerificationErrorList any errors detected during verification.
		// TODO: verify location; determine if the LoanRecipientUser is in a country or region of
		// a country where any LoanFunds made towards the Project will (likely) be spent, 
		// assuming the Project is a legitimate effort to raise funds for a real world endeavor in or 
		// near the LoanRecipientUser's geographical location.
		
		// TODO: This is where outside sources third-party to the application can be invoked if 
		// data is available that is outside of the information possibly provided by the FrontEnd.
		
		return geoLocationVerificationErrorList;
	}
	
	public String getVerifiedLocation(GeoLocationData geoLocationData) {
		String location = null;
		// TODO: Use verified GeoLocationData to determine the value that should be set in the
		// database for the location of a LoanRecipientUser.  It must correspond exactly with 
		// an element of the Elligible Country or Region List persisted and maintained manually
		// in the Database.  For the running application's purpose, it represents a static list of 
		// values, each a String representation of a country or region of a country on Earth.
		return location;
	}
}
