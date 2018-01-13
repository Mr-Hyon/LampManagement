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
	public ResultMessage updateName(AccountVO vo, String name) throws RemoteException{
		return account.updateName(vo,name);
	}

	@Override
	public ArrayList<AccountVO> findByKeyword(String str) throws RemoteException{
		return account.findByKeyword(str);
	}

	@Override
	public AccountVO findByName(String name) throws RemoteException{
		return account.findByName(name);
	}

	@Override
	public ArrayList<AccountVO> show() throws RemoteException{
		return account.show();
	}

}
