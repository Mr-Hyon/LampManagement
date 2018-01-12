package blservice.clientblservice;

import vo.ClientVO;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMessage;

public interface ClientBLService {
	public ResultMessage add(ClientVO vo) throws RemoteException;
	public ArrayList<ClientVO> findbyID(String ID) throws RemoteException;
	public ArrayList<ClientVO> findbyName(String name) throws RemoteException;
	public ArrayList<ClientVO> findbyString(String str) throws RemoteException;
	public ResultMessage update(ClientVO vo) throws RemoteException;
	public ResultMessage delete(ClientVO vo) throws RemoteException;
	public ArrayList<ClientVO> show() throws RemoteException;
}
