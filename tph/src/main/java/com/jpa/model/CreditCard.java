package com.jpa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="")
public class CreditCard extends Payment {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3042812038600311521L;
	private String creditCardType;
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return "Card No. " + number + ", Credit Card Type : " + creditCardType;
}
}
