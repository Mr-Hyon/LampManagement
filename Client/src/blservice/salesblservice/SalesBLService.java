package blservice.salesblservice;

import java.rmi.RemoteException;
import util.ResultMessage;
import vo.SalesVO;

public interface SalesBLService {
	public ResultMessage addSales(SalesVO vo);
	public ResultMessage addRefunds(SalesVO vo);
	public ResultMessage sendToVerify(SalesVO vo)throws RemoteException;
}
