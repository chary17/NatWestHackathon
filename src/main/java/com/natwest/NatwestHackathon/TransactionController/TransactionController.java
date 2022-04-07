package com.natwest.NatwestHackathon.TransactionController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;


import javax.transaction.Transaction;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.natwest.NatwestHackathon.TransactionEntity.TransactionEntity;
import com.natwest.NatwestHackathon.TransactionRepository.TransactionRepository;

@RestController
public class TransactionController {

	private final TransactionRepository transactionRepository;
	
	public TransactionController(TransactionRepository transactionRepository) {
		// TODO Auto-generated constructor stub
		this.transactionRepository = transactionRepository;
	}
	
	@PostMapping("/transaction")
	   ResponseEntity<Object> newTransaction(@RequestBody TransactionEntity transactionObj) throws URISyntaxException {
	
		transactionObj.setAccountFrom(Base64.getEncoder().encodeToString(transactionObj.getAccountFrom().getBytes()));
		transactionObj.setAccountNumber(Base64.getEncoder().encodeToString(transactionObj.getAccountNumber().getBytes()));
		transactionObj.setAccountType(Base64.getEncoder().encodeToString(transactionObj.getAccountType().getBytes()));
		transactionObj.setTransactionAmount(Base64.getEncoder().encodeToString(transactionObj.getTransactionAmount().getBytes()));
		transactionObj.setTransactionCurrency(Base64.getEncoder().encodeToString(transactionObj.getTransactionCurrency().getBytes()));
		 
		 receiverPostrequestCall(transactionObj);
		
		 return new ResponseEntity<>(HttpStatus.OK);
		 }
	
	public void receiverPostrequestCall(TransactionEntity transactionObj) throws URISyntaxException {
	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		URI uri = new URI("http://localhost:8082/decrpted/transaction");
		
		transactionObj.setAccountFrom(new String(Base64.getDecoder().decode(transactionObj.getAccountFrom())));
		transactionObj.setAccountNumber(new String(Base64.getDecoder().decode(transactionObj.getAccountNumber())));
		transactionObj.setAccountType(new String(Base64.getDecoder().decode(transactionObj.getAccountType())));
		transactionObj.setTransactionAmount(new String(Base64.getDecoder().decode(transactionObj.getTransactionAmount())));
		transactionObj.setTransactionCurrency(new String(Base64.getDecoder().decode(transactionObj.getTransactionCurrency())));
		
		HttpEntity<TransactionEntity> httpEntity = new HttpEntity<>(transactionObj, headers);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(uri, httpEntity, TransactionEntity.class);
		
	}
	
	@PostMapping("/decrpted/transaction")
	public void  decrytTransaction(@RequestBody TransactionEntity transactionObj) {
	
	//System.out.print(Base64.getDecoder().decode("OTg3NjU0MzIxMDEy"));
		
	 transactionRepository.save(transactionObj);
		
	}
}
