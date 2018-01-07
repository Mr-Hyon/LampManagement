package dataservice.PurchaseDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

import po.ClientPO.ClientPO;
import po.PurchasePO.PurchaseBillPO;
import po.SalesPO.SalesBillPO;
import po.UserPO.UserPO;
import common.feedback;

public interface PurchaseBillDataService extends Remote {

	public PurchaseBillPO findPurchaseBillByBillID(String billID) throws RemoteException;
	
	public List<PurchaseBillPO> findPurchaseBillByType(String type)throws RemoteException;
	
	public List<PurchaseBillPO> findPurchaseBillByClient(String po)throws RemoteException;
	
	public List<PurchaseBillPO> findPurchaseBillByInventory(String inventory)throws RemoteException;

	public List<PurchaseBillPO> getPurchaseBillPO(String startDate, String endDate, String client, String salesman,String inventory) throws ParseException,RemoteException;
	
	public List<PurchaseBillPO> getDraftPurchaseBill()throws RemoteException;
	
	public feedback addPurchaseBill(PurchaseBillPO po)throws RemoteException;

	public feedback checkPurchaseBill(PurchaseBillPO po)throws RemoteException;

	public feedback reversePurchaseBill(String billID)throws RemoteException;//红冲

	public feedback modifyPurchaseBill(PurchaseBillPO po)throws RemoteException;


}

