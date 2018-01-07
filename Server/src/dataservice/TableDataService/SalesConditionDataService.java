package dataservice.TableDataService;

import po.TablePO.SalesConditionTablePO;
import po.SalesRecordInfo;
import po.ClientPO.ClientPO;
import po.UserPO.UserPO;
import common.feedback;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

public interface SalesConditionDataService extends Remote {

	public feedback addSalesCondition(SalesConditionTablePO po)throws RemoteException;

	public List<SalesRecordInfo> getSalesBill(String startDate, String endDate, String commodityName, String client,
											  String salesman, String inventory) throws ParseException,RemoteException;

	public SalesConditionTablePO searchSalesConditionBillByID(int id)throws RemoteException;

	public List<SalesConditionTablePO> showSalesConditionBill()throws RemoteException;
 }
