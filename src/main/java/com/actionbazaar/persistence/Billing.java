package com.actionbazaar.persistence;

import java.io.Serializable;

public class Billing implements Serializable {

	private static final long serialVersionUID = 2512163540107659905L;

	protected long billingId;

	protected String accountNumber;

	protected String expiryDate;

	protected String secretCode;

	protected Address address;

	public Long getBillingId() {
		return this.billingId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public String getSecretCode() {
		return secretCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setBillingId(Long billingId) {
		this.billingId = billingId;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}