package blservice.salesblservice;

import java.rmi.RemoteException;
import util.ResultMessage;
import vo.SalesVO;

public interface SalesBLService {
	public ResultMessage addSales(SalesVO vo) throws RemoteException;
	public ResultMessage addRefunds(SalesVO vo) throws RemoteException;
	public ResultMessage sendToVerify(SalesVO vo) throws RemoteException;
}
