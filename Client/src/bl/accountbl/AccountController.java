package bl.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.accountblservice.AccountBLService;
import util.ResultMessage;
import vo.AccountVO;

public class AccountController implements AccountBLService{

	Account account = new Account();
	@Override
	public ResultMessage add(AccountVO vo) throws RemoteException{
		return account.add(vo);
	}

	@Override
	public ResultMessage delete(AccountVO vo) throws RemoteException{
		return account.delete(vo);
	}

	@Override
	public ResultMessage update(AccountVO vo) throws RemoteException{
		return account.update(vo);
	}

	@Override
	public ArrayList<AccountVO> findById(String id) throws RemoteException{
		return account.findById(id);
	}

	@Override
	public ArrayList<AccountVO> findByName(String name) throws RemoteException{
		return account.findByName(name);
	}

	@Override
	public ArrayList<AccountVO> show() throws RemoteException{
		return account.show();
	}

}
