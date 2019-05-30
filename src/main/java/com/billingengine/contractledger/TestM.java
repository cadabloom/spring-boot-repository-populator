package com.billingengine.contractledger;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class TestM {

    @Id
    private long id;
    private String name;
    private String color;
    
    @OneToMany(cascade = CascadeType.ALL, targetEntity = TestMChild.class, fetch = FetchType.EAGER)
    @JoinColumn(name="contractId") 
    private List<TestMChild> children;
    
    //@JoinColumn(name="accountId", referencedColumnName = "id") 
    //@NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name="accountId") 
    private TestMParent account;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }

	public List<TestMChild> getChildren() {
		return children;
	}

	public void setChildren(List<TestMChild> children) {
		this.children = children;
	}

	public TestMParent getAccount() {
		return account;
	}

	public void setAccount(TestMParent account) {
		this.account = account;
	}

}