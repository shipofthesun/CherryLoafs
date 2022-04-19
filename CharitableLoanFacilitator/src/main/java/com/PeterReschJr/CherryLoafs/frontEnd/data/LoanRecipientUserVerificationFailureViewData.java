package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.geolocationverification.datastructs.GeoLocationVerificationErrorList;

/**
 * A LoanRecipientUserVerificationFailureViewData represents data needed to populate a
 * FrontEnd LoanRecipientUserVerificationFailureView.  This class also serves as a signal to the 
 * FrontEnd that when an object of this type is recieved, an attempt by the User to register
 * as a LoanRecipientUser has failed due to errors detected during GeoLocationVerification.
 * 
 * @author peter
 *
 */
public class LoanRecipientUserVerificationFailureViewData extends ViewData {
	
	/**
	 * LoanRecipientUserVerificationFailureViewData message:
	 */
	final String GENERIC_LOCATION_VERIFICATION_FAILED_MESSAGE = "The User appears to be"
														+ "located in an area qualified to recieve loan contributions.";
	
	/**
	 * LoanRecipientUserVerificationFailureViewData's member variables:
	 */
	GeoLocationVerificationErrorList geoLocationVerificationErrorList;
	
	/**
	 * 
	 */
	public LoanRecipientUserVerificationFailureViewData(GeoLocationVerificationErrorList geoLocationVerificationErrorList) {
		this.geoLocationVerificationErrorList = geoLocationVerificationErrorList;
	}
	
	/**
	 * LoanRecipientUserVerificationFailureViewData's data access methods:
	 */
	public String getGenericLocationVerificationFailureMessage() {
		return GENERIC_LOCATION_VERIFICATION_FAILED_MESSAGE;
	}
}
