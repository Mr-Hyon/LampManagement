package blservice.clientblservice;

import vo.ClientVO;
import java.rmi.RemoteException;
import util.ResultMessage;

public interface ClientBLService {
	public ResultMessage add(ClientVO vo);
	public ResultMessage findbyID(String ID);
	public ResultMessage findbyString(String str);
	public ResultMessage sendToVerify(ClientVO vo)throws RemoteException;
	public ResultMessage delete(String ID);
}
