package bl.billbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.billblservice.BillBLService;
import util.ResultMessage;
import vo.BillVO;

public class BillController implements BillBLService{

	Bill bill = new Bill();
	@Override
	public ResultMessage initial(BillVO vo) throws RemoteException{
		return bill.initial(vo);
	}

	@Override
	public ArrayList<BillVO> show() throws RemoteException {
		return bill.show();
	}

	@Override
	public ArrayList<BillVO> showInitial() throws RemoteException {
		return bill.showInitial();
	}

	@Override
	public ResultMessage update(BillVO vo) throws RemoteException {
		return bill.update(vo);
	}

	@Override
	public ResultMessage delete(BillVO vo) throws RemoteException{
		return bill.delete(vo);
	}

}
