package bl.purchasebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import common.feedback;
import po.GoodInfo;
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
		if(RemoteHelper.getInstance().getPurchaseBillDataService().reversePurchaseBill(vo.getPurchaseId())==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	
	
	//transform purchaseVO into purchasebillPO
	public PurchaseBillPO toPurchaseBillPO(PurchaseVO vo){
		List<GoodInfo> list = new ArrayList<GoodInfo>();
		GoodInfo goodinfo = new GoodInfo(vo.getNameofGoods(),vo.getModel(),vo.getNumber(),Double.parseDouble(vo.getPrice()),vo.getSum2(),vo.getNote2());
		list.add(goodinfo);
		PurchaseBillPO purchasebillPO = new PurchaseBillPO(null,vo.getIdofGoods(),vo.getSupplier(),vo.getStorage(),null,vo.getOperator(),list,vo.getNote1(),vo.getSum1());
		return purchasebillPO;
	}
	//transform purchasebillPO into purchaseVO
	public PurchaseVO toPurchaseVO(PurchaseBillPO po) throws RemoteException{
		PurchaseVO purchaseVO = new PurchaseVO(po.getBillID(),po.getSupplier(),po.getOperator(),po.getInventory(),po.getTotalAmount(),po.getRemark(),po.getGoodsList().get(0).getId()+"",po.getGoodsList().get(0).getName(),po.getGoodsList().get(0).getType(),(int)po.getGoodsList().get(0).getAmount(),po.getGoodsList().get(0).getPrice()+"",po.getGoodsList().get(0).getTotalPrice(),po.getGoodsList().get(0).getRemark());
		return purchaseVO;
	}
}
