package com.billingengine.contractledger;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.billingengine.contractledger.contractrepo.ContractRepository;
import com.billingengine.contractledger.testmrepo.TestMParent;
import com.billingengine.contractledger.testmrepo.TestMRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillingengineContractledgerServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

	 @Autowired
    private TestMRepository fruitRepository;

	 @Autowired
	 private ContractRepository contractRepository;
	 
	    @Test
	    public void givenFruitJsonPopulatorThenShouldInsertRecordOnStart() {

	        List<TestMParent> fruits = fruitRepository.findAll();
	        assertEquals("record count is not matching", 2, fruits.get(0).getContracts().size());
	        
	        //com.billingengine.contractledger.contractrepo.Test s = new com.billingengine.contractledger.contractrepo.Test();
	        //s.setName("test success");
	        //contractRepository.save(s);
	        
	        List<com.billingengine.contractledger.contractrepo.Test> testrecords = contractRepository.findAll();
	        assertEquals("record count is not matching", 1, testrecords.size());
	        
	    }
	    
	    
}
