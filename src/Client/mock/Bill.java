package bill;
import account.Account;

public class Bill {
	Commodity commodity;
	Client client;
	Account account;
	String ID;
	Bill initial;
	
	public Client getClient(){
		return client;
	}
	
	public Commodity getCommodity(){
		return commodity;
	}
	
	public String getID(){
		return ID;
	}
	
	public Bill showInitial(){
		return initial;
	}

}
