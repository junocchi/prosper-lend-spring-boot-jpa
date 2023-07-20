package com.team4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ActiveProfiles;

import com.dto.entity.Loans;
import com.model.persistence.LoanDao;


@ActiveProfiles("test")
@SpringBootTest
class LoanDaoTest {
	
	
	@Autowired
	private LoanDao dao;
	
	
	@Test
    @DisplayName("Test for getting all Loans")
    public void ReturnAllLocationTests01() {
        List<Loans> loansList = dao.findAll();
        assertNotNull(loansList);
        
    }
	

}
