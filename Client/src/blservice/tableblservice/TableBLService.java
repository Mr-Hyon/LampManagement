package blservice.tableblservice;

import java.util.ArrayList;
import vo.ReceiptVO;
import util.ResultMessage;
import vo.SaleTableVO;
import vo.SituationTableVO;

public interface TableBLService {
	public SaleTableVO viewSaleTable(String time, String goodsName, String client, String salesman, String warehouse);
	public ResultMessage deriveSaleTable(SaleTableVO vo);
	public ArrayList<ReceiptVO> viewManagementProcess(String time, String receiptType, String client, String salesman, String warehouse);
	public ResultMessage reverse(ReceiptVO vo);
	public ResultMessage reverseAndCopy(ReceiptVO vo);
	public ResultMessage deriveManagementProcess(ArrayList<ReceiptVO> List);
	public SituationTableVO viewManagementSituation(String time);
	public ResultMessage deriveManagementSituation(SituationTableVO vo);
}
