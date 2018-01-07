package bl.tablebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.SaleTableVO;
import vo.SituationTableVO;
import blservice.tableblservice.TableBLService;
import util.ResultMessage;
import vo.TableVO;

public class TableController implements TableBLService{

	Table table = new Table();
	@Override
	public SaleTableVO viewSaleTable(String time, String goodsName, String client, String salesman, String warehouse)
			throws RemoteException {
		return table.viewSaleTable(time, goodsName, client, salesman, warehouse);
	}

	@Override
	public ResultMessage deriveSaleTable(SaleTableVO vo) {
		return table.deriveSaleTable(vo);
	}

	@Override
	public ArrayList<TableVO> viewManagementProcess(String time, String receiptType, String client, String salesman,
			String warehouse) throws RemoteException {
		return table.viewManagementProcess(time, receiptType, client, salesman, warehouse);
	}

	@Override
	public ResultMessage reverse(TableVO vo) throws RemoteException {
		return table.reverse(vo);
	}

	@Override
	public ResultMessage reverseAndCopy(TableVO vo) throws RemoteException {
		return table.reverseAndCopy(vo);
	}

	@Override
	public ResultMessage deriveManagementProcess(ArrayList<TableVO> List) {
		return table.deriveManagementProcess(List);
	}

	@Override
	public SituationTableVO viewManagementSituation(String time) throws RemoteException {
		return table.viewManagementSituation(time);
	}

	@Override
	public ResultMessage deriveManagementSituation(SituationTableVO vo) {
		return table.deriveManagementSituation(vo);
	}

}
