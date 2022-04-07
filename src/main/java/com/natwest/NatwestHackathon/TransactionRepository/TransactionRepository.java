package com.natwest.NatwestHackathon.TransactionRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natwest.NatwestHackathon.TransactionEntity.TransactionEntity;

public interface TransactionRepository extends
						JpaRepository<TransactionEntity, Long>{

}
