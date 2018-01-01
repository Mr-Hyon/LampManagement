package bill;
import account.Account;

public class MockBill extends Bill {
	Commodity commodity;
	Client client;
	Account account;
	String ID;
	Bill initial;
	
	public MockBill(Commodity commodity, Client client, Account account){
		this.commodity=commodity;
		this.client=client;
		this.account=account;
	}
	
	public Client getClient(){
		return client;
	}
	
	public Commodity getCommodity(){
		return commodity;
	}
	
	public String getID(){
		return ID;
	}
	
}
