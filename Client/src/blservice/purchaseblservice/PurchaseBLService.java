package blservice.purchaseblservice;

import vo.PurchaseVO;
import java.rmi.RemoteException;
import util.ResultMessage;

public interface PurchaseBLService {
	public ResultMessage addPurchase(PurchaseVO vo);
	public ResultMessage addRefunds(PurchaseVO vo);
	public ResultMessage sendToVerify(PurchaseVO vo)throws RemoteException;
}
