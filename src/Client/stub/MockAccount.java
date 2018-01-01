package account;

public class MockAccount extends Account {
	String name;
	double amount;
	
	public MockAccount(String name,double amount){
		this.name=name;
		this.amount=amount;
	}
	
	public String getName(){
		return name;
	}
	
	public double amount(){
		return amount;
	}

}
