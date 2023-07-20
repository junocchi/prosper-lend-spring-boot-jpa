package com.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dto.entity.Business;

public interface BusinessDao extends JpaRepository<Business, Integer> {

}
