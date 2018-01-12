package bl.salesbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import bl.clientbl.Client;
import bl.commoditybl.Commodity;
import bl.userbl.User;
import common.feedback;
import po.GoodInfo;
import po.SalesPO.SalesBillPO;
import rmi.RemoteHelper;
import vo.ClientVO;
import vo.CommodityVO;
import vo.SalesVO;
import vo.UserVO;
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
		if(RemoteHelper.getInstance().getSalesBillDataService().reverseSalesBill(vo.getSalesId())==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	
	
	//transform salesVO into salesbillPO
	public SalesBillPO toSalesBillPO(SalesVO vo){
		List<GoodInfo> list = new ArrayList<GoodInfo>();
		GoodInfo goodinfo = new GoodInfo(vo.getNameofGoods(),vo.getModel(),vo.getNumber(),Double.parseDouble(vo.getPrice()),vo.getSum2(),vo.getNote2());
		list.add(goodinfo);
		SalesBillPO salesbillPO = new SalesBillPO(null,vo.getSalesId(),vo.getClient().getClientName(),vo.getStorage(),vo.getBusinessman(),vo.getOperator().getUserName(),list,vo.getSum1(),vo.getDiscount(),vo.getDiscountUsed(),vo.getSumAfterDiscount(),vo.getNote1());
		return salesbillPO;
	}
	//transform salesbillPO into salesVO
	public SalesVO toSalesVO(SalesBillPO po) throws RemoteException{
		Client client = new Client();
		ClientVO clientVO = client.findbyName(po.getSeller()).get(0);
		User user = new User();
		UserVO operator = user.findUser(po.getOperator());
		Commodity commodity = new Commodity();
		CommodityVO commodityVO = commodity.showByName(po.getGoodsList().get(0).getName()).get(0);
		SalesVO salesVO = new SalesVO(po.getBillID(),clientVO,po.getSalesman(),operator,po.getInventory(),po.getOriginPrice(),po.getRebate(),po.getVoucher(),po.getFinalPrice(),po.getRemark(),commodityVO,(int)po.getGoodsList().get(0).getAmount(),po.getGoodsList().get(0).getTotalPrice(),po.getGoodsList().get(0).getRemark());
		return salesVO;
	}
}
