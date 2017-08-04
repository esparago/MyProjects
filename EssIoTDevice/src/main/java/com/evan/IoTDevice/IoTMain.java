package com.evan.IoTDevice;

/**
 * Main class to run as a device
 *
 */
public class IoTMain 
{
    public static void main( String[] args )
    {
	
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
    }
}
