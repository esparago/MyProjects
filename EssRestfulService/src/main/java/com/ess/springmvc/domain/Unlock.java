package com.ess.springmvc.domain;

import com.ess.springmvc.iot.*;
import com.ess.springmvc.iot.EnvironmentProd;

public class Unlock {

    String response = "unlock";
 
    public Unlock() {

    }
 
    public String getResponse() {
    	
		//establish environment
		EnvironmentProd environProd = new EnvironmentProd();
			
		// Obtain a token
		System.out.println("===> Main: starting");
		Token token = new Token();
		String tokenString = token.createToken(environProd); 
		 
		// execute Command
		IotCommandDeviceUnlock iot = new IotCommandDeviceUnlock();
		String response = iot.execute(tokenString);
		
		// print results
	    System.out.println( "Unlocked device" + response.toString()); 
	    
        return response;
    }
 
}
