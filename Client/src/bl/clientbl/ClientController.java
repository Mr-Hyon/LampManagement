package bl.clientbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
	public ArrayList<ClientVO> findbyID(String ID) throws RemoteException {
		return client.findbyID(ID);
	}
	
	@Override
	public ArrayList<ClientVO> findbyName(String name) throws RemoteException {
		return client.findbyName(name);
	}

	@Override
	public ArrayList<ClientVO> findbyString(String str) throws RemoteException {
		return client.findbyString(str);
	}

	@Override
	public ResultMessage update(ClientVO vo) throws RemoteException {
		return client.update(vo);
	}

	@Override
	public ResultMessage delete(ClientVO vo) throws RemoteException {
		return client.delete(vo);
	}

	@Override
	public ArrayList<ClientVO> show() throws RemoteException {
		return client.show();
	}

}
