package com.evan;

public class Environment {


	private String siteURL;
	private String realmCode;
	private String organization;
	private String instanceID;
	private String clientID;
	private String clientSecret;
	private String bearer;
	private String passwordPolicy;
	private String authenticationPolicy;
	private String portalPackage;
	private String bentleyPackage;
	private String lamborghiniPackage;
	
	public Environment(String aSiteURL, String aRealmCode, String aOrganization, String aInstanceID, String aClientID, 
			           String aClientSecret, String aBearer, 
			           String aPasswordPolicy, String aAuthenticationPolicy,
			           String aPortalPackage, String aBentleyPackage, String aLamborghiniPackage) {
		// set all the attributes
		setSiteURL(aSiteURL);
		setRealmCode(aRealmCode);
		setOrganization(aOrganization);
		setInstanceID(aInstanceID);
		setClientID(aClientID);
		setClientSecret(aClientSecret);
		setBearer(aBearer);
		setPasswordPolicy(aPasswordPolicy);
		setAuthenticationPolicy(aAuthenticationPolicy);
		setPortalPackage(aPortalPackage);
		setBentleyPackage(aBentleyPackage);
		setLamborghiniPackage(aLamborghiniPackage);

	}
	
	public Environment() {
		// TODO Auto-generated constructor stub

}
	
	public String getSiteURL() {
		return siteURL;
	}

	public void setSiteURL(String siteURL) {
		this.siteURL = siteURL;
	}

	public String getRealmCode() {
		return realmCode;
	}

	public void setRealmCode(String realmCode) {
		this.realmCode = realmCode;
	}
	
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}	

	public String getInstanceID() {
		return instanceID;
	}

	public void setInstanceID(String instanceID) {
		this.instanceID = instanceID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getBearer() {
		return bearer;
	}

	public void setBearer(String bearer) {
		this.bearer = bearer;
	}

	public String getPasswordPolicy() {
		return passwordPolicy;
	}

	public void setPasswordPolicy(String passwordPolicy) {
		this.passwordPolicy = passwordPolicy;
	}	

	public String getAuthenticationPolicy() {
		return authenticationPolicy;
	}

	public void setAuthenticationPolicy(String authenticationPolicy) {
		this.authenticationPolicy = authenticationPolicy;
	}
	
	public String getPortalPackage() {
		return portalPackage;
	}

	public void setPortalPackage(String portalPackage) {
		this.portalPackage = portalPackage;
	}

	public String getBentleyPackage() {
		return bentleyPackage;
	}

	public void setBentleyPackage(String bentleyPackage) {
		this.bentleyPackage = bentleyPackage;
	}

	public String getLamborghiniPackage() {
		return lamborghiniPackage;
	}

	public void setLamborghiniPackage(String lamborghiniPackage) {
		this.lamborghiniPackage = lamborghiniPackage;
	}	
}
