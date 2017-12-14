package com.jpa.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.model.Device;
import com.jpa.repo.DeviceRepository;

@RestController
@RequestMapping("/device")
public class JPAController {
	
	@Autowired
	DeviceRepository repo;
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public List<Device> getDevice() {
		System.out.println("Called Get");
		List<Device> list = new ArrayList<Device>();
		 Iterable<Device> it = repo.findAll();
		 Iterator<Device> iter = it.iterator();
		 while (iter.hasNext()) {
			Device device = (Device) iter.next();
			list.add(device);
		}
		return list;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String addDevice(@RequestBody Device device) {
		System.out.println("save called : " + device.getIpAddress());
		repo.save(device);
		return "Saved Device";
	}
	
	
}
