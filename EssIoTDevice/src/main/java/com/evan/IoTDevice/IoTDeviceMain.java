package com.evan.IoTDevice;

/**
 * Main class to run as a device
 *
 */
public class IoTDeviceMain
{
    public static void main( String[] args )
    {
        System.out.println( "Starting Device 1" );      
        MQTTDeviceClient device1 = new MQTTDeviceClient();
        device1.createMQTTConnection();
        device1.publishEvent("cfbe9d2f-71e7-4c9c-afa0-97380745502b", "e9788d71-48a1-4391-9be9-7160ff90d046");
        
        System.out.println( "Stopping Device 1" );           
    }
}
