package blservice.paymentblservice;

import vo.PaymentVO;
import vo.ReceiptVO;

import java.rmi.RemoteException;
import util.ResultMessage;

public interface PaymentBLService {
	public ResultMessage addReceipt(ReceiptVO vo) throws RemoteException;
	public ResultMessage addPayBill(PaymentVO vo) throws RemoteException;
	public ResultMessage sendToVerifyR(ReceiptVO vo) throws RemoteException;
	public ResultMessage sendToVerifyP(PaymentVO vo) throws RemoteException;
	public ResultMessage updateR(ReceiptVO vo) throws RemoteException;
	public ResultMessage updateP(PaymentVO vo) throws RemoteException;
}
