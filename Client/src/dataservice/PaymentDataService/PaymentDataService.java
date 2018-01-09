package dataservice.PaymentDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

import po.PaymentPO.PaymentPO;
import po.ClientPO.ClientPO;
import po.UserPO.UserPO;
import common.feedback;

public interface PaymentDataService extends Remote {

	public List<PaymentPO> findPaymentBillByType(String type)throws RemoteException;
	
	public List<PaymentPO> findPaymentBillByClient(String po)throws RemoteException;

	public PaymentPO findPaymentBillByBillID(String billID) throws RemoteException;

	public List<PaymentPO> getPaymentPO(String startDate, String endDate, String client) throws ParseException,RemoteException;

	public List<PaymentPO> getDraftPaymentBill()throws RemoteException;

	public feedback addPaymentBill(PaymentPO po)throws RemoteException;
	
	public feedback checkPaymentBill(PaymentPO po)throws RemoteException;

	public feedback reversePaymentBill(String billID)throws RemoteException;//红冲

	public feedback modifyPaymentBill(PaymentPO po)throws RemoteException;

}

