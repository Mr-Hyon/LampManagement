package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.AccountDataService.AccountDataService;




public class RemoteHelper {
	private static RemoteHelper remoteHelper=new RemoteHelper();
	private Remote remote;
	
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	
	private RemoteHelper(){
		;
	}
	
	public void setRemote(Remote remote){
		this.remote=remote;
	}
	
	public AccountDataService getAccountDataService(){
		return (AccountDataService)remote;
	}
	
}