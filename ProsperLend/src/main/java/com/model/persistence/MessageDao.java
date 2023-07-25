package com.model.persistence;

import javax.persistence.Id;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dto.entity.Message;
@Transactional
@Repository
public interface MessageDao extends JpaRepository<Message, Integer>{
	
	@Modifying
	@Query(value = "insert into MESSAGES values(?,?,?,?)",nativeQuery = true)
	int insertMessage(int messageId,String userEmail,String userName, String message);
	

}
