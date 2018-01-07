package bl.tablebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.SaleTableVO;
import vo.SituationTableVO;
import util.ResultMessage;
import vo.TableVO;

public class Table {
	public SaleTableVO viewSaleTable(String time, String goodsName, String client, String salesman, String warehouse) throws RemoteException{
		
	}
	public ResultMessage deriveSaleTable(SaleTableVO vo){
		
	}
	public ArrayList<TableVO> viewManagementProcess(String time, String receiptType, String client, String salesman, String warehouse)throws RemoteException{
		
	}
	public ResultMessage reverse(TableVO vo) throws RemoteException{
		
	}
	public ResultMessage reverseAndCopy(TableVO vo) throws RemoteException{
		
	}
	public ResultMessage deriveManagementProcess(ArrayList<TableVO> List){
		
	}
	public SituationTableVO viewManagementSituation(String time) throws RemoteException{
		
	}
	public ResultMessage deriveManagementSituation(SituationTableVO vo){
		
	}
}
