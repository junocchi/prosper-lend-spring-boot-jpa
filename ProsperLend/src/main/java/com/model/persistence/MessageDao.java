package com.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dto.entity.Message;

@Repository
public interface MessageDao extends JpaRepository<Message, Integer>{

}
