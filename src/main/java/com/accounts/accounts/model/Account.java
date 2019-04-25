package com.accounts.accounts.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	@Id
    @Column(name="Account_Id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long accountId;
	
	@Column(name="Name",nullable=false)
	private String name;
    @Column(name="Balance",nullable=false)
	private Double balance;
        
	//@Access(AccessType.PROPERTY)
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "Secret_Id") 
	  private Secret secret;
	
    public Secret getSecret() {
		return secret;
	}

	public void setSecret(Secret secret) {
		this.secret = secret;
	}

	public Account() {
    }
             
	/*
	 * public account(String name, Double balance) { this.name = name; this.balance
	 * = balance; }
	 */
	public String getName() {
		return name;
	}
	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
}
