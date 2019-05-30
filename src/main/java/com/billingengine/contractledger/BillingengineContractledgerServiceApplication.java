package com.billingengine.contractledger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class BillingengineContractledgerServiceApplication {

	
	public static void main(String[] args) {
		//ApplicationContext context = SpringApplication.run(BillingengineContractledgerServiceApplication.class, args);
		SpringApplication.run(BillingengineContractledgerServiceApplication.class, args);
		//TestClient exampleClient = context.getBean(TestClient.class);
	    //exampleClient.run();
	}
	
	@Bean
	public Jackson2RepositoryPopulatorFactoryBean getRespositoryPopulator() {
	    Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
	    factory.setResources(new Resource[]{new ClassPathResource("data.json")});
	    return factory;
	}
	


}
