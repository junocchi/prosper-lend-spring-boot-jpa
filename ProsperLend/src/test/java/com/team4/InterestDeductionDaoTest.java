package com.team4;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ActiveProfiles;

import com.dto.entity.InterestDeduction;
import com.model.persistence.InterestDeductionDao;

@ActiveProfiles("test")
@SpringBootTest
class InterestDeductionDaoTest {

	@Autowired
	private InterestDeductionDao dao;

	@Test
	@DisplayName("Test for getting all Interest Deductions")
	public void ReturnAllDeductionsTests01() {
		List<InterestDeduction> deductionsList = dao.findAll();
		assertNotNull(deductionsList);

	}

	@Test
	@DisplayName("Test for getting Interest Deduction by ID")
	public void ReturnDeductionsByIDTest() {
		InterestDeduction deductions = dao.findById(1).orElse(null);
		assertNotNull(deductions);
		assertEquals(deductions.getItems(), "Carbon neutral");

	}

	@Test
	@DisplayName("Test for getting Deductions by ID that doesn't exist")
	public void ReturnDeductionsByIDTest02() {
		InterestDeduction deductions = dao.findById(888).orElse(null);
		assertNull(deductions);
	}

	@Test
	@DisplayName("Test if Deductions is added sucessfully")
	public void AddDeductionTest() {

		String item = "Empowering Women Reward";
		double amount = 1;

		int result = dao.addDeduction(item, amount);
		
		assertEquals(result, 1);
		assertEquals(dao.findAll().size(), 6);
		
		dao.deleteById(dao.getLatestDeduction());
	}

	
	@Test
	@DisplayName("Test if Deduction is deleted successfully")
	public void DeleteDeductionTest() {
	    String item = "Empowering Women Reward";
	    double amount = 1;
	    dao.addDeduction(item, amount);
	    int id = dao.getLatestDeduction();

	    assertEquals(dao.findById(id).orElse(null).getItems(), item);

	    dao.deleteById(id);

	    assertTrue(dao.findById(id).isEmpty());
	}

	@Test
	@DisplayName("Test if Deduction is updated sucessfully")
	public void UpdateBusinessTest() {
		Optional<InterestDeduction> optional = dao.findById(2);
		InterestDeduction oldEntry = new InterestDeduction();
		try {
			oldEntry = optional.get();
		} catch (NoSuchElementException ex) {
			System.out.println("Entry missing.");
		}
		
		oldEntry.setDeductionAmount(2.0);

		InterestDeduction newEntry = dao.save(oldEntry);

		assertNotNull(newEntry);
		assertEquals(newEntry.getDeductionAmount(), 2.0);
		
		oldEntry.setDeductionAmount(1.0);
		dao.save(oldEntry);
	}

}
