package bl.purchasebl;

import java.rmi.RemoteException;

import common.feedback;
import po.PurchasePO.PurchaseBillPO;
import rmi.RemoteHelper;
import vo.PurchaseVO;
import util.ResultMessage;

public class Purchase {
	//add purchase bill
	public ResultMessage addPurchase(PurchaseVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getPurchaseBillDataService().addPurchaseBill(toPurchaseBillPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//add return bill of purchase
	public ResultMessage addRefunds(PurchaseVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getPurchaseBillDataService().addPurchaseBill(toPurchaseBillPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//approve purchase bill and return bill
	public ResultMessage checkPurchase(PurchaseVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getPurchaseBillDataService().checkPurchaseBill(toPurchaseBillPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//reverse purchase bill and return bill
	public ResultMessage reversePurchase(PurchaseVO vo)throws RemoteException{
		if(RemoteHelper.getInstance().getPurchaseBillDataService().reversePurchaseBill(vo.getId())==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	
	
	//transform purchaseVO into purchasebillPO
	public PurchaseBillPO toPurchaseBillPO(PurchaseVO vo){
		PurchaseBillPO purchasebillPO = new PurchaseBillPO();
		return purchasebillPO;
	}
	//transform purchasebillPO into purchaseVO
	public PurchaseVO toPurchaseVO(PurchaseBillPO po){
		PurchaseVO purchaseVO = new PurchaseVO();
		return purchaseVO;
	}
}
