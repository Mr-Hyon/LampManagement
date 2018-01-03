package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RemoteHelper {
	public static String url = "rmi://127.0.0.1:8887/";
	
	public static void initServer() {
		try {
			LocateRegistry.createRegistry(8887);
			
			AccountBLService accountBS = new AccountBLController();
			Naming.rebind(url+"AccountBL", accountBS);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
