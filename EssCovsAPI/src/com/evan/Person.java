package com.evan;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import okhttp3.FormBody;
import okhttp3.MediaType;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.net.URLEncoder;

import javax.json.JsonReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

import org.json.*;

import okio.Buffer;

public class Person {

	public Person() {
		// constructor
	}

    /**
     * Gets a token from the APIs.
     *
     * @return
     */
    public String createPerson(Environment aEnviron, String aToken, String aEmailAddress) {
        String personID = "";
        try {
     
        	System.out.println("===>createPerson: Starting");
        	
        	OkHttpClient client = new OkHttpClient();
        	
        	MediaType mediaType = MediaType.parse("application/vnd.com.covisint.platform.person.v1+json");
        	
        	String bodyValues = "{\n    \n    \"realm\": \""
        			+ aEnviron.getRealmCode()
        			+ "\",\n    \"status\": \"active\",\n    "
        			+ "\"name\": {\n        \"prefix\": \"Mr\",\n        \"given\": \"TestUser\",\n        "
        			+ "\"middle\": \"t\",\n        \"surname\": \"Evan\",\n        \"suffix\": \"\"\n    },\n    "
        			+ "\"addresses\": [\n        {\n            \"streets\": [\n                "
        			+ "\"21705 Rockwell Street Road\",\n                \"\",\n                "
        			+ "\"\"\n            ],\n            \"city\": \"Farmington Hills\",\n            "
        			+ "\"state\": \"MI\",\n            \"postal\": \"48336\",\n            \"country\": \"Canada\",\n            "
        			+ "\"type\": \"main\"\n        }\n      \n    ],\n    \"language\": \"en\",\n    \"timezone\": \"EST5EDT\",\n    "
        			+ "\"phones\": [\n        {\n            \"type\": \"main\",\n            \"number\": \"248-767-1570\"\n        "
        			+ "},\n        {\n            \"type\": \"fax\",\n            \"number\": \"248-669-5679\"\n        }\n    ],\n    "
        			+ "\"title\": \"User\",\n    \"email\": "
        			+ "\""+ aEmailAddress +"\","
        			+ "\n    \"organization\": {\n   \"id\": "
        			+ "\"" + aEnviron.getOrganization() + "\",\n   \"type\": \"organization\",\n   \"realm\": \""
        			+ aEnviron.getRealmCode()
        			+ "\"\n},\n    "
        			+ "\"currency\": \"USD\"\n   \n}";

      	
        	RequestBody body = RequestBody.create(mediaType, bodyValues);
        	Request request = new Request.Builder()
        	  //.url("https://apistg.np.covapp.io/person/v3/persons")
              .url(aEnviron.getSiteURL()+"/person/v3/persons")
        	  .post(body)
        	  .addHeader("accept", "application/vnd.com.covisint.platform.person.v1+json")
        	  .addHeader("content-type", "application/vnd.com.covisint.platform.person.v1+json")
        	  .addHeader("authorization", "Bearer "+ aToken)
        	  .addHeader("cache-control", "no-cache")
        	  .addHeader("postman-token", "e0590cdc-93f5-6e75-2f8a-4cea3ec6f359")
        	  .build();
       	
        	//System.out.println("===>createPerson: request" + request.toString());
        	
        	Response response = client.newCall(request).execute(); 
        	
            // Obtain token string
            String responseString = response.body().string();
            
            // Get PersonID
            personID = getPersonIDfromJSON(responseString);     
            
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personID;
    }  

    
    public String createPersonPasswordAccount(Environment aEnviron, String aToken, String aEmailAddress, String aPersonID) {
        String id = "";
        try {

        	System.out.println("===>createPersonPasswordAccount: Starting");
        	
        	OkHttpClient client = new OkHttpClient();
        	ObjectMapper mapper = new ObjectMapper(); 
        	
        	MediaType mediaType = MediaType.parse("application/vnd.com.covisint.platform.person.account.password.v1+json");
        	RequestBody body = RequestBody.create(mediaType, "{\r\n  \"id\":"
        			+ "\""+ aPersonID +"\","
        			+ "\r\n  \"version\":\"0\",\r\n  \"username\" : "
        			+ "\""+ aEmailAddress +"\","
        			+ "\r\n  \"password\":\"test1234\",\r\n  "
        			+ "\"passwordPolicy\": {\r\n      \"id\": \"" + aEnviron.getPasswordPolicy() + "\",\r\n      "
        			+ "\"type\": \"passwordPolicy\",\r\n      \"realm\": \""
        			//+ "S-VCONN-OWNER"
        			+ aEnviron.getRealmCode()
        			+ "\"\r\n    },\r\n    "
        			+ "\"authenticationPolicy\": {\r\n      \"id\": \"" + aEnviron.getAuthenticationPolicy() + "\",\r\n      "
        			+ "\"type\": \"authenticationPolicy\",\r\n      \"realm\": \""
        			//+ "S-VCONN-OWNER"
        			+ aEnviron.getRealmCode()
        			+ "\"\r\n    },\r\n  "
        			+ "\"expiration\" : 50000,\r\n    \"locked\" : false,\r\n    \"unlockInstant\" : 0  \r\n  }");

        	Request request = new Request.Builder()
        	  .url(aEnviron.getSiteURL()+"/person/v3/persons/"
        	  		+ aPersonID
        	  		+ "/accounts/password")
        	  .put(body)
        	  .addHeader("authorization", "Bearer "+ aToken)
        	  .addHeader("accept", "application/vnd.com.covisint.platform.person.account.password.v1+json")
        	  .addHeader("content-type", "application/vnd.com.covisint.platform.person.account.password.v1+json")
        	  .addHeader("cache-control", "no-cache")
        	  .addHeader("postman-token", "86282779-7d56-bcb6-48bc-8148273fe9bc")
        	  .build();

        	//System.out.println("===>createPersonPasswordAccount: Request=" + request.toString());
        	
        	Response response = client.newCall(request).execute(); 
        	
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    } 
    
    public String ActivatePerson(Environment aEnviron, String aToken, String aPersonID) {
        String id = "";
        try {
        	System.out.println("===> Starting ActivatePerson");
        	
        	OkHttpClient client = new OkHttpClient();
 
        	MediaType mediaType = MediaType.parse("application/vnd.com.covisint.platform.person.account.password.v1+json");
        	RequestBody body = RequestBody.create(mediaType, " ");
        	Request request = new Request.Builder()
        	  .url(aEnviron.getSiteURL()+"/person/v3/persons/tasks/activate?personId="
        	  		+ aPersonID
        	  		+ "&reason=activating%20thru%20api%20for%20testing%20create%20person")
        	  .post(body)
        	  .addHeader("authorization", "Bearer "+ aToken)
        	  .addHeader("cache-control", "no-cache")
        	  .addHeader("postman-token", "56d21aa0-7295-05b1-ceb5-48eb4626a980")
        	  .build();

        	System.out.println("ActivatePerson===> Request=" + request.toString());
        	
        	Response response = client.newCall(request).execute();
        	
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    } 
    
  
    public String GrantPackageToPerson(Environment aEnviron, String aToken, String aPersonID, String aPackageID) {
        String id = "";
        try {
        	System.out.println("===>GrantPackageToPerson: Starting ");
        	
        	OkHttpClient client = new OkHttpClient();

        	MediaType mediaType = MediaType.parse("application/vnd.com.covisint.platform.package.grant.v1+json");
        	RequestBody body = RequestBody.create(mediaType, "{\n    \"version\": \"1473803000\",\n    \"status\": \"active\",\n    "
        			+ "\"grantee\": {\n        \"id\": \""
        			+ aPersonID
        			+ "\",\n        \"type\": \"person\"\n    },\n    \"servicePackage\": {\n        \"id\": \""
        			+ aPackageID
        			+ "\"\n    }\n}");
        	Request request = new Request.Builder()
        	  .url(aEnviron.getSiteURL()+"/service/v3/persons/"+aPersonID+"/packages/"+aPackageID)
        	  .put(body)
        	  .addHeader("accept", "application/vnd.com.covisint.platform.package.grant.v1+json")
        	  .addHeader("authorization", "Bearer "+ aToken)
        	  .addHeader("content-type", "application/vnd.com.covisint.platform.package.grant.v1+json")
        	  .addHeader("cache-control", "no-cache")
        	  .addHeader("postman-token", "2adb6fca-2986-5156-fd27-4aa449e57a0d")
        	  .build();

        	//System.out.println("GrantPackageToPerson===> Request=" + request.toString());
        	
        	Response response = client.newCall(request).execute();
            
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    } 
    
    public String getPersonID(Environment aEnviron, String aToken, String aEmailAddress) {
        String personID = "";
        try {
        	System.out.println("===> Starting getPersonID");
        	
        	OkHttpClient client = new OkHttpClient();  	
        	
        	Request request = new Request.Builder()
      			      .url(aEnviron.getSiteURL()+"/person/v3/persons?email="+ URLEncoder.encode(aEmailAddress, "UTF-8"))
        			  .get()
        			  .addHeader("accept", "application/vnd.com.covisint.platform.person.v1+json")
                	  .addHeader("authorization", "Bearer "+ aToken)
        			  .addHeader("cache-control", "no-cache")
        			  .addHeader("postman-token", "2d608f93-0420-9b06-21ba-a6c59f10c9e3")
        			  .build();
            
        	Response response = client.newCall(request).execute();
            String responseString = response.body().string();        	

            // remove leading bracket
            responseString = responseString.substring(2);
            personID = getPersonIDfromJSON(responseString);        
				
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personID;
    }     

    
    public String getPersonIDfromJSON(String aString) {
        String personID = "";
        try {          
        	System.out.println("==>getPersonIDfromJSON: string=" + aString);
        	
            // read ID from JSON object
            JSONObject obj = new JSONObject(aString);
            personID = obj.getString("id");              
            System.out.println("===>  getPersonIDfromJSON: personID=" + personID);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personID;
    }  
    
}
