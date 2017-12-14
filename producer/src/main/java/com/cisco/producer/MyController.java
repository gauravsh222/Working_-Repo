package com.cisco.producer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/producer")
public class MyController {

	private static final String UPLOAD_FOLDER = "C:\\Users\\gaurav.sharma\\Desktop\\app_upload\\";

	@Autowired
	private KafkaTemplate<String, Device> template;

	@Value("${jsa.kafka.topic}")
	private String topic;

	@Autowired
	RestTemplate tertTemplate;
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ModelAndView init() {
		return new ModelAndView("addDevice", "device", new Device());
	}

	@RequestMapping(value = "/pub", method = RequestMethod.POST)
	public void produce(@ModelAttribute Device device) {
		ListenableFuture<SendResult<String, Device>> obj = template
				.send(new ProducerRecord<String, Device>(topic, device));
		System.out.println("isDone : " + obj.isDone());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<String> save(@ModelAttribute Device device, @RequestParam("File") MultipartFile file) {
		System.out.println("Save Service Called and file is : " + file.getOriginalFilename());
		if (file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please select a file and try again");
		}

		String response = null;
		try {
			response = tertTemplate.postForEntity(
					"http://API-Gateway/api/jpa/device/save", device,
					String.class).getBody();
			
			// read and write the file to the selected location-
			try {
				byte[] bytes = file.getBytes();
				java.nio.file.Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
				Files.write(path, bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Occured in Consumer Service");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Service Not Available");
		}
		System.out.println("Response : " + response);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
