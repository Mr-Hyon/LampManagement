package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import blservice.accountblservice.AccountBLService;


public class RemoteHelper {
	
	private static String url = "rmi://127.0.0.1:8887/";

	private static AccountBLService accountBLService;

	public static void initRmi() {

		try {
			accountBLService = (AccountBLService)Naming.lookup(url+"AccountBL");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static AccountBLService getAccountBLService() {
		return accountBLService;
	}
	
}