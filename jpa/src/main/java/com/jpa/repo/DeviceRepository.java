package com.jpa.repo;

import org.springframework.data.repository.CrudRepository;

import com.jpa.model.Device;

public interface DeviceRepository extends CrudRepository<Device, Integer> {
}
