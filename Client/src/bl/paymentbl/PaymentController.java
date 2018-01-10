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
	public ResultMessage checkReceipt(ReceiptVO vo) throws RemoteException {
		return payment.checkReceipt(vo);
	}

	@Override
	public ResultMessage checkPayBill(PaymentVO vo) throws RemoteException {
		return payment.checkPayBill(vo);
	}

	@Override
	public ResultMessage reverseReceipt(ReceiptVO vo) throws RemoteException {
		return payment.reverseReceipt(vo);
	}

	@Override
	public ResultMessage reversePayBill(PaymentVO vo) throws RemoteException {
		return payment.reversePayBill(vo);
	}

}
