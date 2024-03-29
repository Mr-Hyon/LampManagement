package blservice.accountblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import vo.AccountVO;
import util.ResultMessage;

public interface AccountBLService {
	public ResultMessage add(AccountVO vo) throws RemoteException;
	public ResultMessage delete(AccountVO vo) throws RemoteException;
	public ResultMessage update(AccountVO vo) throws RemoteException;
	public ResultMessage updateName(AccountVO vo, String name) throws RemoteException;
	public ArrayList<AccountVO> findByKeyword(String str) throws RemoteException;
	public AccountVO findByName(String name) throws RemoteException;
	public ArrayList<AccountVO> show() throws RemoteException;
}
