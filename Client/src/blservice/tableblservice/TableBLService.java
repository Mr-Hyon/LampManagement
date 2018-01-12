package blservice.tableblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import vo.TableVO;
import util.ResultMessage;
import vo.ReceiptVO;
import vo.SaleTableVO;
import vo.SituationTableVO;

public interface TableBLService {
	
	public SaleTableVO viewSaleTable(String time, String goodsName, String client, String salesman, String warehouse);
	public ArrayList<ReceiptVO> viewManagementProcess(String time, String receiptType, String client, String salesman, String warehouse);
	public SituationTableVO viewManagementSituation(String time) throws RemoteException;

}
