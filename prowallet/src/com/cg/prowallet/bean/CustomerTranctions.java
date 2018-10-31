package com.cg.prowallet.bean;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class CustomerTranctions {

	private LocalDateTime tDate;
	private String tType;
	private BigInteger senderNumber;
	private double amount;
	private double balance;

	public LocalDateTime gettDate() {
		return tDate;
	}
	public void settDate(LocalDateTime tDate) {
		this.tDate = tDate;
	}
	public String gettType() {
		return tType;
	}
	public void settType(String tType) {
		this.tType = tType;
	}
	public BigInteger getSenderNumber() {
		return senderNumber;
	}
	public void setSenderNumber(BigInteger senderNumber) {
		this.senderNumber = senderNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	}
