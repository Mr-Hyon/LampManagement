package blservice.accountblservice;

import java.util.ArrayList;
import vo.AccountVO;
import util.ResultMessage;

public interface AccountBLService {
	public ResultMessage add(AccountVO vo);
	public ResultMessage delete(AccountVO vo);
	public ResultMessage update(AccountVO vo);
	public ArrayList<AccountVO> findById(String id);
	public ArrayList<AccountVO> findByName(String name);
	public ArrayList<AccountVO> show();
}
