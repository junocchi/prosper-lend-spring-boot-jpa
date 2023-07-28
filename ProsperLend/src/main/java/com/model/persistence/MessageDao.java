package com.model.persistence;


import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dto.entity.Messages;

@Repository
@Transactional
public interface MessageDao extends JpaRepository<Messages, Integer>{
	
	
	
//	@Modifying
//	@Query("update Messages set message=message+:me where messageId=:id")
//	int updateMessage(@Param("id") int messageId, @Param("me") String newMessage);
	
	
	@Modifying
	@Query("update Messages m set m.message = :me where m.messageId = :id")
	int updateMessage(@Param("id") int messageId, @Param("me") String newMessage);
	
	@Modifying
	@Query(value = "insert into Messages (userEmail, userName, message) VALUES(?, ?, ?)",nativeQuery = true)
	int addMessage( String userEmail, String userName, String message);


}


