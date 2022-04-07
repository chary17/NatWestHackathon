package com.natwest.NatwestHackathon.TransactionController;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	ResponseEntity<Object> newTransaction(@RequestBody TransactionEntity transactionObj) {
		
	 transactionRepository.save(transactionObj);
	 return ResponseEntity.status(HttpStatus.CREATED).body(Map.of
		 (
				 "StatusCode",201,
				 "Message", "Data created successully"));
	}
	
}
