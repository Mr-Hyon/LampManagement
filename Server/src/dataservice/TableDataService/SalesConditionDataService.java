package Server.src.dataservice.TableDataService;

import Server.src.po.TablePO.SalesConditionTablePO;
import Server.src.po.SalesRecordInfo;
import Server.src.po.ClientPO.ClientPO;
import Server.src.po.UserPO.UserPO;
import Server.src.feedback;

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
