package dataservice.ClientDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.ClientPO.ClientPO;
import common.feedback;

public interface ClientDataService extends Remote {

	public feedback addClient(ClientPO po) throws RemoteException;
	
	public feedback deleteClient(String name) throws RemoteException;
	
	public feedback updateClient(ClientPO po) throws RemoteException;
	
	public ClientPO findClientById(int id) throws RemoteException;
	
	public ClientPO findClientByName(String name) throws RemoteException;
	
	public ClientPO findClientByKeyWord(String word) throws RemoteException;
	
	public List<ClientPO> findClientByType(String type) throws RemoteException;
	
	public List<ClientPO> showClient() throws RemoteException;
	
}

