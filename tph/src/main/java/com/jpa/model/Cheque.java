package com.jpa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="CQ")
public class Cheque extends Payment {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7388957534000007357L;

	private String chequeNumber;
	private String chequeIssuedBank;

	public String getChequeIssuedBank() {
		return chequeIssuedBank;
	}

	public void setChequeIssuedBank(String chequeIssuedBank) {
		this.chequeIssuedBank = chequeIssuedBank;
	}

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ChequeIssuedBank : " + chequeIssuedBank + ", chequeNumber : " + chequeNumber; 
	}
}
