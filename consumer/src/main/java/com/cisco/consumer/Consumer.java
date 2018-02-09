package com.cisco.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class Consumer {
	  
	@Autowired
	RestTemplate template;
	
	  @KafkaListener(topics = "${jsa.kafka.topic.vslp}")
	  public void receive_vslp(ConsumerRecord<?, ?> consumerRecord) {
		  System.out.println("Payload for vslp = " + consumerRecord.toString());
		  System.out.println("Data Type of payload = " + consumerRecord.value().getClass());
		  System.out.println ("Value of payload = " + consumerRecord.value());
		  Device device = (Device) consumerRecord.value();
		  
		  // calling JPA service to persist in DB
		  System.out.println("Calling DB Service");
//		  String response = template.postForEntity("http://JPA/device/save", device, String.class).getBody();
		  Device response = null;
		try {
			response = template.postForEntity("http://API-Gateway/api/jpa/device/save", device, Device.class).getBody();
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Occured in Consumer Service");
			e.printStackTrace();
		}
		  System.out.println("Response : " + response);
	  }
	  
	  @KafkaListener(topics = "${jsa.kafka.topic.xyz}")
	  public void receive_cisco(ConsumerRecord<?, ?> consumerRecord) {
		  System.out.println("Payload for xyz = " + consumerRecord.toString());
		  System.out.println("Data Type of payload = " + consumerRecord.value().getClass());
		  System.out.println ("Value of payload = " + consumerRecord.value());
	  }
}
