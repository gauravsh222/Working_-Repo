package com.jpa.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.model.Payment;

public interface Repository extends JpaRepository<Payment, Serializable> {

}
