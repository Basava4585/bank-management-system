package com.sop.bank_management_system.entity;

public class AccountDetail {
	private int appno;
	private String card;
	private String pin;
	private String accountType;
	private String services;
	
	public int getAppno() {
		return appno;
	}
	public void setAppno(int appno) {
		this.appno = appno;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
}
