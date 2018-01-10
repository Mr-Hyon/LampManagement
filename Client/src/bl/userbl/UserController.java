package bl.userbl;

import java.rmi.RemoteException;
import blservice.userblservice.UserBLService;
import util.ResultMessage;
import vo.UserVO;

public class UserController implements UserBLService{

	User user = new User();
	@Override
	public ResultMessage add(UserVO vo) throws RemoteException {
		return user.add(vo);
	}

	@Override
	public ResultMessage update(UserVO vo) throws RemoteException {
		return user.update(vo);
	}

	@Override
	public ResultMessage login(String id, String password, String type) throws RemoteException {
		return user.login(id, password,type);
	}

}
