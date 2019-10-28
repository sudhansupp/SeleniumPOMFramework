package com.demo.util;

import org.apache.log4j.Logger;

/**
 * @author : Jagadish Arahunasi
 * @Company : Siemens CT DD DS AA TEC
 * @Project : CRSP-NG Automation
 */
public class TestData {
	public static Logger log = Logger.getLogger(TestData.class.getName());
	private static String userName,firstName,newUserFirstName, lastName, newUserLastName, email,newUserEmail,
	phoneNumber, department, siemensGID, idProvider, assignedlocation, annotation, startDate, durationUntilExpiration, expirationDate, accountStatus, 
	password, siteName, region, country, city, contactAtSite, contactAtSiemens,
	timeZoneInfo, deviceName, deviceType, productName, listenerPort, targetPort, applicationName, applicationType, noOfDaysForAutomaticRemoval,urn,mailBox,Country,Location;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		TestData.applicationName = applicationName;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		TestData.applicationType = applicationType;
	}

	public String getTargetPort() {
		return targetPort;
	}

	public void setTargetPort(String targetPort) {
		TestData.targetPort = targetPort;
	}

	public String getContactAtSite() {
		return contactAtSite;
	}

	public void setContactAtSite(String contactAtSite) {
		TestData.contactAtSite = contactAtSite;
	}

	public String getUserName() {
		return userName;
	}

	public void setuserName(String userName) {
		TestData.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		TestData.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		TestData.lastName = lastName;
	}
	
	/*public String getNewUserUserName() {
		return newUserUserName;
	}

	public void setNewUserUserName(String newUserUserName) {
		TestData.newUserUserName = newUserUserName;
	}*/
	
	public String getNewUserFirstName() {
		return newUserFirstName;
	}

	public void setNewUserFirstName(String newUserFirstName) {
		TestData.newUserFirstName = newUserFirstName;
	}

	public String getNewUserLastName() {
		return newUserLastName;
	}

	public void setNewUserLastName(String newUserLastName) {
		TestData.newUserLastName = newUserLastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		TestData.email = email;
	}
	
	public String getNewUserEmail() {
		return newUserEmail;
	}

	public void setNewUserEmail(String newUserEmail) {
		TestData.newUserEmail = newUserEmail;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		TestData.phoneNumber = phoneNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		TestData.department = department;
	}
	
	public String getSiemensGID() {
		return siemensGID;
	}

	public void setSiemensGID(String siemensGID) {
		TestData.siemensGID = siemensGID;
	}
	
	public String getIDProvider() {
		return idProvider;
	}

	public void setIDProvider(String idProvider) {
		TestData.idProvider = idProvider;
	}
	
	public String getAssignedLocation() {
		return assignedlocation;
	}

	public void setAssignedLocation(String assignedlocation) {
		TestData.assignedlocation = assignedlocation;
	}
	
	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		TestData.annotation = annotation;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		TestData.startDate = startDate;
	}
	
	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		TestData.expirationDate = expirationDate;
	}
	
	public String getDurationUntilExpiration() {
		return durationUntilExpiration;
	}

	public void setDurationUntilExpiration(String durationUntilExpiration) {
		TestData.durationUntilExpiration = durationUntilExpiration;
	}
	
	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		TestData.accountStatus = accountStatus;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		TestData.password = password;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		TestData.siteName = siteName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		TestData.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		TestData.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		TestData.city = city;
	}

	/*public String getOrgUnit() {
		return orgUnit;
	}

	public void setOrgUnit(String orgUnit) {
		TestData.orgUnit = orgUnit;
	}*/

	public String getContactAtSiemens() {
		return contactAtSiemens;
	}

	public void setContactAtSiemens(String contactAtSiemens) {
		TestData.contactAtSiemens = contactAtSiemens;
	}

	public String getTimeZoneInfo() {
		return timeZoneInfo;
	}

	public void setTimeZoneInfo(String timeZoneInfo) {
		TestData.timeZoneInfo = timeZoneInfo;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		TestData.deviceName = deviceName;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		TestData.deviceType = deviceType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		TestData.productName = productName;
	}

	public String getListenerPort() {
		return listenerPort;
	}

	public void setListenerPort(String listenerPort) {
		TestData.listenerPort = listenerPort;
	}

	public String getNoOfDaysForAutomaticRemoval() {
		return noOfDaysForAutomaticRemoval;
	}

	public void setNoOfDaysForAutomaticRemoval(String noOfDaysForAutomaticRemoval) {
		TestData.noOfDaysForAutomaticRemoval = noOfDaysForAutomaticRemoval;
	}
	
	public String getURN() {
		return urn;
	}

	public void setURN(String urn) {
		TestData.urn = urn;
	}
	
	public String getMailBox() {
		return mailBox;
	}

	public void setMailBox(String mailBox) {
		TestData.mailBox = mailBox;
	}
	
	public void setCountryName(String Country) {
		TestData.Country = Country;
	}
	public String getCountryName() {
		return Country;
	}
	public void setLocationName(String Location) {
		TestData.Location = Location;
	}
	public String getLocationName() {
		return Location;
	}

}
