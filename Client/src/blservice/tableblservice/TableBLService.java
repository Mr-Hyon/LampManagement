package blservice.tableblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import vo.TableVO;
import util.ResultMessage;
import vo.SaleTableVO;
import vo.SituationTableVO;

public interface TableBLService {
	public SaleTableVO viewSaleTable(String time, String goodsName, String client, String salesman, String warehouse) throws RemoteException;
	public ArrayList<TableVO> viewManagementProcess(String time, String receiptType, String client, String salesman, String warehouse)throws RemoteException;
	public ResultMessage reverse(TableVO vo) throws RemoteException;
	public ResultMessage reverseAndCopy(TableVO vo) throws RemoteException;
	public SituationTableVO viewManagementSituation(String time) throws RemoteException;

}
