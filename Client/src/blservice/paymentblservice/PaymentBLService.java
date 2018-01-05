package blservice.paymentblservice;

import vo.PaymentVO;
import java.rmi.RemoteException;
import util.ResultMessage;

public interface PaymentBLService {
	public ResultMessage addReceipt(PaymentVO vo);
	public ResultMessage addPayBill(PaymentVO vo);
	public ResultMessage sendToVerify(PaymentVO vo)throws RemoteException;
	public ResultMessage update(PaymentVO vo)throws RemoteException;
}
