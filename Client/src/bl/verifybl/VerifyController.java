package bl.verifybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.verifyblservice.VerifyBLService;
import util.ResultMessage;
import vo.TableVO;

public class VerifyController implements VerifyBLService{

	Verify verify = new Verify();
	@Override
	public ArrayList<TableVO> viewReceipts() throws RemoteException {
		return verify.viewReceipts();
	}

	@Override
	public ResultMessage pass(TableVO vo) throws RemoteException {
		return verify.pass(vo);
	}

	@Override
	public ResultMessage passAll(ArrayList<TableVO> List) throws RemoteException {
		return verify.passAll(List);
	}

	@Override
	public ResultMessage update(TableVO vo) throws RemoteException {
		return verify.update(vo);
	}

	@Override
	public ResultMessage updateCommodity(TableVO vo) throws RemoteException {
		return verify.updateCommodity(vo);
	}

	@Override
	public ResultMessage informCommodity(TableVO vo) throws RemoteException {
		return verify.informCommodity(vo);
	}

	@Override
	public ResultMessage updateCommodityAndClient(TableVO vo) throws RemoteException {
		return verify.updateCommodityAndClient(vo);
	}

	@Override
	public ResultMessage updateClient(TableVO vo) throws RemoteException {
		return verify.updateClient(vo);
	}

	@Override
	public ResultMessage informFinance(TableVO vo) throws RemoteException {
		return verify.informFinance(vo);
	}

}
