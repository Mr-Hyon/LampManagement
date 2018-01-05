package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.UserBLService;
import util.ResultMessage;
import util.UserType;
import vo.UserVO;

public class UserController implements UserBLService{

	User user = new User();
	@Override
	public ResultMessage add(UserVO vo) throws RemoteException {
		return user.add(vo);
	}

	@Override
	public ResultMessage delete(UserVO vo) throws RemoteException {
		return user.delete(vo);
	}

	@Override
	public ResultMessage update(UserVO vo) throws RemoteException {
		return user.update(vo);
	}

	@Override
	public ArrayList<UserVO> findById(String id) throws RemoteException {
		return user.findById(id);
	}

	@Override
	public ArrayList<UserVO> findByName(String name) throws RemoteException {
		return user.findByName(name);
	}

	@Override
	public ArrayList<UserVO> findByType(UserType type) throws RemoteException {
		return user.findByType(type);
	}

	@Override
	public ArrayList<UserVO> show() throws RemoteException {
		return user.show();
	}

	@Override
	public UserType login(String id, String password) throws RemoteException {
		return user.login(id, password);
	}

}
