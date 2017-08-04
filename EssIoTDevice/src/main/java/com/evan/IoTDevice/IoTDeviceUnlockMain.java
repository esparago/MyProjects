package com.evan.IoTDevice;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Main class to run as a device
 *
 */
public class IoTDeviceUnlockMain
{
    public static void main( String[] args )
    {
    	OkHttpClient client = new OkHttpClient();
		String tokenString = "";
		Response response = null;
		
		//establish environment
		EnvironmentProd environProd = new EnvironmentProd();
			
		// Obtain a token
		System.out.println("===> Main: starting");
		Token token = new Token();
		tokenString = token.createToken(environProd); 
		 
		// execute Command 
	    MediaType mediaType = MediaType.parse("application/json");
	    RequestBody body = RequestBody.create(mediaType, "{\n  \"deviceId\": \"31570947-7cec-4f8a-b666-b8877adab94d\","
	    			+ "\n  \"commandId\": \"797bd5ce-331b-4bd8-a0be-2ab804e8ae33\","
	    			+ "\n  \"VIN\": \"string\","
	    			+ "\n  \"CUID\": \"string\","
	    			+ "\n  \"messageInfo\":\"JSON:UnLockDoors:1.0\"\n}");
	    Request request = new Request.Builder()
	    	  .url("https://api.us1.covisint.com/composer/v2/composer/command")
	    	  .post(body)
	    	  .addHeader("accept", "application/json")
	    	  .addHeader("content-type", "application/json")
	    	  .addHeader("authorization", "Bearer "+ tokenString)
	    	  .addHeader("cache-control", "no-cache")
	    	  .addHeader("postman-token", "68f5725b-e9df-3e94-6fdc-66097c99225d")
	    	  .build();
	
	    try {
				response = client.newCall(request).execute();
			} catch (IOException e) {
				e.printStackTrace();
		}
	       
	    System.out.println( "Unlocked device" + response.toString());           
    }
}
