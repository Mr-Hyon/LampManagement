package dataservice.SalesDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

import po.ClientPO.ClientPO;
import po.SalesPO.SalesBillPO;
import po.UserPO.UserPO;
import common.feedback;

public interface SalesBillDataService extends Remote {
	
	public List<SalesBillPO> findSaleBillByType(String type)throws RemoteException;
	
	public List<SalesBillPO> findSaleBillByClient(String po)throws RemoteException;
	
	public List<SalesBillPO> findSaleBillByInventory(String inventory)throws RemoteException;

	public SalesBillPO findSaleBillByID(String id) throws RemoteException;

	public List<SalesBillPO> getSaleBillPO(String startDate, String endDate, String client, String salesman, String inventory) throws ParseException,RemoteException;

	public List<SalesBillPO> getDraftSaleBill()throws RemoteException;

	public List<SalesBillPO> getPassedSaleBill()throws RemoteException;
	
	public feedback addSaleBill(SalesBillPO po)throws RemoteException;

	public feedback checkSaleBill(SalesBillPO po)throws RemoteException;

	public feedback reverseSalesBill(String billID)throws RemoteException;//红冲

	public feedback modifySaleBill(SalesBillPO po)throws RemoteException;
}

