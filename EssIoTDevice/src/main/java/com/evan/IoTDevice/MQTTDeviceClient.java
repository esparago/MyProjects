package com.evan.IoTDevice;

import javax.json.*;
import org.eclipse.paho.client.mqttv3.*;

public class MQTTDeviceClient implements MqttCallback {
	
	MqttClient client;
	MqttConnectOptions conOpt;
	static String HOST = "mqtt.covapp.io";
	static String PORT = "8883";
	static String USERNAME = "5e6895b5-1afe-40e7-9789-4181dc59cc6f";
	static String PASSWORD = "b3f802d0-57ce-4d65-bfeb-b4c023cef6d5";
	static String CLIENTID = "bd16657A4B52490F8DBC";
	static String CONSUMERTOPIC = "784ecb53-f953-4278-812a-188c0b1c6d53";
	static String PRODUCERTOPIC = "87b0b555-25e3-45c7-a2d4-935f332f6392";
	static String DEVICEID = "ac809023-f39d-4205-af72-ed43fd37470c";
	static String EVENTID = "2d5afdff-641f-4165-973d-c36bf618da55";

	public void createMQTTConnection() {
		conOpt = new MqttConnectOptions();
		conOpt.setCleanSession(true);
		conOpt.setKeepAliveInterval(30);
		conOpt.setUserName(USERNAME);
		conOpt.setPassword(PASSWORD.toCharArray());
		try {
	        System.out.println( "createMQTTConnection" ); 
	        
			client = new MqttClient("ssl://" + HOST + ":" + PORT, CLIENTID);
			client.setCallback(this);
			client.connect(conOpt);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			client.subscribe(CONSUMERTOPIC);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void publishEvent(String deviceId, String eventTemplateId) {
	      try {    	  
	            System.out.println( "publishEvent" ); 
	    	  	JsonObject deviceEventMessage = Json.createObjectBuilder()
  			  	.add("messageId", "clever message id 1")
  			  	.add("deviceId", deviceId)
  			  	.add("eventTemplateId", eventTemplateId)
  			  	.add("timestamp", 1.1)
				.add("lightStatus", 2)
  			  	.build();  			  	
	      		MqttMessage message = new MqttMessage();
	      		message.setPayload(deviceEventMessage.toString().getBytes());
			client.publish(PRODUCERTOPIC, message);
            System.out.println( "event was published" ); 
		} catch (MqttPersistenceException e) {
			e.printStackTrace();
		} catch (MqttException e) {
			e.printStackTrace();
		}  
	}

	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub
		
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
	}	

}