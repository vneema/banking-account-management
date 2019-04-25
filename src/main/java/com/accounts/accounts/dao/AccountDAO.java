package com.accounts.accounts.dao;

import java.util.List;

import com.accounts.accounts.model.Account;

public interface AccountDAO {

	public boolean addAccount(Account account);
	public List<Account> getListOfAccount();
    public List<Account>updateAccount(Long account_id, Account account);

}
