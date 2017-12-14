package com.cisco.custom;

import java.util.Map;

import com.cisco.consumer.Device;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeviceDeserializer implements Deserializer<Device>  {

	@Override
	public void configure(Map config, boolean isKey) {
	}

	@Override
	public Device deserialize(String topic, byte[] data) {
		  ObjectMapper mapper = new ObjectMapper();
		    Device device = null;
		    try {
		      device = mapper.readValue(data, Device.class);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    return device;
	}

	@Override
	public void close() {
	}


}
