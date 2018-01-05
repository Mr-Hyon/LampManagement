package blservice.verifyblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import vo.TableVO;
import util.ResultMessage;

public interface VerifyBLService {
	public ArrayList<TableVO> viewReceipts() throws RemoteException;
	public ResultMessage pass(TableVO vo) throws RemoteException;
	public ResultMessage passAll(ArrayList<TableVO> List) throws RemoteException;
	public ResultMessage update(TableVO vo) throws RemoteException;
	public ResultMessage updateCommodity(TableVO vo) throws RemoteException;
	public ResultMessage informCommodity(TableVO vo) throws RemoteException;
	public ResultMessage updateCommodityAndClient(TableVO vo) throws RemoteException;
	public ResultMessage updateClient(TableVO vo) throws RemoteException;
	public ResultMessage informFinance(TableVO vo) throws RemoteException;
}
