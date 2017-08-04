package com.ess.springmvc.iot;

public class EnvironmentProd {

	private String siteURL = "https://api.us1.covisint.com";
	private String realmCode = "BLPOC-OWNER";
	private String organization = "OBLPOC-OWNER590702";
	private String instanceID = "8cc63ded-fbd8-45e0-861f-7ea28da85855";
	private String clientID = "GXr3PsUoLJBPgzdprTXsKAXNLZMm6yPM";
	private String clientSecret = "CcJLDn7OGuyfVJKy";
	private String bearer = "R1hyM1BzVW9MSkJQZ3pkcHJUWHNLQVhOTFpNbTZ5UE06Q2NKTERuN09HdXlmVkpLeQ==";
	private String passwordPolicy = "9078b9c1-f06f-4f77-b7c2-1c46ab12b00e";
	private String authenticationPolicy = "ce2a0581-8ddf-444e-b7ad-501dd9b2ebf3";
	private String portalPackage = "PBLPOC-OWNER590703000";
	private String bentleyPackage = "PBLPOC-OWNER13906686";
	private String lamborghiniPackage = "PBLPOC-OWNER13906691";
	
	public EnvironmentProd() {
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
