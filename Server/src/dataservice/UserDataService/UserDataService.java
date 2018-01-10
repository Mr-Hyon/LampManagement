package dataservice.UserDataService;

import common.feedback;
import po.UserPO.UserPO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserDataService extends Remote{
	
	public feedback addUser(UserPO user)throws RemoteException;
	
	public UserPO findUser(String username)throws RemoteException;
	
	public feedback modifyPassword(UserPO user)throws RemoteException;
	
}

