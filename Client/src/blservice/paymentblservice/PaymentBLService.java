package blservice.paymentblservice;

import vo.PaymentVO;
import vo.ReceiptVO;

import java.rmi.RemoteException;
import util.ResultMessage;

public interface PaymentBLService {
	public ResultMessage addReceipt(ReceiptVO vo) throws RemoteException;
	public ResultMessage addPayBill(PaymentVO vo) throws RemoteException;
	public ResultMessage checkReceipt(ReceiptVO vo) throws RemoteException;
	public ResultMessage checkPayBill(PaymentVO vo) throws RemoteException;
	public ResultMessage reverseReceipt(ReceiptVO vo)throws RemoteException;
	public ResultMessage reversePayBill(PaymentVO vo)throws RemoteException;
}
