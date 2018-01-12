package bl.tablebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.ReceiptVO;
import vo.SaleTableVO;
import vo.SituationTableVO;
import blservice.tableblservice.TableBLService;

public class TableController implements TableBLService{

	Table table = new Table();
	@Override
	public SaleTableVO viewSaleTable(String time, String goodsName, String client, String salesman, String warehouse) {
		return table.viewSaleTable(time, goodsName, client, salesman, warehouse);
	}
	
	@Override
	public ArrayList<ReceiptVO> viewManagementProcess(String time, String receiptType, String client, String salesman, String warehouse) {
		return table.viewManagementProcess(time, receiptType, client, salesman, warehouse);
	}
	
	@Override
	public SituationTableVO viewManagementSituation(String time) throws RemoteException {
		return table.viewManagementSituation(time);
	}

}
