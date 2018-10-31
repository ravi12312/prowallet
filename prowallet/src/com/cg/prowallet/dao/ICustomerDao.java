package com.cg.prowallet.dao;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.cg.prowallet.bean.CustomerBean;
import com.cg.prowallet.bean.CustomerTranctions;
import com.cg.prowallet.exceptions.CustomerException;

public interface ICustomerDao {

	public boolean createAccount(CustomerBean customerbean);
	public double showBalance();
	public boolean withDraw(double amount) throws CustomerException;
	public boolean fundTransfer(BigInteger phoneNumber,double amount) throws CustomerException;
	public boolean deposit(double amount);
	public ArrayList<CustomerTranctions> printTransaction(LocalDateTime fDate,LocalDateTime tDate,String type);
}
