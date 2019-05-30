package com.billingengine.contractledger;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TestMChild {
	@Id
    private long id;
    private String contractLineName;
    private int contractLineTerm;
    
    //private int contractId;

    @ManyToOne
    @JoinColumn(name = "contractId")
    private TestM contract;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public String getContractLineName() {
		return contractLineName;
	}

	public void setContractLineName(String contractLineName) {
		this.contractLineName = contractLineName;
	}

	public int getContractLineTerm() {
		return contractLineTerm;
	}

	public void setContractLineTerm(int contractLineTerm) {
		this.contractLineTerm = contractLineTerm;
	}

	public TestM getContract() {
		return contract;
	}

	public void setContract(TestM contract) {
		this.contract = contract;
	}

//	public int getContractId() {
//		return contractId;
//	}
//
//	public void setContractId(int contractId) {
//		this.contractId = contractId;
//	}
}
