package com.accounts.accounts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="secrets")
public class Secret {
	
	@Id
    @Column(name="Secret_Id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int secretId;
	
	@Column(name="Password",nullable=false)
	private int password;
	
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	@Column(name="username",nullable=false)
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getSecretId() {
		return secretId;
	}
	public void setSecretId(int secretId) {
		this.secretId = secretId;
	}
	
}
