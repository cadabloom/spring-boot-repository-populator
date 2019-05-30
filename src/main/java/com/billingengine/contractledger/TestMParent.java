package com.billingengine.contractledger;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class TestMParent {
	@Id
	private int id;
	private String accountName;
	
	@OneToMany(targetEntity = TestM.class, cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
	@JoinColumn(name="accountId") 
	private List<TestM> contracts;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public List<TestM> getContracts() {
		return contracts;
	}
	public void setContracts(List<TestM> contracts) {
		this.contracts = contracts;
	}
	
	
}
