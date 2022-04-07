package com.natwest.NatwestHackathon.TransactionEntity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TransactionEntity {
	private @Id @GeneratedValue Long id;
	private long accountNumber;
	private String accountType;
	private int transactionAmount;
	private String transactionCurrency;
	private long accountFrom;
	
	
	public TransactionEntity(Long id, long accountNumber, String accountType, int transactionAmount,
			String transactionCurrency, long accountFrom) {
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
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int gettransactionAmount() {
		return transactionAmount;
	}
	public void settransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionCurrency() {
		return transactionCurrency;
	}
	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}
	public long getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(long accountFrom) {
		this.accountFrom = accountFrom;
	}

	@Override
	public String toString() {
		return "TransactionEntity [id=" + id + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", transactionAmount=" + transactionAmount + ", transactionCurrency=" + transactionCurrency
				+ ", accountFrom=" + accountFrom + "]";
	}
	
	
}
