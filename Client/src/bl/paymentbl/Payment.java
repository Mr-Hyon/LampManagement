package bl.paymentbl;

import java.rmi.RemoteException;

import common.feedback;
import po.PaymentPO.CollectionPO;
import po.PaymentPO.FundInfo;
import po.PaymentPO.PaymentPO;
import rmi.RemoteHelper;
import util.ResultMessage;
import vo.PaymentVO;
import vo.ReceiptVO;

public class Payment {
	public ResultMessage addReceipt(ReceiptVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getCollectionDataService().addCash(toCollectionPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	public ResultMessage addPayBill(PaymentVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getPaymentDataService().addPaymentBill(toPaymentPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	
	public static CollectionPO toCollectionPO(ReceiptVO vo){
		return null;
	}
	
	public static PaymentPO toPaymentPO(PaymentVO vo){
		return null;
	}
}
