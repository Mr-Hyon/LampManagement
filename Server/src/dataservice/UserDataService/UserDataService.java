package dataservice.UserDataService;

import common.feedback;
import po.UserPO.UserPO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserDataService extends Remote{
	
	public UserPO findUser(String username)throws RemoteException;
	
	public feedback modifyPassword(UserPO user)throws RemoteException;
	
}
