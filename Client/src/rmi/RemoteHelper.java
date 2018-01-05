package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import blservice.accountblservice.AccountBLService;


public class RemoteHelper {
	
	private static RemoteHelper remoteHelper=new RemoteHelper();
	private Remote remote;
	
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	
	private RemoteHelper(){
		try{
			remote=Naming.lookup("rmi://127.0.0.1:8887/DataRemoteObject");			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void setRemote(Remote remote){
		this.remote=remote;
	}
	
	public AccountDataService getAccountDataService(){
		return (AccountDataService)remote;
	}
	
}