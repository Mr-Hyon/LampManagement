package dataservice.AccountDataService;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.AccountPO.AccountPO;
import common.feedback;

public interface AccountDataService extends Remote {
	public feedback addAccount(AccountPO po)throws RemoteException;
	public feedback deleteAccount(String name)throws RemoteException;
	public feedback updateAccount(AccountPO po)throws RemoteException;
	public AccountPO findAccountByKeyWord(String word)throws RemoteException;
	public List<AccountPO> findAccountByBank(String bank)throws RemoteException;
	public List<AccountPO> showAccount()throws RemoteException;
	public AccountPO findAccountByName(String name) throws RemoteException;
}

