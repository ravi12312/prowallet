package com.cg.prowallet.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.cg.prowallet.bean.CustomerBean;
import com.cg.prowallet.bean.CustomerTranctions;
import com.cg.prowallet.exceptions.CustomerException;
public interface IClientService {

	public boolean createAccount(CustomerBean cb) throws CustomerException;
	public double showBalance();
	public boolean withDraw(double amount) throws CustomerException;
	public boolean fundTransfer(double amount);
	public boolean deposit(double amount);
	public ArrayList<CustomerTranctions> printTransaction(LocalDateTime fDate,LocalDateTime tDate,String type);
	public boolean validations(CustomerBean cb) throws CustomerException;
	public boolean validPhoneNumber(String phone) throws CustomerException;
	public boolean validAmount(double amount) throws CustomerException;
}
