package bl.paymentbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import bl.accountbl.Account;
import bl.clientbl.Client;
import bl.userbl.User;
import common.BillType;
import common.feedback;
import po.PaymentPO.CollectionPO;
import po.PaymentPO.FundInfo;
import po.PaymentPO.PaymentPO;
import po.PaymentPO.TransferInfo;
import rmi.RemoteHelper;
import util.ResultMessage;
import vo.AccountVO;
import vo.ClientVO;
import vo.PaymentVO;
import vo.ReceiptVO;
import vo.UserVO;

public class Payment {
	//add receipt
	public ResultMessage addReceipt(ReceiptVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getCollectionDataService().addCash(toCollectionPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//add payment bill
	public ResultMessage addPayBill(PaymentVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getPaymentDataService().addPaymentBill(toPaymentPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//approve receipt
	public ResultMessage checkReceipt(ReceiptVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getCollectionDataService().checkCollection(toCollectionPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//approve payment bill
	public ResultMessage checkPayBill(PaymentVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getPaymentDataService().checkPaymentBill(toPaymentPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//reverse receipt
	public ResultMessage reverseReceipt(ReceiptVO vo)throws RemoteException{
		if(RemoteHelper.getInstance().getCollectionDataService().reverseCollectionBill(vo.getId())==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//reverse payment bill
	public ResultMessage reversePayBill(PaymentVO vo)throws RemoteException{
		if(RemoteHelper.getInstance().getPaymentDataService().reversePaymentBill(vo.getId())==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	
	
	//transform receiptVO into collectionPO
	public static CollectionPO toCollectionPO(ReceiptVO vo) throws RemoteException{
		List<FundInfo> list= new ArrayList<FundInfo>();
		FundInfo fundinfo = new FundInfo(vo.getAccountName(),Double.parseDouble(vo.getCash()),vo.getOther());
		list.add(fundinfo);
		Client client = new Client();
		ClientVO supplierVO = client.findbyName(vo.getSupplierName());
		ClientVO salesmanVO = client.findbyName(vo.getSalesmanName());
		User operator = new User();
		UserVO userVO = operator.findUser(vo.getOperatorName());
		Account account = new Account();
		AccountVO accountVO = account.findByName(vo.getAccountName());
		CollectionPO collectionPO = new CollectionPO(vo.getId(),Client.toClientPO(supplierVO),Client.toClientPO(salesmanVO),User.toUserPO(userVO),Account.toAccountPO(accountVO),Double.parseDouble(vo.getTotalCash()),list);
		return collectionPO;
	}
	//transform collectionPO into receiptVO
	public static ReceiptVO toReceiptVO(CollectionPO po){
		ReceiptVO receiptVO = new ReceiptVO(po.getBillID(),po.getSupplier().getName(),po.getSalesman().getName(),po.getOperator().getUsername(),po.getBank().getName(),po.getClausesList().get(0).getAmount()+"",po.getClausesList().get(0).getRemark(),po.getTotalAmount()+"");
		return receiptVO;
	}
	//transform paymentVO into paymentPO
	public static PaymentPO toPaymentPO(PaymentVO vo) throws RemoteException{
		List<TransferInfo> list = new ArrayList<TransferInfo>();
		TransferInfo transferinfo = new TransferInfo(vo.getAccountName(),Double.parseDouble(vo.getCash()),vo.getOther());
		list.add(transferinfo);
		User operator = new User();
		UserVO userVO = operator.findUser(vo.getOperatorName());
		Account account = new Account();
		AccountVO accountVO = account.findByName(vo.getAccountName());
		PaymentPO paymentPO = new PaymentPO(vo.getId(),User.toUserPO(userVO),Account.toAccountPO(accountVO),list,Double.parseDouble(vo.getTotalCash()));
		paymentPO.setType(BillType.PAY);
		return paymentPO;
	}
	//transform paymentPO into paymentVO
	public static PaymentVO toPaymentVO(PaymentPO po){
		PaymentVO paymentVO = new PaymentVO(po.getBillID(),po.getOperator().getUsername(),po.getBank().getName(),po.getTransferList().get(0).getAmount()+"",po.getTransferList().get(0).getRemark(),po.getTotalAmount()+"");
		return paymentVO;
	}
}
