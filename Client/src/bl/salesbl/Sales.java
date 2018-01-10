package bl.salesbl;

import java.rmi.RemoteException;

import common.feedback;
import po.SalesPO.SalesBillPO;
import rmi.RemoteHelper;
import vo.SalesVO;
import util.ResultMessage;

public class Sales {
	//add sales bill
	public ResultMessage addSales(SalesVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getSalesBillDataService().addSaleBill(toSalesBillPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//add return bill of sales
	public ResultMessage addRefunds(SalesVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getSalesBillDataService().addSaleBill(toSalesBillPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//approve sales bill and return bill
	public ResultMessage checkSales(SalesVO vo) throws RemoteException {
		if(RemoteHelper.getInstance().getSalesBillDataService().checkSaleBill(toSalesBillPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//reverse sales bill and return bill
	public ResultMessage reverseSales(SalesVO vo) throws RemoteException {
		if(RemoteHelper.getInstance().getSalesBillDataService().reverseSalesBill(vo.getId())==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	
	
	//transform salesVO into salesbillPO
	public SalesBillPO toSalesBillPO(SalesVO vo){
		SalesBillPO salesbillPO = new SalesBillPO();
		return salesbillPO;
	}
	//transform salesbillPO into salesVO
	public SalesVO toSalesVO(SalesBillPO po){
		SalesVO salesVO = new SalesVO();
		return salesVO;
	}
}
