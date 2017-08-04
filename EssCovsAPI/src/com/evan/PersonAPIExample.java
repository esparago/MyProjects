package com.evan;

import com.evan.Token;


/**
 * This class was created to flex my coding creds.  The intent is to use the Covisint API's.
 * @author Evan Sparago
 */
public class PersonAPIExample {

	public PersonAPIExample() {
		// use Covisint API's
		    // test comment
	}

	public static void main(String[] args) {
		Environment environ;
		String tokenString = "";
		String personId = "";
		Boolean environStageSwitch = false;
		
		//Stage
		// String emailAddress = "evantest30@mailinator.com";	//STAGE		
		Environment environStage = new Environment("https://apistg.np.covapp.io/", 
				"S-VCONN-OWNER",                                                        //realm
				"OS-VCONN-OWNER1473802", 				                                //organization
				"170c23cf-65a7-489c-a86f-741fddc19ad2",                                 //id
				"KytgkoZdoGuLNzUdlStDCiWp47wiYmeb",                                     //client id
				"p6iDpHVnAmKmq3JT",                                                     //client secret
				"S3l0Z2tvWmRvR3VMTnpVZGxTdERDaVdwNDd3aVltZWI6cDZpRHBIVm5BbUttcTNKVA==", //bearer
				"7e5fc237-1524-4c1b-9355-0b6f0e7063cd",                                 //password policy
				"a625b889-be04-4fb8-a7d8-3e9af8dd60b9",                                 //authentication policy
				"PS-VCONN-OWNER1473803000",                                             //portal
				"PS-VCONN-OWNER96052816",                                               //bentley
				"PS-VCONN-OWNER96052859"                                                //lamborghini
				);
		
		//Prod
		 String emailAddress = "evantest31@mailinator.com";	//PROD		
		 Environment environProd = new Environment("https://api.us1.covisint.com", 
				"BLPOC-OWNER",                                                          //realm
				"OBLPOC-OWNER590702", 			                                       //organization				
				"8cc63ded-fbd8-45e0-861f-7ea28da85855",                                 //id
				"GXr3PsUoLJBPgzdprTXsKAXNLZMm6yPM",                                     //client id
				"CcJLDn7OGuyfVJKy",                                                     //client secret 
				"R1hyM1BzVW9MSkJQZ3pkcHJUWHNLQVhOTFpNbTZ5UE06Q2NKTERuN09HdXlmVkpLeQ==", //bearer
				"9078b9c1-f06f-4f77-b7c2-1c46ab12b00e",                                 //password policy
				"ce2a0581-8ddf-444e-b7ad-501dd9b2ebf3",                                                                  //authentication policy				
				"PBLPOC-OWNER590703000",                                                //portal
				"PBLPOC-OWNER13906686",                                                 //bentley
				"PBLPOC-OWNER13906691"                                                  //lamborghini
				);	
		 
		 if(environStageSwitch) { 
			 environ = environStage;
			 System.out.println("===> Main: using Stage");
		 } else { 
			 environ = environProd;
			 System.out.println("===> Main: using Prod");
		 }
		
		// Obtain a token
		System.out.println("===> Main: starting");
		Token token = new Token();
		tokenString = token.createToken(environ); 	
 
        // Create a Person Object
        Person person = new Person();    

        // Create a Person
        personId = person.createPerson(environ, tokenString, emailAddress);
        //personId = "FB3ZNW22";
         
        // Create a Person Password Account
        person.createPersonPasswordAccount(environ, tokenString, emailAddress, personId);    

        // Activate a Person
        person.ActivatePerson(environ, tokenString, personId);   

        // Obtain personID (can be used to see if this person already exists
        personId = person.getPersonID(environ, tokenString, emailAddress);
		
        // Grant Package(s) to Person
        person.GrantPackageToPerson(environ, tokenString, personId, environ.getPortalPackage()); //S-VCONN-OWNER Portal
        person.GrantPackageToPerson(environ, tokenString, personId, environ.getBentleyPackage());  //Bentley
        person.GrantPackageToPerson(environ, tokenString, personId, environ.getLamborghiniPackage());  //Lamborghini

        
        // Close up shop    		
        System.out.println("===> Done");   			
	}

}
