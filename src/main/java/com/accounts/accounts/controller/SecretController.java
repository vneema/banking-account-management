package com.accounts.accounts.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.accounts.accounts.model.Account;
import com.accounts.accounts.model.Secret;
import com.accounts.accounts.service.SecretService;

@RestController
//@RequestMapping("/secrets")
public class SecretController {
	
	public SecretService secretService;
	
	
	}
