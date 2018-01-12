package bl.tablebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.ReceiptVO;
import vo.SaleTableVO;
import vo.SituationTableVO;
import util.ResultMessage;
import vo.TableVO;

public class Table {
	
	public SaleTableVO viewSaleTable(String time, String goodsName, String client, String salesman, String warehouse){
		return null;
	}
	public ArrayList<ReceiptVO> viewManagementProcess(String time, String receiptType, String client, String salesman, String warehouse){
		return null;
	}
	public SituationTableVO viewManagementSituation(String time) throws RemoteException{
		return null;
	}
	
}
