package com.cisco.custom;

import java.util.Map;

import com.cisco.consumer.Device;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeviceSerializer implements Serializer<Device> {

	@Override
	public void configure(Map<String, ?> config, boolean isKey) {
		
	}

	@Override
	public byte[] serialize(String topic, Device data) {
		  byte[] retVal = null;
		    ObjectMapper objectMapper = new ObjectMapper();
		    try {
		    	String str = objectMapper.writeValueAsString(data);
		      retVal = str.getBytes();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    return retVal;
	}

	@Override
	public void close() {
		
	}
	
	
}
