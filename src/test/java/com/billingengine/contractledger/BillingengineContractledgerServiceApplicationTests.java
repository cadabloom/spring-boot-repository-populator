package com.billingengine.contractledger;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillingengineContractledgerServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

	 @Autowired
    private TestMRepository fruitRepository;

	    @Test
	    public void givenFruitJsonPopulatorThenShouldInsertRecordOnStart() {

	        List<TestMParent> fruits = fruitRepository.findAll();
	        assertEquals("record count is not matching", 2, fruits.get(0).getContracts().size());

//	        fruits.forEach(fruit -> {
//	            if (1 == fruit.getId()) {
//	                assertEquals("apple", fruit.getName());
//	                assertEquals("red", fruit.getColor());
//	            } else if (2 == fruit.getId()) {
//	                assertEquals("guava", fruit.getName());
//	                assertEquals("green", fruit.getColor());
//	            }
//	        });
	    }
}
