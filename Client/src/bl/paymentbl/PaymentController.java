package bl.paymentbl;

import java.rmi.RemoteException;

import blservice.paymentblservice.PaymentBLService;
import util.ResultMessage;
import vo.PaymentVO;
import vo.ReceiptVO;

public class PaymentController implements PaymentBLService{

	Payment payment = new Payment();
	@Override
	public ResultMessage addReceipt(ReceiptVO vo) throws RemoteException {
		return payment.addReceipt(vo);
	}

	@Override
	public ResultMessage addPayBill(PaymentVO vo) throws RemoteException {
		return payment.addPayBill(vo);
	}

	@Override
	public ResultMessage sendToVerifyR(ReceiptVO vo) throws RemoteException {
		return payment.sendToVerifyR(vo);
	}

	@Override
	public ResultMessage sendToVerifyP(PaymentVO vo) throws RemoteException {
		return payment.sendToVerifyP(vo);
	}

	@Override
	public ResultMessage updateR(ReceiptVO vo) throws RemoteException {
		return payment.updateR(vo);
	}

	@Override
	public ResultMessage updateP(PaymentVO vo) throws RemoteException {
		return payment.updateP(vo);
	}

}
