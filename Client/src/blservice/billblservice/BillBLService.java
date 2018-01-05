package blservice.billblservice;

import java.util.ArrayList;
import vo.BillVO;
import java.rmi.RemoteException;
import util.ResultMessage;

public interface BillBLService {
	public ResultMessage initial(BillVO vo);
	public ArrayList<BillVO> show() throws RemoteException;
	public ArrayList<BillVO> showInitial() throws RemoteException;
	public ResultMessage update(BillVO vo) throws RemoteException;
	public ResultMessage delete(BillVO vo);
}
