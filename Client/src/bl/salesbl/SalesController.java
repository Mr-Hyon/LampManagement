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
	public ResultMessage checkSales(SalesVO vo) throws RemoteException {
		return sales.checkSales(vo);
	}

	@Override
	public ResultMessage reverseSales(SalesVO vo) throws RemoteException {
		return sales.reverseSales(vo);
	}

}
