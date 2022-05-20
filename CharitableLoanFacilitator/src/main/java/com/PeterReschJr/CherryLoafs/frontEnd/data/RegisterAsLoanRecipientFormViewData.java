package com.PeterReschJr.CherryLoafs.frontEnd.data;

import com.PeterReschJr.CherryLoafs.geolocationverification.GeoLocationData;

/**
 * A RegisterAsLoanRecipientViewData represents data input to the FrontEnd by a User
 * attempting to register as a LoanRecipientUser.
 * 
 * @author peter
 *
 */
public class RegisterAsLoanRecipientFormViewData extends ViewData {
	
	/**
	 * RegisterAsLoanRecipientViewData's member variables:
	 */
	GeoLocationData geoLocationData;	// Will come from Request, Session, and/or third 
																	// party upstream applications representing authentic
																	// sources of data that can be used to help verify the User's
																	// actual location on Earth.
	String location;		// String value of a verified location.  This will be a simple name identifier
									// corresponding with the value of an element in the Eligible Country or
									// Region List.  Regions will most likely be denoted as 
									// [Country of Origin][Ordinal Integer] where ordinal integer is a simple
									// counting number assigned to Regions within a country as they are 
									// created.  The actual Eligible Country or Region List will be persisted
									// in the database and updated manually as needed.
	
	/**
	 * RegisterAsLoanRecipientViewData's constructors:
	 */
	
	/**
	 * Constructor providing a GeoLocationData to be used to verify the User's location is in
	 * an eligible country or region of a country where LoanFunds can be received towards 
	 * Projects through the application.
	 * 
	 * @param frontEndsGeoLocationData
	 */
	public RegisterAsLoanRecipientFormViewData(GeoLocationData frontEndsGeoLocationData) {
		geoLocationData = new GeoLocationData(frontEndsGeoLocationData);
	}
	
	/**
	 * Constructor used when a blank form needs to be displayed.
	 */
	public RegisterAsLoanRecipientFormViewData() {
		
	}
	
	/**
	 * RegisterAsLoanRecipientViewData's data access methods:
	 */
	public GeoLocationData getGeoLocationData() {
		return geoLocationData;
	}
	
	public void addVerifiedLocation(String location) {
		this.location = location;
	}
	
	public String getLocation() {
		return location;
	}
}
