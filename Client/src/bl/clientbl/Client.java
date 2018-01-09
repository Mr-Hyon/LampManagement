package bl.clientbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import common.feedback;
import po.ClientPO.ClientPO;
import rmi.RemoteHelper;
import util.ResultMessage;
import vo.ClientVO;

public class Client {
	//add client
	public ResultMessage add(ClientVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getClientDataService().addClient(toClientPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//find client by ID
	public ArrayList<ClientVO> findbyID(String ID) throws RemoteException{
		List<ClientPO> list1 = (java.util.List<ClientPO>) RemoteHelper.getInstance().getClientDataService().findClientById(Integer.parseInt(ID));
		ArrayList<ClientVO> list2 = new ArrayList<ClientVO>();
		for(int i = 0;i<list1.size();i++){
			list2.add(toClientVO(list1.get(i)));
		}
		return list2;
	}
	//find client by keyword
	public ArrayList<ClientVO> findbyString(String str) throws RemoteException{
		List<ClientPO> list1 = (java.util.List<ClientPO>) RemoteHelper.getInstance().getClientDataService().findClientByKeyWord(str);
		ArrayList<ClientVO> list2 = new ArrayList<ClientVO>();
		for(int i = 0;i<list1.size();i++){
			list2.add(toClientVO(list1.get(i)));
		}
		return list2;
	}
	//update client
	public ResultMessage update(ClientVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getClientDataService().updateClient(toClientPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//delete client
	public ResultMessage delete(ClientVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getClientDataService().deleteClient(vo.getClientName())==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//show client
	public ArrayList<ClientVO> show() throws RemoteException{
		List<ClientPO> list1 = (java.util.List<ClientPO>) RemoteHelper.getInstance().getClientDataService().showClient();
		ArrayList<ClientVO> list2 = new ArrayList<ClientVO>();
		for(int i = 0;i<list1.size();i++){
			list2.add(toClientVO(list1.get(i)));
		}
		return list2;
	}
	//transfer ClientVO to ClientPO
	public static ClientPO toClientPO(ClientVO vo){
		ClientPO clientPO = new ClientPO(vo.getClientName(),vo.getClientLevel(),vo.getClientType(),vo.getClientContact(),vo.getClientAddress(),vo.getClientZip(),vo.getClientEmail(),0);
		return clientPO;
	}
	//transfer ClientPO to ClientVO
	public static ClientVO toClientVO(ClientPO po){
		ClientVO clientVO = new ClientVO(po.getId()+"",po.getType(),po.getLevel(),po.getName(),po.getTel(),po.getAddress(),po.getPostcode(),po.getEmail(),po.getPay()+"",po.getRecieve()+"");
		return clientVO;
	}
}
