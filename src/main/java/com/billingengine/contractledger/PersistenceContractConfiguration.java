package com.billingengine.contractledger;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(
  basePackages = "com.billingengine.contractledger.contractrepo",
  entityManagerFactoryRef = "postgresEntityManager",
  transactionManagerRef = "postgresTransactionManager")
public class PersistenceContractConfiguration {
	
	@Autowired
    private Environment env;
	
//	@Bean(name = "ds")
//	@ConfigurationProperties("spring.contract-datasource")
//	public DataSourceProperties postgresDataSourceProperties() {
//		return new DataSourceProperties();
//	}
//	
//	@Bean
//	public DataSource postgresDataSource(@Qualifier("ds") DataSourceProperties properties) {
//		return properties.initializeDataSourceBuilder()
//				.type(HikariDataSource.class).build();
//	}
	
	@Bean
    public LocalContainerEntityManagerFactoryBean postgresEntityManager() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(postgresDataSource());
        em.setPackagesToScan("com.billingengine.contractledger.contractrepo");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.contract.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("spring.contract.hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
		//return builder.dataSource(ds).packages("com.billingengine.contractledger.contractrepo").build();
    }

	
    @Bean
    @ConfigurationProperties(prefix="spring.contract-datasource")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
        
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl(env.getProperty("archiveDb.jdbc.url"));
//        config.setUsername(env.getProperty("jdbc.archiveDb.username"));
//        config.setPassword(env.getProperty("jdbc.archiveDb.password"));
//
//        config.setMaximumPoolSize(Integer.valueOf(env.getProperty("jdbc.archiveDb.maxPoolSize")));
//        config.setAutoCommit(true);
//        config.addDataSourceProperty("cachePrepStmts", "true");
//        config.addDataSourceProperty("prepStmtCacheSize", "250");
//        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

    }
 
//    @Bean
//    public LocalContainerEntityManagerFactoryBean postgresEntityManager() {
//        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(postgresDataSource());
//        em.setPackagesToScan("com.billingengine.contractledger.contractrepo");
//
//        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        final HashMap<String, Object> properties = new HashMap<String, Object>();
//        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
//        em.setJpaPropertyMap(properties);
//
//        return em;
//    }


    @Bean
    public PlatformTransactionManager postgresTransactionManager() {
        //return new JpaTransactionManager(factory);
    	final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(postgresEntityManager().getObject());
        return transactionManager;
    }

}
