package blservice.purchaseblservice;

import vo.PurchaseVO;
import java.rmi.RemoteException;
import util.ResultMessage;

public interface PurchaseBLService {
	public ResultMessage addPurchase(PurchaseVO vo) throws RemoteException;
	public ResultMessage addRefunds(PurchaseVO vo) throws RemoteException;
	public ResultMessage sendToVerify(PurchaseVO vo) throws RemoteException;
}
