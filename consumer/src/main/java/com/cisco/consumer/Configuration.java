package com.cisco.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.web.client.RestTemplate;

import com.cisco.custom.DeviceDeserializer;

@org.springframework.context.annotation.Configuration
@EnableKafka
public class Configuration {

	@Value("${jsa.kafka.bootstrap-servers}")
	private String bootstrapServer;

	@Value("${jsa.kafka.consumer.group-id}")
	private String groupId;

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		
		return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	}

	 @Bean
	  public Map<String, Object> consumerConfigs() {
		 Map<String, Object> props = new HashMap<>();
			props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
			props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
			props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
			props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, DeviceDeserializer.class);
	    return props;
	  }
	 
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   // Do any additional configuration here
	   return builder.build();
	}
	@Bean
	public Consumer consumer(){
		return new Consumer();
	}
}
