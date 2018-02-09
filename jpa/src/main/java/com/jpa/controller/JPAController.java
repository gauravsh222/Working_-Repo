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
	public List<Device> getDevices() {
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
	public Device addDevice(@RequestBody Device device) {
		 return repo.save(device);
	}
	
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public Device getDevice() {
		 Iterable<Device> it = repo.findAll();
		 Iterator<Device> iter = it.iterator();
		 while (iter.hasNext()) {
			return (Device) iter.next();
		}
		return null;
	}
	
}
