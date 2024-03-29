package bl.purchasebl;

import java.rmi.RemoteException;

import blservice.purchaseblservice.PurchaseBLService;
import vo.PurchaseVO;
import util.ResultMessage;

public class PurchaseController implements PurchaseBLService{

	Purchase purchase = new Purchase();
	@Override
	public ResultMessage addPurchase(PurchaseVO vo) throws RemoteException {
		return purchase.addPurchase(vo);
	}

	@Override
	public ResultMessage addRefunds(PurchaseVO vo) throws RemoteException {
		return purchase.addRefunds(vo);
	}

	@Override
	public ResultMessage checkPurchase(PurchaseVO vo) throws RemoteException {
		return purchase.checkPurchase(vo);
	}

	@Override
	public ResultMessage reversePurchase(PurchaseVO vo) throws RemoteException {
		return purchase.reversePurchase(vo);
	}

}
