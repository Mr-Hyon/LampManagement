package po.AccountPO;

import java.io.Serializable;

public class AccountPO implements Serializable{
    private static final long serialVersionUID=1L;
	public AccountPO() {

	}

	private int id;
	private String name;
	private double balance;
	private String bank;
	private String isValid;

	public AccountPO(String name,double balance){
		this.name = name;
		this.balance = balance;
	}
	public AccountPO(String name,String bank,double balance){
		this.name=name;
		this.bank=bank;
		this.balance=balance;
	}
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
    	return name;

    }

    public void setName(String name){
    	this.name=name;
    }

    public String getBank(){
    	return bank;
    }
    
    public void setBank(String bank){
    	this.bank=bank;
    }

    public double getBalance(){
    	return balance;
    }

    public void setBalance(double balance){
    	this.balance=balance;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }
}

