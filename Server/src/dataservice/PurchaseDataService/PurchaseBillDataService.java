package Server.src.dataservice.PurchaseDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

import Server.src.po.ClientPO.ClientPO;
import Server.src.po.PurchasePO.PurchaseBillPO;
import Server.src.po.SalesPO.SalesBillPO;
import Server.src.po.UserPO.UserPO;
import Server.src.feedback;

public interface PurchaseBillDataService extends Remote {

	public PurchaseBillPO findPurchaseBillByBillID(String billID) throws RemoteException;
	
	public List<PurchaseBillPO> findPurchaseBillByType(String type)throws RemoteException;
	
	public List<PurchaseBillPO> findPurchaseBillByClient(String po)throws RemoteException;
	
	public List<PurchaseBillPO> findPurchaseBillByInventory(String inventory)throws RemoteException;

	public List<PurchaseBillPO> getPurchaseBillPO(String startDate, String endDate, String client, String salesman,String inventory) throws ParseException,RemoteException;
	
	public List<PurchaseBillPO> getDraftPurchaseBill()throws RemoteException;
	
	public feedback addPurchaseBill(PurchaseBillPO po)throws RemoteException;

	public feedback checkPurchaseBill(PurchaseBillPO po)throws RemoteException;

	public feedback redDashPurchaseBill(String billID)throws RemoteException;

	public feedback modifyPurchaseBill(PurchaseBillPO po)throws RemoteException;


}

