package com.cg.prowallet.dao;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.cg.prowallet.bean.CustomerBean;
import com.cg.prowallet.bean.CustomerTranctions;
import com.cg.prowallet.exceptions.CustomerException;
import com.cg.prowallet.exceptions.ExceptionMessage;

public class CustomerDaoImp implements ICustomerDao {

	ArrayList<CustomerBean> custList = new ArrayList<CustomerBean>();
	ArrayList<CustomerTranctions> transList = new ArrayList<>();

	@Override
	public boolean createAccount(CustomerBean customerbean) {
		
		return false;
	}

	@Override
	public double showBalance() {
		CustomerBean bean=new CustomerBean();
		double balance= 0;
		for (CustomerBean custbean : custList) {
			balance=custbean.getBalance();
		}
		return balance;
	}

	@Override
	public boolean withDraw(double amount) throws CustomerException {
		boolean isSuccessful = false;
		CustomerTranctions transaction = new CustomerTranctions();
		double balance;
		for (CustomerBean custbean : custList) {
			if (custbean.getBalance() < amount) {
				throw new CustomerException(ExceptionMessage.ERRORLOWBALANCE);
			} else {
				transaction.setBalance(custbean.getBalance());

				balance = custbean.getBalance() - amount;
				if (custList.set(0, custbean) != null) {
					isSuccessful = true;
				}

				System.out.println(custbean.getBalance());
				LocalDateTime date = LocalDateTime.now();

				transaction.setAmount(amount);
				transaction.settDate(date);
				transaction.settType("Withdraw");
				transaction.setSenderNumber(custbean.getPhoneNumber());
				transList.add(transaction);
			}

		}
		return isSuccessful;
	}

	@Override
	public boolean fundTransfer(BigInteger phonenumber,double amount)throws CustomerException {
		boolean issucessfull= false;
		CustomerDaoImp dao = new CustomerDaoImp();
		for (CustomerBean custbean : custList) {
			if(custbean.getPhoneNumber() == phonenumber) {
				double balance= custbean.getBalance() +amount;
				custbean.setBalance(balance);
			custList.set(custList.indexOf(custbean),custbean);
			LocalDateTime date = LocalDateTime.now();

			CustomerTranctions transaction = new CustomerTranctions() ;
			transaction.setAmount(amount);
			transaction.settDate(date);
			transaction.settType("Deposit");
			transaction.setSenderNumber(custbean.getPhoneNumber());
			transList.add(transaction);
		}
			else {
				throw new CustomerException(ExceptionMessage.ERRORNU);
			}
		}
		
		return issucessfull;
	}

	@Override
	public boolean deposit(double amount) {
		boolean isSuccessful = false;
		CustomerTranctions transaction = new CustomerTranctions();
		double balance;
		for (CustomerBean custbean : custList) {

			transaction.setBalance(custbean.getBalance());

			balance = custbean.getBalance() + amount;
			if (custList.set(0, custbean) != null) {
				isSuccessful = true;
			}

			LocalDateTime date = LocalDateTime.now();

			transaction.setAmount(amount);
			transaction.settDate(date);
			transaction.settType("Deposit");
			transaction.setSenderNumber(custbean.getPhoneNumber());
			transList.add(transaction);

		}
		return isSuccessful;
	}

	@Override
	public ArrayList<CustomerTranctions> printTransaction(LocalDateTime fDate, LocalDateTime tDate, String type) {
		ArrayList<CustomerTranctions> result = new ArrayList<>();
		
		for (CustomerTranctions custtra : transList) {
			if (custtra.gettDate().isAfter(fDate)
					&& custtra.gettDate().isBefore(tDate) && custtra.gettType() == type) {
                result.add(custtra);
			}
		}
		return result;
	}
}

