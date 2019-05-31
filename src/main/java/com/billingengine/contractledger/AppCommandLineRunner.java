package com.billingengine.contractledger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

	@Autowired
	private TestClient client;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 System.out.println("New Hello Command Line Runner called");
		client.run();
	}

}
