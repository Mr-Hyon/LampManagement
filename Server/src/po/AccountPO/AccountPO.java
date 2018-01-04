package Server.src.po.AccountPO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="accountpo")

public class AccountPO implements Serializable{
    private static final long serialVersionUID=1L;
	public AccountPO() {

	}

	private int id;
	private String name;
	private double balance;
	private String bank;
	private String isValid;//是否被删除

	
	public AccountPO(String name,String bank,double balance){
		this.name=name;
		this.bank=bank;
		this.balance=balance;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName(){
    	return name;

    }

    public void setName(String name){
    	this.name=name;
    }

    @Column(name="bank")
    public String getBank(){
    	return bank;
    }
    
    public void setBank(String bank){
    	this.bank=bank;
    }

    @Column(name="balance")
    public double getBalance(){
    	return balance;
    }

    public void setBalance(double balance){
    	this.balance=balance;
    }

    @Column(name = "isValid")
    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }
}

