package com.accounts.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.accounts.model.Account;
import com.accounts.accounts.service.AccountService;
import com.accounts.accounts.service.SecretService;

@RestController
//@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private SecretService secretService;
	
	
	@RequestMapping("/")
	public String hello() {
		return "API is Working !!!";
	}
	
	@RequestMapping(value="/services/addAccount",method=RequestMethod.POST)
	public boolean addAccount(@ModelAttribute Account account) {
		boolean isSuccess = accountService.addAccount(account);
		if(isSuccess) {
			return secretService.addRegister(account);
		}
		return false;
	}
	
	@RequestMapping(value="/services/getAll",method=RequestMethod.GET)
	public List<Account> getList(){
			return accountService.getListOfAccount();
		}
	
	
	@RequestMapping(value="/services/getAllBalanceAmount",method=RequestMethod.GET)
	public Double  getAllBalanceAmount(){
			return accountService.getAllBalanceAmount();
		}
	
	@RequestMapping(value="/services/deductTaxFromEachAccount",method=RequestMethod.PUT)
	public List<Account> deductTaxFromEachAccount( Double deductTaxAmount){
			return accountService.deductTaxFromEachAccount(deductTaxAmount);
		}
	
	@RequestMapping(value="/services/getLowestAccountBalance",method=RequestMethod.GET)
	public Double getLowestAccountBalance(){
          return accountService.getLowestAccountBalance();
		}
	
}
