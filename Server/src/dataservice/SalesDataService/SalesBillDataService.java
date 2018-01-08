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
	
	public List<SalesBillPO> findSalesBillByType(String type)throws RemoteException;
	
	public List<SalesBillPO> findSalesBillByClient(String po)throws RemoteException;
	
	public List<SalesBillPO> findSalesBillByCommodity(String commodity)throws RemoteException;

	public SalesBillPO findSalesBillByID(String id) throws RemoteException;

	public List<SalesBillPO> getSalesBillPO(String startDate, String endDate, String client, String salesman, String inventory) throws ParseException,RemoteException;

	public List<SalesBillPO> getDraftSalesBill()throws RemoteException;

	public List<SalesBillPO> getPassedSalesBill()throws RemoteException;
	
	public feedback addSalesBill(SalesBillPO po)throws RemoteException;

	public feedback checkSalesBill(SalesBillPO po)throws RemoteException;

	public feedback reverseSalesBill(String billID)throws RemoteException;//红冲

	public feedback modifySalesBill(SalesBillPO po)throws RemoteException;
}

