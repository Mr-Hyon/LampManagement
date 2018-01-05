package rmi;

import java.rmi.server.UnicastRemoteObject;

public class DataRemoteObject extends UnicastRemoteObject implements AccountDataService{
	
	private AccountDataService accountDataService;
	
	private DataRemoteObject{
		accountDataService=new AccountData();
	}
	
	
}
