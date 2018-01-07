package bl.salesbl;

import java.rmi.RemoteException;

import blservice.salesblservice.SalesBLService;
import vo.SalesVO;
import util.ResultMessage;

public class SalesController implements SalesBLService{

	Sales sales = new Sales();
	@Override
	public ResultMessage addSales(SalesVO vo) throws RemoteException {
		return sales.addSales(vo);
	}

	@Override
	public ResultMessage addRefunds(SalesVO vo) throws RemoteException {
		return sales.addRefunds(vo);
	}

	@Override
	public ResultMessage sendToVerify(SalesVO vo) throws RemoteException {
		return sales.sendToVerify(vo);
	}

}
