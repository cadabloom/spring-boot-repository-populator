package com.billingengine.contractledger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestClient {
	@Autowired
	  private TestMRepository repo;

	  public void run() {
	      System.out.println(" -- finding all employees --");
	      Iterable<TestMParent> all = repo.findAll();
	      all.forEach(item -> {
	    	  System.out.println("Account: " + item.getAccountName() + ";" +
	    			  			 "Contract: " + item.getContracts().get(0).getName()
	    			  			 );
	      });
	  }
}
