package com.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dto.entity.Transaction;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer>{

}
