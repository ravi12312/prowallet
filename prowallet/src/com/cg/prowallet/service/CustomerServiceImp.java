package com.cg.prowallet.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import com.cg.prowallet.bean.CustomerBean;
import com.cg.prowallet.bean.CustomerTranctions;
import com.cg.prowallet.exceptions.CustomerException;
import com.cg.prowallet.exceptions.ExceptionMessage;

public class CustomerServiceImp implements IClientService {

	CustomerServiceImp dao = new CustomerServiceImp();
	CustomerBean bean = new CustomerBean();
	@Override
	public boolean createAccount(CustomerBean cb) throws CustomerException {
		boolean isCreated = false;
		if (validations(cb)) {
			isCreated = dao.createAccount(cb);
		} else {
			isCreated = false;
		}
		return isCreated;
	}

	@Override
	public double showBalance() {
		// TODO Auto-generated method stub
		return dao.showBalance();
	}

	@Override
	public boolean withDraw(double amount) throws CustomerException {
		// TODO Auto-generated method stub
		return dao.withDraw(amount);
	}

	@Override
	public boolean fundTransfer(double amount) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(amount);
	}

	@Override
	public boolean deposit(double amount) {
		// TODO Auto-generated method stub
		return dao.deposit(amount);
	}

	@Override
	public ArrayList<CustomerTranctions> printTransaction(LocalDateTime fDate, LocalDateTime tDate, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validations(CustomerBean cb) throws CustomerException {
		boolean isValid = false;
		if (cb.getFirstName().trim().length() < 4) {
			throw new CustomerException(ExceptionMessage.ERRORNAME);
		} else if (cb.getLastName().trim().length() < 4) {
			throw new CustomerException(ExceptionMessage.ERRORNAME);
		} else if (!(String.valueOf(cb.getPhoneNumber())
				.matches("(0)?[6-9][0-9]{9}"))) {
			throw new CustomerException(ExceptionMessage.ERRORPHONE);
		} else if (cb.getAddress().length() == 0) {
			throw new CustomerException(ExceptionMessage.ERRORADDRESS);
		} else if (!(cb.getEmail()
				.matches("^[A-Za-z0-9.]+@[A-Za-z0-9.-]+\\\\.[A-Z]{2,6}$"))) {
			throw new CustomerException(ExceptionMessage.ERROREMAIL);
		} else {
			isValid = true;
		}
		return isValid;
	}

	@Override
	public boolean validPhoneNumber(String phone) throws CustomerException {
		boolean isTrue = false; 
		if (phone.matches("(0)?[6-9][0-9]{9}")) {
			     
				isTrue = true;
			}
		else{
             throw new CustomerException(ExceptionMessage.ERRORPHONE);
		}
		return false;
	}

	@Override
	public boolean validAmount(double amount) throws CustomerException {
		boolean isValid = false;
		if(amount > 500){
			isValid = true;
		}
		else
		{
			throw new CustomerException(ExceptionMessage.ERRORBALANCE);
		}
		return isValid;
	}

}
