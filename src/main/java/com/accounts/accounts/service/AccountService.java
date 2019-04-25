package com.accounts.accounts.service;

import java.util.List;

import com.accounts.accounts.model.Account;

public interface AccountService
{
public boolean addAccount(Account account);
public List<Account> getListOfAccount();
public Double getAllBalanceAmount();
public List<Account> deductTaxFromEachAccount(Double deductTaxAmount);
public Double getLowestAccountBalance();

}
