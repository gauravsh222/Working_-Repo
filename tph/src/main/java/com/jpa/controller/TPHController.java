package com.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jpa.model.Cheque;
import com.jpa.model.CreditCard;
import com.jpa.model.Payment;
import com.jpa.repo.Repository;

@RestController
@RequestMapping("/tph")
public class TPHController {
	

	@Autowired
	Repository repo;
	

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ModelAndView init() {
		return new ModelAndView("addPayments", "payments", new CreditCard());
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/cc")
	public Payment saveCreditCard(CreditCard cc) {
		System.out.println(cc);
		return repo.save(cc);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/cq")
	public Payment saveCheque(Cheque cq) {
		System.out.println(cq);
		return repo.save(cq);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/payments")
	public List<Payment> findPayments() {
		return repo.findAll();
	}
	
}
