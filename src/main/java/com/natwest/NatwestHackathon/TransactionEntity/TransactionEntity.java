package com.natwest.NatwestHackathon.TransactionEntity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TransactionEntity {
	private @Id @GeneratedValue Long id;
	private String accountNumber;
	private String accountType;
	private String transactionAmount;
	private String transactionCurrency;
	private String accountFrom;
	
	
	
	public TransactionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionEntity(Long id, String accountNumber, String accountType, String transactionAmount,
			String transactionCurrency, String accountFrom) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.transactionAmount = transactionAmount;
		this.transactionCurrency = transactionCurrency;
		this.accountFrom = accountFrom;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionCurrency() {
		return transactionCurrency;
	}
	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}
	public String getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}
	@Override
	public String toString() {
		return "TransactionEntity [id=" + id + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", transactionAmount=" + transactionAmount + ", transactionCurrency=" + transactionCurrency
				+ ", accountFrom=" + accountFrom + "]";
	}
	
	
	
}
