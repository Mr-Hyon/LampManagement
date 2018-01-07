package bl.clientbl;

import java.rmi.RemoteException;

import blservice.clientblservice.ClientBLService;
import util.ResultMessage;
import vo.ClientVO;

public class ClientController implements ClientBLService{

	Client client = new Client();
	@Override
	public ResultMessage add(ClientVO vo) throws RemoteException {
		return client.add(vo);
	}

	@Override
	public ResultMessage findbyID(String ID) throws RemoteException {
		return client.findbyID(ID);
	}

	@Override
	public ResultMessage findbyString(String str) throws RemoteException {
		return client.findbyString(str);
	}

	@Override
	public ResultMessage sendToVerify(ClientVO vo) throws RemoteException {
		return client.sendToVerify(vo);
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		return client.delete(ID);
	}

}
