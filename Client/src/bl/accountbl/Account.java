package bl.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import common.feedback;
import po.AccountPO.AccountPO;
import rmi.RemoteHelper;
import util.ResultMessage;
import vo.AccountVO;

public class Account {
	//add account
	public ResultMessage add(AccountVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getAccountDataService().addAccount(toAccountPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//delete account
	public ResultMessage delete(AccountVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getAccountDataService().deleteAccount(vo.getAccountName())==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//update account
	public ResultMessage update(AccountVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getAccountDataService().updateAccount(toAccountPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//update account name
		public ResultMessage updateName(AccountVO vo,String name) throws RemoteException{
			if(RemoteHelper.getInstance().getAccountDataService().updateAccountName(toAccountPO(vo),name)==feedback.Success){
				return ResultMessage.SUCCESS;
			}
			else{
				return ResultMessage.FAILED;
			}
		}
	//find account by ID
	public ArrayList<AccountVO> findByKeyword(String str) throws RemoteException{
		List<AccountPO> list1 = (java.util.List<AccountPO>) RemoteHelper.getInstance().getAccountDataService().findAccountByKeyWord(str);
		ArrayList<AccountVO> list2 = new ArrayList<AccountVO>();
		for(int i = 0;i<list1.size();i++){
			list2.add(toAccountVO(list1.get(i)));
		}
		return list2;
	}
	//find account by name
	public ArrayList<AccountVO> findByName(String name) throws RemoteException{
		List<AccountPO> list1 = (java.util.List<AccountPO>) RemoteHelper.getInstance().getAccountDataService().findAccountByName(name);
		ArrayList<AccountVO> list2 = new ArrayList<AccountVO>();
		for(int i = 0;i<list1.size();i++){
			list2.add(toAccountVO(list1.get(i)));
		}
		return list2;
	}
	//show account
	public ArrayList<AccountVO> show() throws RemoteException{
		List<AccountPO> list1 = (java.util.List<AccountPO>) RemoteHelper.getInstance().getAccountDataService().showAccount();
		ArrayList<AccountVO> list2 = new ArrayList<AccountVO>();
		for(int i = 0;i<list1.size();i++){
			list2.add(toAccountVO(list1.get(i)));
		}
		return list2;
	}
	//transform accountVO into accountPO
	public static AccountPO toAccountPO(AccountVO vo){
		AccountPO accountPO = new AccountPO(vo.getAccountName(),Double.parseDouble(vo.getAccountCash()));
		return accountPO;
	}
	//transform accountPO into accountVO
	public static AccountVO toAccountVO(AccountPO po){
		AccountVO accountVO = new AccountVO(po.getName(),po.getBalance()+"");
		return accountVO;
	}
}
