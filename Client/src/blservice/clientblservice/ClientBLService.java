package blservice.clientblservice;

import vo.ClientVO;
import java.rmi.RemoteException;
import util.ResultMessage;

public interface ClientBLService {
	public ResultMessage add(ClientVO vo) throws RemoteException;
	public ResultMessage findbyID(String ID) throws RemoteException;
	public ResultMessage findbyString(String str) throws RemoteException;
	public ResultMessage sendToVerify(ClientVO vo) throws RemoteException;
	public ResultMessage delete(String ID) throws RemoteException;
}
