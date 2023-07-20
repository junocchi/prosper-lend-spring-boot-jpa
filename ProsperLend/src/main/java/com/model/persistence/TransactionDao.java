package com.model.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dto.entity.Transaction;

@Transactional
@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer>{

}
