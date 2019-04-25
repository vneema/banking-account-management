package com.accounts.accounts.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounts.accounts.dao.SecretDAO;
import com.accounts.accounts.daoImpl.SecretDAOImpl;
import com.accounts.accounts.model.Account;
import com.accounts.accounts.model.Secret;
import com.accounts.accounts.service.SecretService;

@Service
public class SecretServiceImpl implements SecretService

{
	@Autowired
	private SecretDAO secretDAO;

	@Override
	public boolean addRegister(Account account) {
		// TODO Auto-generated method stub
		
		Secret secret = new Secret();
		secret.setUsername(account.getName());
		secret.setPassword((int)(Math.random()*9000)+1000);
		return secretDAO.addRegister(secret);
	}
	
	
	
	
	
	

}
