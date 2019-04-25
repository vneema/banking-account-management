package com.accounts.accounts.serviceImpl;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounts.accounts.dao.AccountDAO;
import com.accounts.accounts.model.Account;
import com.accounts.accounts.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;
	

	
	@Override
	public boolean addAccount(Account account) {
		return accountDAO.addAccount(account);		
	}

	@Override
	public List<Account> getListOfAccount() {
		
		// TODO Auto-generated method stub
		return accountDAO.getListOfAccount();
	}

	
	@Override
	public Double getAllBalanceAmount() {

		double totalBalance=0.0;
		double initialBalance=0.0;
		List<Account> listOfAccount=accountDAO.getListOfAccount();
		for(Account account:listOfAccount) {
			initialBalance=totalBalance+account.getBalance();
			totalBalance=initialBalance;
			//System.out.println("totalBalance"+totalBalance);
		}
		System.out.println("totalBalance"+totalBalance);
		return totalBalance;
		}

	
	@Override
	public  List<Account> deductTaxFromEachAccount(Double deductTaxAmount) {
		
	List<Account> listOfAccount=accountDAO.getListOfAccount();
	for(Account account:listOfAccount) {
		//Account account1=new Account();
		double newAmountAfterDeduction=account.getBalance()-((deductTaxAmount/100)*account.getBalance());
		account.setBalance(newAmountAfterDeduction);
		accountDAO.updateAccount(account.getAccountId(),account);
	}
    // TODO Auto-generated method stub
		return listOfAccount;
	}

	@Override
	public Double getLowestAccountBalance() {
		
		List<Account> listOfAccounts=accountDAO.getListOfAccount();
        double lowest = listOfAccounts.get(0).getBalance();
		if(listOfAccounts.isEmpty()) {
			return lowest;
		}
		for(Account account: listOfAccounts) {
			if(lowest > account.getBalance()) {
			lowest=account.getBalance();
		}	
		}
		return lowest;
		// TODO Auto-generated method stub
	}


}
