package com.evan;

import java.io.IOException;

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

import okio.Buffer;

public class Token {
    
	public Token() {
		// Token management
	}

    /**
     * Gets a token from the APIs.
     *
     * @return
     */
    public String createToken(Environment aEnviron) {
        String token = "";
        try {
        	
        	OkHttpClient client = new OkHttpClient();
        	ObjectMapper mapper = new ObjectMapper(); 
     	
            RequestBody body = new FormBody.Builder()
                    .add("grant_type", "client_credentials")
                    .build();
                 	
            Request request = new Request.Builder()
                    .url(aEnviron.getSiteURL()+"/oauth/v3/token")
                    .post(body)
                    .addHeader("authorization", "Basic " + aEnviron.getBearer())
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .build();
          
            Response response = client.newCall(request).execute();
            
            // Obtain token string
            String responseString = response.body().string();

            ObjectNode jackson = mapper.readValue(responseString, ObjectNode.class);
            JsonNode jacksonAccessToken = jackson.get("access_token");
            token = jacksonAccessToken.toString();  
            
            // remove quotes
            token = token.substring(1);
            int position = token.indexOf("\"");
            token = token.substring(0, position);

            System.out.println("Token: token= " + token);
            
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return token;
    }  
    
}
